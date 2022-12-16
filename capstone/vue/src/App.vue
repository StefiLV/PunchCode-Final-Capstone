<template>
  <div id="app">
    <router-view />
  </div>
</template>
<style>
HTML, body {
margin: 0px;
padding: 0px;
  border: 0px;
}
</style>

// <div id="nav">
//       <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
//       <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
//     </div>