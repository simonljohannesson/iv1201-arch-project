import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../views/Home.vue';
import Applicant from '../views/Applicant.vue';
import Login from '../views/Login.vue';
import store from '../store';

Vue.use(VueRouter);

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home,
        meta: {
            authenticated: true
        }
    },
    {
        path: '/applicants',
        name: 'Applicant',
        component: Applicant,
        meta: {
            authenticated: true
        }
    },
    {
        path: '/login',
        name: 'Login',
        component: Login
    }
    // {
    //     path: '/about',
    //     name: 'About',
    //     // route level code-splitting
    //     // this generates a separate chunk (about.[hash].js) for this route
    //     // which is lazy-loaded when the route is visited.
    //     component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
    // }
];

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
});

router.beforeEach(async (to, from, next) => {
    // checks if route need authentication
    const requireAuth = to.matched.some(record => record.meta.authenticated);
    let isLoggedIn = store.getters.authenticationStatus;

    // prevents multiple checks to backend during page navigation
    if (isLoggedIn === null) {
        isLoggedIn = await store.dispatch('isAuthenticated');
    }

    if (requireAuth && !isLoggedIn) {
        next('/login');
    } else {
        next();
    }
});
export default router;
