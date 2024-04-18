import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    username: null  // 用于存储用户名
  },
  mutations: {
    setUsername(state, username) {
      state.username = username;
    }
  },
  actions: {
    login({ commit }, username) {
      commit('setUsername', username);
      // 这里可以添加登录逻辑
    }
  }
});
