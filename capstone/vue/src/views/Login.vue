<template>
  <div id="login-page" class="text-center">

    <div id="sign-in-nav">
      <div id="to-go-box" v-on:click="openBurger">
          <div class="hamburger"></div>
          <div class="hamburger"></div>
          <div class="hamburger"></div>
      </div>
    </div>  

    <div id="sign-in-head">
      <img src="../img/AppLogo.png" id="main-logo" alt="logo">
    </div>

    <div id="sign-in-body">
      <div id="sign-in-form">
        <form @submit.prevent="login">

        <input
          type="text"
          id="email"
          class="form-control"
          placeholder="EMAIL"
          v-model="user.email"
          required
          autofocus
        /><br>
      
        <input
          type="password"
          id="password"
          class="form-control"
          placeholder="PASSWORD"
          v-model="user.password"
          required
        /><br>

        <button id="sign-in-btn" type="submit">SIGN IN</button><br>
        <router-link :to="{ name: 'register' }" id="forgot-pass">Forgot Password?</router-link><br><br>
        <router-link :to="{ name: 'register' }" id="no-account">Don't have an account?</router-link>

        </form>
      </div>

    </div>

  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        email: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    openBurger(){},
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>

#login-page {
  height: 100vh;
  width: 100vw;
}

#to-go-box {
  float: right;
  margin-right: 10px;
}

#sign-in-nav {
  height: 5vh;
}

#sign-in-head {
  height: 33vh;
}

#sign-in-body {
  height: 62vh;
  background-image: url("../img/SignInBG.jpg");
  background-repeat: no-repeat;
}

#sign-in-form {
  height: 300px;
  text-align: center;
  margin: auto;
  padding-top: 15vh;
}

#main-logo {
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 400px;
}

.form-control {
  width: 65vw;
  height: 40px;
  margin-bottom: 40px;
  border-radius: 5px;
  border: 1px solid white;
}

.form-control:focus {
  font-size: 20px;
}

.form-control::placeholder {
  color: black;
  letter-spacing: 4px;
  padding-left: 10px;
}

.hamburger {
    width: 35px;
    height: 5px;
    background-color: black;
    margin: 6px 0;
}

#sign-in-btn {
  background: #F34727;
  border: 1px solid #F34727;
  color: white;
  width: 35vw;
  height: 45px;
  border-radius: 5px;
  margin-bottom: 25px;
}

#sign-in-btn:hover {
  cursor: pointer;
}

#forgot-pass, #no-account {
  color: white;
}


</style>