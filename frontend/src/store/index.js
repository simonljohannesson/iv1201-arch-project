import Vue from 'vue';
import Vuex from 'vuex';
import { applicants as applicantApi } from '../api/applicants';
import { auth } from '../api/authenticate';
import router from '../router';

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        applicants: [],
        authenticated: null
    },
    mutations: {
        setApplicants (state, applicants) {
            state.applicants = applicants;
        },
        setAuthenticated (state, status) {
            state.authenticated = status;
        }
    },
    actions: {
        /**
         * Get applicants with pagination data
         * @param {*} state
         * @param {Object} object containg optional page and page size {page: Number, size: Number}
         * @returns list of applicants with pagination data, if not authenticated it redirects
         */
        async getApplicants (state, { page, size }) {
            const applicants = await applicantApi.get(page, size);
            state.commit('setApplicants', applicants);

            if (applicants !== 401) {
                return applicants;
            } else {
                router.push('/login');
                state.commit('setAuthenticated', false);
            }
        },
        /**
         * Logs in user
         * @param {*} state
         * @param {Object} object containg username and password {username: '', password: ''}
         * @returns true if login is succeful false otherwise
         */
        async login (state, { username, password }) {
            const status = await auth.login(username, password);
            state.commit('setAuthenticated', status);
            return status;
        },
        /**
         * Checks if current user is authenticated and saves status to store
         * @param {*} state
         * @returns true if user is authenticated false otherwise
         */
        async isAuthenticated (state) {
            const status = await auth.isAuthenticated();
            state.commit('setAuthenticated', status);
            return status;
        },
        /**
         * Create a new applicant
         * @param {*} applicantData the data required to create applicant
         * @returns http response
         */
        async createApplicant (_state, applicantData) {
            return applicantApi.create(applicantData);
        }
    },
    getters: {
        /**
         * Getter for authentication status
         * @param {*} state
         * @returns authentication status
         */
        authenticationStatus (state) {
            return state.authenticated;
        }
    },
    modules: {
    }
});
