<template>
    <div class="container">
        <div class="row">
            <h1>Applicants</h1>

        </div>
        <div class="row">
            <b-table striped hover :items="list" :busy="loading">
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
        </div>
        <div class="row">
            <div class="col-auto">
                <b-form-select v-model="selected" :options="quantityOptions" @input="loadApplicants()"></b-form-select>
            </div>
            <b-pagination v-model="currentPage" :total-rows="rows" :per-page="perPage" aria-controls="my-table" @input="loadApplicants()"></b-pagination>
        </div>
    </div>
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
            selected: 10,
            quantityOptions: [10, 20, 50, 100],
            loadingError: false
        };
    },
    methods: {
        ...mapActions(['getApplicants']),
        async loadApplicants () {
            this.loadingError = false;
            this.loading = true;
            try {
                const app = await this.getApplicants({ page: this.currentPage - 1, size: this.selected });
                this.list = app.content;
                this.realPage = app.pageable.pageNumber;
                this.currentPage = this.realPage + 1;
                this.rows = app.totalElements;
                this.perPage = app.size;
                this.loading = false;
            } catch (error) {
                this.loadingError = true;
            }
        }
    },
    mounted () {
        this.loadApplicants();
    }
};
</script>
<style>

</style>
