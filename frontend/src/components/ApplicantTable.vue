<template>
    <div class="container">
        <div class="row">
            <h1>Applicants</h1>

        </div>
        <div class="row">
            <b-table striped hover :items="a"></b-table>
        </div>
        <div class="row">
            <b-pagination v-model="currentPage" :total-rows="rows" :per-page="perPage" aria-controls="my-table" @input="load()"></b-pagination>
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
            a: [],
            currentPage: 1,
            realPage: 0,
            rows: 100,
            perPage: 10
        };
    },
    methods: {
        ...mapActions(['getApplicants']),
        async load () {
            const app = await this.getApplicants(this.currentPage - 1);
            console.log(app.pageable.pageNumber);
            this.a = app.content;
            this.realPage = app.pageable.pageNumber;
            this.currentPage = this.realPage + 1;
            this.rows = app.totalElements;
            this.perPage = app.size;
        }
    },
    mounted () {
        this.load();
    }
};
</script>
<style>

</style>
