const fetch = require('node-fetch');

/**
 * Sends request to given parameters
 * @param {String} url api endpoint
 * @param {Object} options with options
 * @returns json object if succeful
 */
async function sendRequest (url, options) {
    try {
        const res = await fetch(url, options);
        if (res.ok) {
            return await res.json();
        } else {
            throw new Error(res.statusText);
        }
    } catch (error) {
        throw new Error(error);
    }
}

const applicants = {
    /**
     * Gets applicants from the database
     * @returns array with applicants
     */
    get: async (page, size) => {
        let url = process.env.VUE_APP_REST_SERVER_ADRESS + 'users/applicants?';
        if (page) url += 'page=' + page;
        if (size) url += 'size=' + size;
        const options = {
            method: 'GET'
        };

        return await sendRequest(url, options);
    }
};

export { applicants };
