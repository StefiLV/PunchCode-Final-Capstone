<template>
  <div id="login-page" class="text-center">

    <div id="sign-in-nav">
      <img src="../img/Hamburger.png" id="hamburger" class="nav-icons" @click="menuOpen = !menuOpen">
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
          v-model="user.username"
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
        <!-- <router-link :to="{ name: 'register' }" id="forgot-pass">Forgot Password?</router-link><br><br>
        <router-link :to="{ name: 'register' }" id="no-account">Don't have an account?</router-link> -->

        </form>
      </div>

    </div>
<!-- This code below is the hamburger opened -->
    <div class="row dropdown" :class="{ 'dropdown-after' : menuOpen }">
        <button class=dd-btn><router-link :to="{ name: 'home' }">Home</router-link></button>
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
        username: "",
        password: "",
      },
      invalidCredentials: false,
      menuOpen: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$store.commit("SET_USER_ID", response.data.user.userId);
            console.log(response.data.user)
            if(response.data.user.organization == false){
              this.$router.push("/volHome");
            } else {
              this.$store.commit("SET_ORG_PIC", response.data.user.profilePic);
              this.$router.push("/orgProfile");
            }
            
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

#hamburger {
  width: 6%;
  float: right;
  padding-top: 15px;
  padding-right: 10px;
}

.dropdown {
  text-align: center;
  height: 0px;
  background: lightblue;
  transition: height 0.2s ease;
  display: flex;
  align-items: center;
  justify-content: center;
  overflow: hidden;
  width: 20vw;
  position: absolute;
  top: 0;
  right:0;
  margin-top:45px;
  border-radius: 10px 0 0 10px;
}
.dropdown-after {
  text-align: center;
  height: calc(100vh - 50px);
  transition: height 0.2s ease;
  width: 20vw;
  height: 10vh;
  position: absolute;
  top: 0;
  right:0;
  margin-top:45px;
  border-radius: 10px 0 0 10px;
}

.dd-btn {
  border-radius: 10px;
  border: none;
  padding: 5px;
  margin: 2px;
  letter-spacing: .7px;
  cursor: pointer;
}

a {
  color: black;
  text-decoration: none;
}
</style>