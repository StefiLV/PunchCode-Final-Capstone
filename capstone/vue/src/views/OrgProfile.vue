<template>
  <div id="home">
    <div id="home-head">
      <div id="home-nav-bar">
        <img src="" alt="" />

        <img src="../img/AppLogo.png" id="main-logo" alt="logo" />

        <div id="to-go-box">
          <img
            src="../img/Message.png"
            id="message"
            class="nav-icons"
            @click="mailbox()"
          />
          <img src="../img/Bell.png" id="bell" class="nav-icons" />
          <img
            src="../img/Hamburger.png"
            id="hamburger"
            class="nav-icons"
            @click="menuOpen = !menuOpen"
          />
        </div>
      </div>
    </div>

    <div id="home-body">
      <form action="" id="my-tabs">
        <!-- <button>LISTINGS</button>
        <button>APPLIED</button><br/> -->
      </form>

      <form action="">
        <button id="add-listing" @click.prevent="showModal = true">
          + New Listing
        </button>
      </form>

      <div id="vol-events">
          <div class="org-events">
              <h2>Events</h2>
                <div class="event-box" 
                        v-for="event in ownerEvents" 
                        v-bind:key="event.id"
                        >
                          <img class="event-box-logo" v-bind:src="event.orgLogo"/>
                          <h3 class="org-name">{{event.name}}</h3>
                          <p class="eb-desc">{{event.description}}</p>
                          <p>{{event.startDate}} - {{event.endDate}}</p>
                          <p>{{event.startTime}} am - {{event.endTime}} pm</p>
                          <button class="volunteer-btn" @click="mustSignIn()">Edit Event</button>
                          <button class="volunteer-btn" @click="deleteEvent()">Delete Event</button>
                        </div>
             <div class="event-box">
            <img class="event-box-logo" src="../img/PunchCodeLogo.png"/>

            <h3>PunchCode Tech Alley Meet<br/>401 S. 4th St<br/>Nov. 1, 2022 - Dec. 23, 2022</h3>
            <button class="expand-btn">Delete</button>
            <button class="expand-btn">Edit</button>

        <div class="org-events">
          <h2>Events</h2>

          <div class="event-box">
            <img
              class="event-box-logo"
              src="../img/PunchCodeLogo.png"
            />

            <h3>
              PunchCode Tech Alley Meet<br />401 S. 4th St<br />Nov.
              1, 2022 - Dec. 23, 2022
            </h3>
            <button class="expand-btn">Delete</button>
            <button class="expand-btn">Edit</button>
          </div>
          <div class="event-box">
            <img
              class="event-box-logo"
              src="../img/PunchCodeLogo.png"
            />

            <h3>
              PunchCode Tech Alley Meet<br />401 S. 4th St<br />Nov.
              1, 2022 - Dec. 23, 2022
            </h3>
            <button class="expand-btn">Delete</button>
            <button class="expand-btn">Edit</button>
          </div>
          <div class="event-box">
            <img
              class="event-box-logo"
              src="../img/PunchCodeLogo.png"
            />

            <h3>
              PunchCode BBQ<br />401 S. 4th St<br />Nov. 1, 2022 -
              Dec. 23, 2022
            </h3>
            <button class="expand-btn">Delete</button>
            <button class="expand-btn">Edit</button>
          </div>
        </div>
        <div class="applied-volunteers">
          <h2>Volunteers</h2>
          <div class="event-box"
            v-for="volunteer in volunteers"
            v-bind:key="volunteer.id">
            <h3><img class="profile-pic" src="../img/ProfilePic.png"/>{{volunteer.name}}<br/>"My Bio"<br/><button @click="messageRoute()">Message Me</button></h3>
            <div class="right-status">
              <p class="status-hours">Volunteer Status:
                <select name="status" id="status">
                <option value="Accepted">Pending</option>
                <option value="Rejected">Rejected</option>
                <option value="Pending">Accepted</option>
              </select><br/>
              Volunteer Hours: 0</p>
            </div>

          </div>
        </div>
      </div>
      <div id="main-footer">
        COPYRIGHT © 2022 PUNCHCODE COHORT 3
      </div>
    </div>

    <div class="row dropdown" :class="{ 'dropdown-after': menuOpen }">
      <div class="navlist">
        <button class="dd-btn">
          <router-link :to="{ name: 'orgProfile' }"
            >Edit Profile</router-link
          >
        </button>
        <br />
        <button class="dd-btn">
          <router-link :to="{ name: 'home' }" @click="logOut()"
            >Log Out</router-link
          >
        </button>
      </div>
    </div>
  </div>
