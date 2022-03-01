<template>
    <b-container>
        <b-row>
            <h1>Applicants</h1>
        </b-row>
        <b-row>
            <b-container>
                <b-row>
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
                    <applicant-modal :applicant-data="applicantData"/>
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
import { applicants } from '../api/applicants';
import ApplicantModal from './ApplicantModal';
export default {
    name: 'ApplicantTable',
    components: [
        ApplicantModal
    ],
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
            applicantData: {
                availability: [],
                competence: []
            },
            /* TODO could be hardcoded in frontend */
            competences: {
                1: 'ticket sales',
                2: 'lotteries',
                3: 'roller coaster operation'
            }
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
        async onRowSelected ([selected]) {
            /* show the popup window */
            if (selected) {
                try {
                    const data = await applicants.getApplication(selected.id);
                    this.applicantData = data;

                    this.$bvModal.show('applicant-modal');
                    this.viewApplicant = selected;
                } catch (error) {
                    this.loadingError = true;
                }
            }
            this.selected = selected;
        },
        acceptApplicant () {
            alert('Applicant was accepted');
        },
        rejectApplicant () {
            alert('Applicant was rejected');
        }
    },
    mounted () {
        this.loadApplicants();
        this.$root.$on('bv::modal::hidden', () => {
            this.$refs.applicantTable.clearSelected();
        });
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
