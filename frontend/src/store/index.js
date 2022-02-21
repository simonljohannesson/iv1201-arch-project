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
        async getApplicants (state, { page, size }) {
            try {
                const auth = Buffer.from(process.env.VUE_APP_DEBUG_USER + ':' + process.env.VUE_APP_DEBUG_PASSWORD).toString('base64');
                const applicants = await applicantDB.get(page, size, auth);
                state.commit('setApplicants', applicants);
                return applicants;
            } catch (error) {
                return error;
            }
        }
    },
    modules: {
    }
});