</template>
<script>
import axios from 'axios';
import Modal from "../components/Modal.vue";

export default {
  name: "orgProfile",
  data(){
      return {
        volunteers: null,
        events: null,
        ownerEvents: [],
        userId: null,
        profilePic: null,
        menuOpen: false,
        users: null,
        showModal: false,
      }
    },
  
  components: {
    Modal,
  },
  mounted(){
  this.userId = localStorage.userId;
  axios
    .get('http://localhost:9000/api/events')
    .then(resp => {
      if(resp.status == 200){
        (this.events = resp.data);
        console.log(this.events)

        for(let i = 0; i < this.events.length; i++){
          
          if(this.events[i].ownerId == localStorage.userId){
          this.ownerEvents.push(this.events[i])
          }
        }
        console.log(this.ownerEvents)
      }
    });
  axios
    .get('http://localhost:9000/api/users/events/1', )
      .then(resp => {
        if(resp.status == 200){
          (this.volunteers = resp.data);
          console.log(this.volunteers)
        }
      });
    
  },
  methods: {
    showEventId(){
      console.log(this.events);
    },
    messageRoute(){
      this.$router.push("/message");
    },
    deleteEvent(){
      prompt("Type `DELETE` to delete event")
      .then(alert("Event has been deleted!"))
        axios
      .delete('http://localhost:9000/api/events/6')
      .then(resp => {
        if(resp.status == 200){
          (this.events = resp.data);
          console.log(this.events)
        }
      });
      location.reload();
    },
    mailBox() {
      this.$router.push("/emptyMailbox");
    },
    logOut() {
      localStorage.clear();
      console.log("We logged out...kinda");
    },    
  }

};


};
</script>

<style scoped>
#home {
  overflow: no-scroll;
}

#home-nav-bar {
  max-height: 15vh;
  display: flex;
}

.org-name {
  position: relative;
  bottom: 60px;
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
  height: 80vh;
  overflow: scroll;
  width: 90vw;
  margin: auto;
  padding-top: 5px;
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

.org-events {
  border: 2px solid black;
  height: 38vh;
  overflow: scroll;
}

.applied-volunteers {

    border: 2px solid black;
    height: 38vh;
    padding-top: 10px;
    overflow: scroll;

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

.applied-volunteers > .event-box {
  height: 15vh;
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
  width: 10em;
  float: right;
  position: relative;
  top: 20px;
  right: 10px;
  margin-left: 20px;
}

.profile-pic {
  width: 30px;
}

.innovate-for-vegas-logo {
  width: 160px;
  float: right;
  position: relative;
  bottom: 15px;
  right: 15px;
}

#main-footer {
  border-top: 2px solid black;
  height: 5vh;
  padding-top: 15px;
}
h2 {
  position: relative;
  bottom: 15px;
}
h3 {
  position: relative;
  top: 20px;
}

.expand-btn {
  float: right;
  position: relative;
  bottom: 20px;
  right: 40px;
}

.status-hours {
  float: right;
  position: relative;
  bottom: 20px;
  right: 20px;
  /* border-left: 2px solid black;
    height: 140px; */
}

.right-status {
  position: relative;
  bottom: 80px;

}

#add-listing {
  background: blue;
  color: white;
  width: 35vw;
  height: 45px;
  border-radius: 5px;
  margin-bottom: 10px;
}

/* this code below is for the dropdown */
#dd-title {
  letter-spacing: 0.8px;
}
.dropdown {
  height: 0px;
  background: lightgrey;
  transition: height 0.2s ease;
  display: flex;
  align-items: center;
  justify-content: center;
  overflow: hidden;
  width: 30vw;
  position: absolute;
  top: 0;
  right:0;
  margin-top:45px;
  border-radius: 10px 0 0 10px;
}
.dropdown-after {
  height: calc(100vh - 50px);
  transition: height 0.2s ease;
  width: 30vw;
  height: 20vh;
  position: absolute;
  top: 0;
  right:0;
  margin-top:45px;
  border-radius: 10px 0 0 10px;
}

label {
  letter-spacing: 1px;
}

.dd-btn {
  border-radius: 10px;
  border: none;
  padding: 5px;
  margin: 2px;
  letter-spacing: 0.7px;
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
  right: 0;
  margin-top: 45px;
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
  right: 0;
  margin-top: 45px;
  border-radius: 10px 0 0 10px;
}

a {
  color: black;
  text-decoration: none;
}
</style>
