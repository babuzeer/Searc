<template>
  <div class="login-container">
    <h1>Login</h1>
    <form @submit.prevent="login">
      <div>
        <label for="username">Username:</label>
        <input id="username" v-model="username" type="text" required>
      </div>
      <div>
        <label for="password">Password:</label>
        <input id="password" type="password" v-model="password" required>
      </div>
      <div>
        <button type="submit">Login</button>
      </div>
      <p v-if="error">{{ error }}</p>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: '',
      password: '',
      error: ''
    };
  },
  methods: {
    login() {
      this.error = '';  // 在尝试新的登录之前重置错误消息
      this.$http.post('/login', {
        username: this.username,
        password: this.password
      }).then(() => {
        // 如果没有返回错误则认为登录成功
        this.$store.commit('setUsername', this.username);  // Store username in Vuex
        this.$router.push('/home');
      }).catch(error => {
        // 错误处理，如果登录无效则显示错误消息
        if (error.response && error.response.status === 401) {
          this.error = 'Invalid username or password.';
        } else {
          this.error = 'An error occurred. Please try again.';
        }
      });
    }
  }
};
</script>

<style scoped>
.login-container {
  width: 300px;
  margin: auto;
  padding: 20px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
input[type="text"], input[type="password"] {
  width: 100%;
  padding: 8px;
  margin: 10px 0;
}
button {
  width: 100%;
  padding: 8px;
  background-color: #42b983;
  color: white;
  border: none;
  cursor: pointer;
}
button:hover {
  background-color: #368a77;
}
</style>
