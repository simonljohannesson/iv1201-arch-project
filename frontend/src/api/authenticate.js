import { sendRequest } from './baseRequest';

const auth = {
    /**
     * Checks if user is currently authenticated using session cookies
     * @returns true if authenticated false otherwise
     */
    isAuthenticated: async () => {
        try {
            const requestConfig = {
                method: 'GET',
                url: '/user'
            };

            const response = await sendRequest(requestConfig);
            return response.data.authenticated;
        } catch (error) {
            if (error.response.status === 401) {
                return false;
            } else {
                throw error;
            }
        }
    },
    /**
     * Attempts to log in user
     * @param {String} user usernmae to log in with
     * @param {String} pass password to log in with
     * @returns true if login succeful otherwise error object
     */
    login: async (user, pass) => {
        try {
            const requestConfig = {
                method: 'GET',
                url: '/user',
                auth: {
                    username: user,
                    password: pass
                }
            };

            const response = await sendRequest(requestConfig);
            return response.data.authenticated;
        } catch (error) {
            if (error.response.status === 401) {
                return { status: error.response.status, msg: 'try again' };
            } else {
                throw error;
            }
        }
    }
};

export { auth };
