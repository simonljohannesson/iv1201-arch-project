<template>
    <div class="container justify-content-center">
        <div class="row">
            <applicant-table/>
        </div>
    </div>
</template>
<script>
// import ApplicantTable from '@/components/ApplicantTable.vue'
import ApplicantTable from '../components/ApplicantTable.vue';
export default {
    components: { ApplicantTable },
    name: 'First'
};
</script>
<style lang="">

</style>
