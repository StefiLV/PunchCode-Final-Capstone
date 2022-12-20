<template>
  <div id="home">

    <div id="home-head">

      <div id="home-nav-bar">
        <img src="../img/AppLogo.png" id="main-logo" alt="logo">
        <div id="to-go-box">
          <img src="../img/Hamburger.png" id="hamburger" class="nav-icons">

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
       <div id="event-box"
       v-for="event in events" 
      v-bind:key="event.id"
      >
      <!-- <div id="vol-events"
       v-for="user in users" 
      v-bind:key="user.id"
      > -->
      <div class="event-box" >
          <img class="event-box-logo" v-bind:src="event.orgLogo"/>
          <h3>{{event.name}}</h3> 
          <h4>{{event.address}}</h4>
          <p>{{event.description}}</p>
          <p>Start Date: {{event.startDate}}</p>
          <p>End Date: {{event.endDate}}</p>
          <!-- <button class="expand-btn">See More</button> -->
        </div>

   <!-- <div class="event-box">
          <img class="innovate-for-vegas-logo" src="../img/InnovateForVegas.png"/>
        <h3>{{event.name}}</h3>
          <h4>{{event.address}}</h4>
          <p>{{event.description}}</p>
        </div> 
    
       <div class="event-box">
          <img class="event-box-logo" src="../img/ThreeSquareLogo.png"/>
          <h4>Three Square<br/>4190 N Pecos Rd<br/>Nov. 1, 2022 - Dec. 23, 2022</h4>
        </div>

        <div class="event-box">
          <img class="event-box-logo" src="../img/PunchCodeLogo.png"/>
          <h4>PunchCode<br/>401 S. 4th St<br/>Nov. 1, 2022 - Dec. 23, 2022</h4>
        </div>

        <div class="event-box">
          <img class="innovate-for-vegas-logo" src="../img/InnovateForVegas.png"/>
          <h4>Innovate For Vegas<br/>4th St and Lewis Ave<br/>Nov. 1, 2022 - Dec. 23, 2022</h4>
        </div>
        
        <div class="event-box">
          <img class="event-box-logo" src="../img/ThreeSquareLogo.png"/>
          <h4>Three Square<br/>4190 N Pecos Rd<br/>Nov. 1, 2022 - Dec. 23, 2022</h4>
        </div> -->

      </div> 

      <div id="main-footer"> 
        COPYRIGHT © 2022 PUNCHCODE COHORT 3
      </div>

    </div>

  <!-- </div> -->
</template>

<script>
import axios from 'axios';
import eventService from '../services/EventService.js';
// import authService from '../services/AuthService.js';
export default {
  name: "home",
  data(){
    return { 
      // users: null,
      events: null,
      userId: null,
      profilePic: null,
    }
  },
  
  created() {
  eventService.list().then((res) => {
      this.event = res.data;
    })
    .catch((err) => {
      console.error(err + ' uh oh missing product');
    })
    
 },
// userCreated(){
//       eventService.getUsers().then((res) => {
//       this.user = res.data;
//     })},
mounted(){
  axios
    .get('http://localhost:9000/api/events')
    .then(resp => (
      this.events = resp.data,
      this.profilePic = localStorage.orgPic,
      console.log(this.events)
    ));

  // axios
  //   .get('http://localhost:9000/api/users')
  //   .then(resp => (
  //     this.users = resp.data,
  //     // this.profilePic = user.profilePic,
  //     console.log(this.user)));

  // axios
  //   .post('http://localhost:9000/api/events')
  //   .then()
}


}

</script>

<style scoped>
#home {
  overflow: no-scroll;
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
#vol-events {
  height: 36vh;
  /* overflow: scroll; */
  width: 90vw;
  margin: auto;
  padding-top: 15px;
}
img {
  max-width: 100%;
  height: auto;
}
#search-bar {
  margin-top: 10px;
  padding-bottom: 10px;
  border-bottom: 2px solid black;
}
.event-box {
  width: 80vw;
  height: 35vh;
  border: 2px solid black;
  text-align: left;
  padding-left: 10px;
  border-radius: 10px;
  margin-left: 15px;
  margin-bottom: 15px;
}
.event-date {
  float: right;
}
.expanded-box {
  height: 30vh;
}
#main-logo {
  display: block;
  margin-right: auto;
  width: 15%;
  padding-top: 5px;
  padding-bottom: 5px;
}
.event-box-logo {
  width: 220px;
  float: right;
  position: relative;
  top: 20px;
  right: 10px;
}
.innovate-for-vegas-logo {
  width: 160px;
  float: right;
  position: relative;
  bottom: 15px;
  right: 30px;
}
#main-footer {
  border-top: 2px solid black;
  height: 5vh;
  padding-top: 15px;
}
h4 {
  position: relative;
  top: 20px;
}
.expand-btn {
  width: 70px;
  height: 30px;
  background: lightblue;
  border: none;
  border-radius: 10px;
  float: right;
  position: relative;
  right: 20px;
  bottom: 50px;
}
#zip-code {
  width: 80px;
}
</style>