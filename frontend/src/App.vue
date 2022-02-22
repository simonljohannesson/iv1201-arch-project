<template>
    <div id="app">
        <div v-if="authenticated === true">
            <b-navbar toggleable="lg" type="dark" variant="dark">
                <b-navbar-brand @click="toHomeView()">Recruitment Application</b-navbar-brand>
                <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
                <b-collapse id="nav-collapse" is-nav>
                    <b-navbar-nav>
                    <b-nav-item><router-link tag="li" to="/applicants">Applicant</router-link></b-nav-item>
                    </b-navbar-nav>
                </b-collapse>
            </b-navbar>

            <!-- Page content under navbar -->
            <div class="container-fluid">
                <router-view/>
            </div>
        </div>
        <div v-else>
            <router-view></router-view>
        </div>
    </div>
</template>
<script>
import { mapActions, mapState } from 'vuex';
export default {
    data () {
        return {
            status: false
        };
    },
    methods: {
        ...mapActions(['isAuthenticated']),
        toHomeView () {
            this.$router.push('/');
        },
        async checkAuth () {
            this.status = await this.isAuthenticated();
        }
    },
    async created () {
        console.log('hejekgergerj');
        await this.checkAuth();
    },
    computed: mapState(['authenticated'])
};
</script>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
nav li:hover,
nav li.router-link-active,
nav li.router-link-exact-active {
   /* background-color: rgb(52, 159, 201); */
   font-weight: bolder;

   cursor: pointer;
 }
</style>
