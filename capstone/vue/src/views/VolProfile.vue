<template>
  <div id="profile">
    <div id="nav-bar">
      <img src="../img/AppLogo.png" id="main-logo" alt="logo" />

      <div id="to-go-box">
        
        <router-link :to="{ name: 'emptyMailbox' }" id="no-account">
          <img
          src="../img/Message.png"
          id="message"
          class="nav-icons"
        ></router-link>
        <img src="../img/Bell.png" id="bell" class="nav-icons" />
        <img src="../img/Hamburger.png" id="hamburger" class="nav-icons" @click="menuOpen = !menuOpen">
      </div>
    </div>

    <div id="profile-title">
      <h2 id="my-profile">MY PROFILE</h2> 
    </div>

    <div id="personal-info">
      <div class="event-box">
        <img class="event-box-logo" src="../img/ProfilePic.png" />
        <h3>NAME</h3>
        <p>EMAIL<br />PHONE NUMBER<br />ADDRESS</p>
        <button class="prof-edit">EDIT</button>
      </div>
    </div>

    <div id="profile-bio">
      <div id="bio-box"> 
        <h3>ADD BIO (Optional)</h3>
        <textarea
          id="textarea-bio"
          type="text"
          placeholder="Bio (Optional)"
          name="name"
        />
        <button class="edit-nameBio">EDIT</button>
      </div>
    </div>
    <!-- <button class="edit-nameBio">EDIT</button> -->

    <div id="bottom-half">
      <h3 id="my-hours">MY HOURS</h3>

      <div id="event-app">
        <div class="event-hours">
          <div class="hours-design">
            <h4>Where: Punchcode</h4>
            <h4>When: 12/27/2022</h4>
            <h4>Hours: 4</h4>
            <h4>Status: Pending</h4>
          </div>
          <button class="edit-hours">EDIT</button>
          <button class="btn-hours">Send</button>
        </div>
        <div class="event-hours">
          <div class="hours-design">
            <h4>Where: Punchcode</h4>
            <h4>When: 12/27/2022</h4>
            <h4>Hours: 4</h4>
            <h4>Status: Pending</h4>
          </div>
          <button class="edit-hours">EDIT</button>
          <button class="btn-hours">Send</button>
        </div>

        <div class="event-hours">
          <div class="hours-design">
            <h4>Where: Punchcode</h4>
            <h4>When: 12/27/2022</h4>
            <h4>Hours: 4</h4>
            <h4>Status: Pending</h4>
          </div>
          <button class="edit-hours">EDIT</button>
          <button class="btn-hours">Send</button>
        </div>
        <div class="event-hours">
          <div class="hours-design">
            <h4>Where: Punchcode</h4>
            <h4>When: 12/27/2022</h4>
            <h4>Hours: 4</h4>
            <h4>Status: Pending</h4>
          </div>
          <button class="edit-hours">EDIT</button>
          <button class="btn-hours">Send</button>
        </div>
        <div class="event-hours">
          <div class="hours-design">
            <h4>Where: Punchcode</h4>
            <h4>When: 12/27/2022</h4>
            <h4>Hours: 4</h4>
            <h4>Status: Pending</h4>
          </div>
          <button class="edit-hours">EDIT</button>
          <button class="btn-hours">Send</button>
        </div>
        <div class="event-hours">
          <div class="hours-design">
            <h4>Where: Punchcode</h4>
            <h4>When: 12/27/2022</h4>
            <h4>Hours: 4</h4>
            <h4>Status: Pending</h4>
          </div>
          <button class="edit-hours">EDIT</button>
          <button class="btn-hours">Send</button>
        </div>
      </div>
    </div>
     <div class="row dropdown" :class="{ 'dropdown-after' : menuOpen }">
        <div>
          <button class=dd-btn><router-link :to="{ name: 'volHome' }">View Profile</router-link></button>
          <br/>
          <button class=dd-btn><router-link :to="{ name: 'home' }" @click="clear()">Log Out</router-link></button>
        </div>
      </div>
  </div>
</template>

<script>
export default {
  name: "volProfile",
  user: {
    name: "",
    phone: "",
  },
  data() {
    return {
      menuOpen: false,
    }
  },
  methods: {
    clear(){
      // localStorage.clear();
      console.log("hahaha");
    }
  }
};
</script>

<style scoped>
#profile {
  height: 100vh;
  overflow: hidden;
}

#my-profile {
  margin: 0;
  padding: 0;
  position: relative;
  top: 20px;
}

#nav-bar {
  display: flex;
}

#to-go-box {
  float: right;
  display: flex;
  width: 110px;
  justify-content: space-between;
  align-items: center;
  padding-right: 10px;
}

.nav-icons {
  width: 6vw;
  height: 3.5vh;
}

#profile-title {
  text-align: center;
  height: 5vh;
  text-decoration: underline;
}
.prof-edit {
  float: right;
}

#personal-info {
  height: 20vh;
  width: 90vw;
  margin: auto;
  display: flex;
  align-items: center;
}

#profile-bio {
  height: 20vh;
  width: 90vw;
  margin: auto;
  display: flex;
  align-items: center;
}
#bio-box {
  width: 80vw;
  height: 15vh;
  border: 2px solid red;
  text-align: left;
  padding-left: 15px;
  border-radius: 10px;
  margin-left: 15px;
  margin-bottom: 15px;
}

#textarea-bio {
  width: 85%;
  height: 40%;
}

.edit-nameBio {
}

.event-box {
  width: 80vw;
  height: 15vh;
  border: 2px solid yellow;
  text-align: left;
  padding-left: 15px;
  border-radius: 10px;
  margin-left: 15px;
  margin-bottom: 15px;
}

#main-logo {
  display: block;
  margin-right: auto;
  width: 15%;
  position: relative;
  top: 10px;
  left: 5px;
}

.event-box-logo {
  width: 110px;
  float: right;
  position: relative;
  top: 20px;
  right: 30px;
}
#bottom-half {
  border-top: 2px solid black;
  height: 5vh;
  padding-top: 5px;
  text-align: center;
}

#my-hours {
  text-decoration: underline;
}

#event-app {
  border: 2px solid blue;
  border-radius: 10px;
  height: 41vh;
  width: 90vw;
  margin: auto;
  overflow: scroll;
}

.event-hours {
  width: 80vw;
  height: 10vh;
  border: 2px solid black;
  border-radius: 10px;
  text-align: left;
  margin: 20px;
  /* background: red; */
}

.hours-design {
  display: flex;
  margin-top: -10px;
  margin-right: -20px;
}
.edit-hours {
  float: right;
  text-align: right;
}

.btn-hours {
  width: 25%;
  height: 28%;
  float: right;
}

 #dd-title {
   letter-spacing: .8px;
 }

label {
  letter-spacing: 1px;
}

.dd-btn {
  border-radius: 10px;
  border: none;
  padding: 5px;
  margin: 2px;
  margin-bottom: 10px;
  letter-spacing: .7px;
  cursor: pointer;
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
  width: 25vw;
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
  width: 25vw;
  height: 20vh;
  position: absolute;
  top: 0;
  right:0;
  margin-top:45px;
  border-radius: 10px 0 0 10px;
}

a {
  color: black;
  text-decoration: none;
}
</style>
