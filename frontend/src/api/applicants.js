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
            const res = await sendRequest('get', url);
            return res.data;
        } catch (error) {
            return error.response.status;
        }
    }
};

export { applicants };
