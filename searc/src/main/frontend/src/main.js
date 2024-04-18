import Vue from 'vue'
import App from './App.vue'
import Axios from 'axios';
import router from './router';

Vue.prototype.$http = Axios;
Vue.config.productionTip = false

new Vue({
  router,
  store,   // 使用 Vuex 状态管理
  render: h => h(App),
}).$mount('#app')
