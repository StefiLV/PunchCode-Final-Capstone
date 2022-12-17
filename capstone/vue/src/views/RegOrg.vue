<template>
  <div id="regOrg" class="text-center">
    <div id="regOrgNav">
      <div id="to-go-box" v-on:click="openBurger">
        <img src="../img/Hamburger.png" id="hamburger" />
      </div>
    </div>

    <div id="regOrgLogo">
      <img id="main-logo" src="../img/AppLogo.png" alt="" />
      <h2>Organization Sign Up</h2>
    </div>

    <div id="regOrgBody">
      <div id="regOrgForm">
        <form class="form-register" @submit.prevent="register">
          <input
            type="text"
            id="username"
            class="form-control"
            placeholder="EMAIL"
            v-model="user.username"
            required
            autofocus
          /><br />
          <input
            type="password"
            id="password"
            class="form-control"
            placeholder="PASSWORD"
            v-model="user.password"
            required
          /><br />
          <input
            type="password"
            id="confirmPassword"
            class="form-control"
            placeholder="CONFIRM PASSWORD"
            v-model="user.confirmPassword"
            required
          /><br />
          <input
            type="orgName"
            id="orgName"
            class="form-control"
            placeholder="ORGANIZATION NAME"
            v-model="user.orgName"
            required
          /><br />
          <input
            type="address"
            id="address"
            class="form-control"
            placeholder="ADDRESS"
            v-model="user.address"
            required
          /><br />
          <input
            type="city"
            id="city"
            class="form-control"
            placeholder="CITY"
            v-model="user.city"
            required
          /><br />
          <input
            type="state"
            id="state"
            class="form-control"
            placeholder="STATE"
            v-model="user.state"
            required
          /><br />
          <input
            type="zipCode"
            id="zipCode"
            class="form-control"
            placeholder="ZIP CODE"
            v-model="user.zipCode"
            required
          /><br />
          <input
            id="regOrgBtn"
            type="submit" 
            value="SUBMIT"
            />
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "regOrg",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
        organization: true,
      },
      registrationErrors: false,
      registrationErrorMsg:
        "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        console.log("this shit didnt work");
        this.registrationErrors = true;
        this.registrationErrorMsg =
          "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            console.log("this shit work");
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg =
                "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg =
        "There were problems registering this user.";
    },
  },
};
</script>

<style scoped>
#regOrgNav {
  height: 5vh;
}

#regOrgLogo {
  height: 25vh;
}

#main-logo {
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 265px;
}

h2 {
  text-align: center;
  text-decoration: underline;
}

#regOrgBody {
  height: 70vh;
  background-image: url("../img/RegBG.png");
  background-repeat: no-repeat;
  background-position: 43% 30%;
}

#regOrgForm {
  height: 300px;
  text-align: center;
  margin: auto;
  padding-top: 5vh;
}

.form-control {
  width: 65vw;
  height: 35px;
  margin-bottom: 30px;
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

#regOrgBtn {
  background: #0045b8;
  border: 1px solid #0045b8;
  color: white;
  width: 35vw;
  height: 45px;
  border-radius: 5px;
  margin-bottom: 25px;
}

#to-go-box {
  float: right;
  padding-top: 15px;
  padding-right: 10px;
}

#hamburger {
  width: 6%;
  float: right;
  margin-top: 5px;
}
</style>
