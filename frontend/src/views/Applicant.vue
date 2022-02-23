<template>
    <div class="container">
        <div class="row">
            <applicant-table/>
        </div>
    </div>
</template>

<script>
import ApplicantTable from '../components/ApplicantTable.vue';
export default {
    name: 'Applicant',
    components: { ApplicantTable }
};
</script>

<style lang="">

</style>
