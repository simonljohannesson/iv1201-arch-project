import { sendRequest } from './baseRequest';

const applicants = {
    /**
     * Gets applicants
     * @param {Number} page pagenumber to be loaded, can be omitted
     * @param {Number} size how many applicants that should be loaded in, can be omitted
     * @returns an object container applicants and paging info
     */
    get: async (page, size) => {
        let url = 'users/applicants?';
        if (page) url += 'page=' + page;
        if (size) url += '&size=' + size;
        try {
            const requestConfig = {
                method: 'GET',
                url: url
            };

            const res = await sendRequest(requestConfig);
            return res.data;
        } catch (error) {
            return error.response.status;
        }
    },
    /**
     * Try to create a new applicant
     * @param {*} applicantData 
     * @returns Promise
     */
    create: async (applicantData) => {
        const requestConfig = {
            method: 'POST',
            url: '/users/applicants',
            data: applicantData
        };
        return await sendRequest(requestConfig);
    },
    getApplication: async (applicantId) => {
        try {
            const requestConfig = {
                method: 'GET',
                url: `/users/applicants/${applicantId}/data`
            };
            const res = await sendRequest(requestConfig);
            return res.data;
        } catch (error) {
            return error.response.status;
        }
    }
};

export { applicants };
