<template>
    <b-modal id="applicant-modal"
        :title="`${viewApplicant.name} ${viewApplicant.lastName}`"
    >
        <b-container>Name: <b>{{`${viewApplicant.name} ${viewApplicant.lastName}`}}</b></b-container>
        <b-container>Email: <b>{{viewApplicant.email}}</b></b-container>
        <b-container>Person number: <b>{{viewApplicant.pnr}}</b></b-container>

        <h3>Competence</h3>
        <b-table
            ref="competenceTable"
            striped
            :items="competence"
            show-empty
        >
            <template #empty>
                <h4>No competence to show</h4>
            </template>
        </b-table>
        <h3>Availability</h3>
        <b-table
            ref="availabilityTable"
            striped
            :items="applicantData.availability"
            show-empty
        >
            <template #empty>
                <h4>No availability to show</h4>
            </template>
        </b-table>

        <!-- Modal footer -->
        <template #modal-footer>
            <!-- Emulate built in modal footer ok and cancel button actions -->
            <b-button size="lg" variant="success" @click="acceptApplicant()">
                Accept
            </b-button>
            <b-button size="lg" variant="danger" @click="rejectApplicant()">
                Reject
            </b-button>
        </template>
    </b-modal>
</template>

<script>
export default {
    name: 'applicant-modal',
    props: {
        'applicant-data': Object
    },
    computed: {
        competence () {
            return this.applicantData.competence?.map((c) => {
                const comp = this.competences[c.competenceId];

                return {
                    competence: comp.charAt(0).toUpperCase() + comp.slice(1), // capitalize
                    yearsOfExperience: c.yearsOfExperience
                };
            });
        }
    }
};
</script>

<style>

</style>
