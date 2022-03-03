<template>
    <div class="container">
        <b-card title="Recruitment application login">
            <b-form @submit.prevent="submit">
                <b-form-input
                    type="text"
                    id="login"
                    class="fadeIn second w-75 mb-3 mx-auto"
                    name="login"
                    placeholder="login"
                    v-model="username"
                />
                <b-form-input
                    type="password"
                    id="password"
                    class="fadeIn third w-75 mb-3 mx-auto"
                    name="login"
                    placeholder="password"
                    v-model="password"
                />
                <b-alert v-if="error" variant="danger" show>{{error}}</b-alert>
                <b-button
                    type="submit"
                    class="fadeIn fourth"
                    variant="primary"
                    >Login</b-button
                >
            </b-form>
            <b>Don't have an account?<b-button @click="signup" variant="link">Sign up</b-button></b>

        </b-card>
    </div>
</template>
<script>
import { mapActions } from 'vuex';
export default {
    data () {
        return {
            username: '',
            password: '',
            error: ''
        };
    },
    methods: {
        ...mapActions(['login']),
        async submit () {
            this.error = '';
            const status = await this.login({ username: this.username, password: this.password });
            if (status === true) this.$router.push('/');
            else this.error = status.msg;
        },
        signup () {
            this.$router.push('/signup');
        }
    }
};
</script>
<style lang="">

</style>
