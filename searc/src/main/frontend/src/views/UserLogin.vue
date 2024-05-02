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
import axios from 'axios';

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
      this.error = '';  // Reset error message before a new login attempt
      axios.post('/api/login', {
        username: this.username,
        password: this.password
      })
    .then(response => {
        if (response.data === "Login successful. Redirecting to home.") {
          this.$router.push('/home');  // Redirect to home route
        } else {
          this.error = response.data;  // Show the server returned error message
        }
      }).catch(error => {
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
