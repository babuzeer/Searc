import Vue from 'vue';
import Router from 'vue-router';
import Home from '../views/UserHome.vue';
import Login from '../views/UserLogin.vue';
import Register from '../views/UserRegister.vue';  // 确保路径正确
import Map from '../views/UserMap.vue';  // 确保路径正确
import Plan from '../views/UserPlan.vue';  // 确保路径正确
import Diary from '../views/UserDiary.vue';  // 确保路径正确

Vue.use(Router);

export default new Router({
  mode: 'history',  // 使用 HTML5 History 模式
  routes: [
    {
      path: '/home',
      name: 'Home',
      component: Home,
      meta: { requiresAuth: true }  // 需要登录才能访问
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/register',
      name: 'Register',
      component: Register
    },
    {
      path: '/map',
      name: 'Map',
      component: Map,
      meta: { requiresAuth: true }  // 需要登录才能访问
    },
    {
      path: '/plan',
      name: 'Plan',
      component: Plan,
      meta: { requiresAuth: true }  // 需要登录才能访问
    },
    {
      path: '/diary',
      name: 'Diary',
      component: Diary,
      meta: { requiresAuth: true }  // 需要登录才能访问
    }
  ]
});
