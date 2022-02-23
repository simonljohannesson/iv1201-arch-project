<template>
    <b-container>
        <b-row>
            <h1>Applicants</h1>
        </b-row>
        <b-row>
            <b-container>
                <b-row>
                    <!-- <b-col> -->
                        <b-table
                            ref="applicantTable"
                            striped
                            hover
                            :items="list"
                            :busy="loading"
                            :selectable="true"
                            select-mode="single"
                            @row-selected="onRowSelected"
                        >
                            <template #table-busy>
                                <div v-if="!loadingError" class="text-center text-primary my-2">
                                    <b-spinner class="align-middle"></b-spinner>
                                    <strong>Loading...</strong>
                                </div>
                                <div v-else class="text-danger">
                                    <b-icon icon="exclamation-circle-fill"></b-icon>
                                    <strong>Something went wrong, try again by reloading</strong>
                                </div>
                            </template>
                        </b-table>
                    <!-- </b-col>
                    <b-col> -->
                        <b-modal id="applicant-modal"
                            :title="`${viewApplicant.name} ${viewApplicant.lastName}`"
                        >
                            <b-container>Name: {{`${viewApplicant.name} ${viewApplicant.lastName}`}}</b-container>
                            <b-container>Email: {{viewApplicant.email}}</b-container>
                            <b-container>Person number: {{viewApplicant.pnr}}</b-container>
                            <h3>Availability</h3>
                            <b-table
                                ref="availabilityTable"
                                striped
                                hover
                                :items="availabilityList"
                            >
                            </b-table>
                        </b-modal>
                    <!-- </b-col> -->
                </b-row>
            </b-container>
        </b-row>
        <b-row>
            <div class="col-auto">
                <b-form-select v-model="perPage" :options="quantityOptions" @input="loadApplicants"></b-form-select>
            </div>
            <b-pagination v-model="currentPage" :total-rows="rows" :per-page="perPage" aria-controls="my-table" @input="loadApplicants"></b-pagination>
        </b-row>
    </b-container>
</template>
<script>
import { mapActions } from 'vuex';
export default {
    name: 'ApplicantTable',
    props: ['applicants'],
    data () {
        return {
            list: [],
            currentPage: 1,
            realPage: 0,
            rows: 100,
            perPage: 10,
            loading: false,
            quantityOptions: [10, 20, 50, 100],
            loadingError: false,
            selected: undefined,
            viewApplicant: {},
            availabilityList: [
                {
                    from_date: '2020-05-06',
                    to_date: '2020-06-06'
                },
                {
                    from_date: '2020-07-06',
                    to_date: '2020-08-06'
                },
                {
                    from_date: '2020-08-27',
                    to_date: '2020-09-27'
                },
                {
                    from_date: '2020-05-06',
                    to_date: '2020-06-06'
                },
                {
                    from_date: '2020-07-06',
                    to_date: '2020-08-06'
                },
                {
                    from_date: '2020-08-27',
                    to_date: '2020-09-27'
                }
            ]
        };
    },
    methods: {
        ...mapActions(['getApplicants']),
        async loadApplicants () {
            this.loadingError = false;
            this.loading = true;
            try {
                const applicants = await this.getApplicants({ page: this.currentPage - 1, size: this.perPage });
                this.list = applicants.content;
                this.realPage = applicants.pageable.pageNumber;
                this.rows = applicants.totalElements;
                this.loading = false;
                this.viewApplicant = this.list[0];
            } catch (error) {
                this.loadingError = true;
            }
        },
        onRowSelected ([selected]) {
            console.log(selected);

            if (selected) {
                this.$bvModal.show('applicant-modal');
                this.viewApplicant = selected;
            }
            this.selected = selected;
        }
    },
    mounted () {
        this.loadApplicants();
        this.$root.$on('bv::modal::hidden', () => {
            this.$refs.applicantTable.clearSelected();
        });
    },
    computed: {
    },
    watch: {
    }
};
</script>
<style>

</style>
