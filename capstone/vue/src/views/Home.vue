<template>
  <div id="home">
    <div id="home-head">
      <div id="home-nav-bar">
        <img src="../img/AppLogo.png" id="main-logo" alt="logo">
        <div id="to-go-box">
          <img src="../img/Hamburger.png" id="hamburger" class="nav-icons" @click="menuOpen = !menuOpen">
        </div>
      </div>
      <div id="home-banner">
        <img id="main-hero-banner" src="../img/VegasSign.jpg" alt="Vegas Sign"/>
      </div>
    </div>
    <div id="home-body">
      <form action="" id="search-bar">
        <input type="text" placeholder="SEARCH">
        <input type="text" placeholder="ZIP CODE" id="zip-code">
        <select name="radius" id="radius">
                <option value="radius5">5 miles</option>
                <option value="radius10">10 miles</option>
                <option value="radius15">15 miles</option>
                <option value="radius20">20 miles</option>
                <option value="radius25+">25+ miles</option>
            </select>
      </form>
    </div>
    <div id="event-container">
        <div class="event-box" 
        v-for="event in events" 
        v-bind:key="event.id">
          <img class="event-box-logo" v-bind:src="event.orgLogo"/>
          <h3 id="org-name">{{event.name}}</h3>
          <p class="eb-desc">{{event.description}}</p>
          <p>{{event.startDate}} - {{event.endDate}}</p>
          <p>{{event.startTime}} am - {{event.endTime}} pm</p>
          <button class="volunteer-btn" @click="menuOpen = !menuOpen, mustSignIn()">Volunteer For Event</button>
        </div>
    </div> 
    <div id="main-footer"> 
      COPYRIGHT © 2022 PUNCHCODE COHORT 3
    </div>
    <!-- This code below is the hamburger opened -->
    <div class="row dropdown" :class="{ 'dropdown-after' : menuOpen }">
      <div class="navlist">
        <p id="dd-title">PLEASE SIGN IN OR CREATE AN ACCOUNT</p>
      <br/>
        <label for="vol">Volunteers</label>
        <br>
        <button class=dd-btn><router-link :to="{ name: 'regVol' }">Sign Up</router-link></button>
        <button class=dd-btn><router-link :to="{ name: 'login' }">Sign In</router-link></button>
        <br>
        <label for="org">Organization</label>
        <br>
        <button class=dd-btn><router-link :to="{ name: 'regOrg' }">Sign Up</router-link></button>
        <button class=dd-btn><router-link :to="{ name: 'login' }">Sign In</router-link></button>
      </div>
    </div>
    <img src="../img/ThreeSquareLogo.png" class="hide" alt="">
    <img src="../img/InnovateForVegas.png" class="hide" alt="">
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: "home",
  data(){
    return { 
      users: null,
      events: null,
      userId: null,
      profilePic: null,
      logInMessage: "Please Sign In or Create an Account.",
      menuOpen: false,
    }
 },
  mounted(){
    axios
      .get('http://localhost:9000/api/events')
      .then(resp => (
        this.events = resp.data,
        console.log(this.events)
      ));
  },
  methods: {
    mustSignIn(){
      alert("Please sign in or Create an Account!")
    }
  }

}

</script>

<style scoped>
#home {
  overflow: no-scroll;
  height: 100vh;
}
#home-nav-bar {
  max-height: 15vh;
  display: flex;
}
#to-go-box {
  float: right;
  padding-top: 15px;
  padding-right: 10px;
}
.nav-icons {
  width: 6vw;
  height: 3.5vh;
}
.hamburger {
  width: 35px;
  height: 5px;
  background-color: black;
  margin: 6px 0;
}
#home-body {
  text-align: center;
}
#main-hero-banner {
  max-width: 100%;
  height: auto;
}
#search-bar {
  margin-top: 10px;
  padding-bottom: 10px;
  border-bottom: 2px solid black;
}
#event-container {
  height: 53vh;
  overflow: scroll;
  padding: auto;
  padding-top: 20px;
}

.event-box {
  width: 80vw;
  height: 30vh;
  /* border: 2px solid black; */
  text-align: left;
  padding: 20px 0 0 15px;
  border-radius: 10px;
  margin: auto;
  margin-bottom: 20px;
  box-shadow: rgba(0, 0, 0, 0.16) 0px 3px 6px, rgba(0, 0, 0, 0.23) 0px 3px 6px;
}

.eb-desc {
  padding-top: 20px;
}

#main-logo {
  display: block;
  margin-right: auto;
  width: 15%;
  padding-top: 5px;
  padding-bottom: 5px;
}
.event-box-logo {
  width: 10em;
  float: right;
  position: relative;
  top: 20px;
  right: 10px;
  margin-left: 20px;
}
#main-footer {
  border-top: 2px solid black;
  padding-top: 15px;
  text-align: center;
}
h4 {
  position: relative;
  top: 20px;
}
.volunteer-btn {
  width: 180px;
  height: 55px;
  background: lightblue;
  border: none;
  border-radius: 10px;
  position: relative;
  left: 210px;
  bottom: 70px;
  box-shadow: rgba(0, 0, 0, 0.16) 0px 3px 6px, rgba(0, 0, 0, 0.23) 0px 3px 6px;
  letter-spacing: 1.4px;
  cursor: pointer;
}
#zip-code {
  width: 80px;
}

.hide {
  display: none;
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
  width: 40vw;
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
  width: 40vw;
  height: 25vh;
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

#org-name{
  font-family: Arial, Helvetica, sans-serif;
}
</style>