<template>
  <div id="app">
    <h1>Welcome to the App</h1>
    <button @click="$router.push('/login')">Login</button>
    <button @click="$router.push('/register')">Register</button>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
#app {
  text-align: center;
  margin-top: 60px;
}
button {
  margin: 10px;
  padding: 10px 20px;
}
</style>
