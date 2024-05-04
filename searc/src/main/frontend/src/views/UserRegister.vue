<template>
  <div class="register-container">
    <h1>Register</h1>
    <form @submit.prevent="register">
      <div>
        <label for="username">Username:</label>
        <input id="username" v-model="username" type="text" required>
      </div>
      <div>
        <label for="email">Email:</label>
        <input id="email" v-model="email" type="email" required>
      </div>
      <div>
        <label for="password">Password:</label>
        <input id="password" v-model="password" type="password" required>
      </div>
      <div>
        <button type="submit">Register</button>
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
      email: '',  // Add email to the data properties
      password: '',
      error: ''
    };
  },
  methods: {
    register() {
      this.error = '';  // Reset error message before a new attempt
      axios.post('/api/register', {
        username: this.username,
        email: this.email,  // Include email in the request
        password: this.password
      }).then(response => {
        if (response.data==="User registered successfully") {
          this.$router.push('/login');  // Redirect to login on successful registration
          alert('Registration successful. You can now log in.');
        } else {
          this.error = response.data.message;  // Show error from server
        }
      }).catch(error => {
        this.error = error.response && error.response.data.message ? 
                     error.response.data.message : 
                     'An error occurred during registration. Please try again.';
      });
    }
  }
};
</script>

<style scoped>
.register-container {
  width: 300px;
  margin: auto;
  padding: 20px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
input[type="text"], input[type="email"], input[type="password"] {
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
