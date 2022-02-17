import Vue from 'vue';
import Vuex from 'vuex';
import { applicants as applicantDB } from '../api/applicants';

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        applicants: []
    },
    mutations: {
        setApplicants (state, applicants) {
            state.applicants = applicants;
        }
    },
    actions: {
        async getApplicants (state, page, size) {
            const applicants = await applicantDB.get(page, size);
            console.log(applicants);
            state.commit('setApplicants', applicants);
            return applicants;
        }
    },
    modules: {
    }
});
