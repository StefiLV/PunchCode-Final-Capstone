<template>
  <div id="regOrg" class="text-center">
    <div id="regOrgNav"></div>

    <div id="regOrgLogo"></div>

    <div id="regOrgBody">
      <form class="form-register" @submit.prevent="register">
        <input
          type="text"
          id="username"
          class="form-control"
          placeholder="USERNAME"
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
          placeholder="ORGANIZATION"
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
        <button
          class="btn btn-lg btn-primary btn-block"
          type="submit"
        >
          Create Account
        </button>
      </form>
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
      },
      registrationErrors: false,
      registrationErrorMsg:
        "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg =
          "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
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
  height: 33vh;
}

#regOrgBody {
  height: 62vh;
  background-image: url("../img/RegBG.jpg");
  background-repeat: no-repeat;
}
</style>
