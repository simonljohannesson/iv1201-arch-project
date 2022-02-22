const axios = require('axios');

axios.defaults.baseURL = process.env.VUE_APP_REST_SERVER_ADRESS;
axios.defaults.withCredentials = true;

/**
 * General request function for request to api, it handles sessions. Error handling
 * is passed to component using this.
 * @param {String} method to be used, i.e 'get', 'post', 'delete' etc
 * @param {String} endpoint to be accessed without baseURL included
 * @param {boolean} auth if user needs to authenticate, can be omitted if already is logged in
 * @returns axios response schema
 */
export async function sendRequest (method, endpoint, username, password) {
    const config = {
        method: method,
        url: endpoint
    };
    if (username && password) {
        config.auth = {
            username: username,
            password: password
        };
    }
    return await axios(config);
}
