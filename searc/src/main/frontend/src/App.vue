<template>
  <div id="app">
    <el-container>
      <!-- 如果未认证，显示登录和注册按钮 -->
      <el-main v-if="!isAuthenticated">
        <el-button type="primary" @click="$router.push('/login')">登录</el-button>
        <el-button type="primary" @click="$router.push('/register')">注册</el-button>
        <router-view/>
      </el-main>

      <!-- 认证后显示应用主界面 -->
      <el-container v-else>
        <el-aside width="20%" style="background-color: black; position: relative;">
          <img src="@/assets/logo.png" alt="Logo" class="sidebar-logo"/>
          <el-menu :default-active="activeIndex" class="el-menu-vertical-demo">
            <el-menu-item index="1" @click="changeRoute('/home')">Home</el-menu-item>
            <el-menu-item index="2" @click="changeRoute('/map')">地图</el-menu-item>
            <el-menu-item index="3" @click="changeRoute('/plan')">行程规划</el-menu-item>
            <el-menu-item index="4" @click="changeRoute('/diary')">日记</el-menu-item>
            <el-menu-item index="5" @click="performLogout">登出</el-menu-item>
            <img src="@/assets/logo.png" alt="Logo" class="sidebar-logo"/>
          </el-menu>
        </el-aside>
        <el-main>
          <router-view/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>


<script>
import { mapState, mapActions } from 'vuex';

export default {
  computed: {
    ...mapState([
      'isAuthenticated'
    ])
  },
  methods: {
  ...mapActions([
    'logout' // 从 Vuex 映射的 'logout' 动作
  ]),
  performLogout() { // 改变本地登出方法名称
    this.logout(); // 调用 Vuex action 清除状态
    this.$router.push('/'); // 重定向到根页面
  },
  changeRoute(route) {
    this.$router.push(route);
  }
  }
};
</script>

<style scoped>
.sidebar-logo {
  width: 100%; /* 设置图片宽度为导航栏宽度的100% */
  height: auto; /* 高度自动调整以保持图片比例 */
  margin-bottom: 20px; /* 在图片和菜单项之间添加一些空间 */
}
</style>
