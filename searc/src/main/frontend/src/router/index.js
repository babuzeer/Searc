import Vue from 'vue';
import Router from 'vue-router';
import Home from '../views/UserHome.vue';
import Login from '../views/UserLogin.vue';

Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/home',
      name: 'Home',
      component: Home,
      meta: { requiresAuth: true }
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    }
  ]
});
