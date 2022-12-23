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
          />
          <img src="../img/Bell.png" id="bell" class="nav-icons" />
          <img
            src="../img/Hamburger.png"
            id="hamburger"
            class="nav-icons"
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
          <div class="event-box">
            <h3>
              <img
                class="profile-pic"
                src="../img/ProfilePic.png"
              />John Doe<br />"My Bio"<br /><button>
                Message Me
              </button>
            </h3>
            <div class="right-status">
              <p class="status-hours">
                Volunteer Status:
                <select name="status" id="status">
                  <option value="Pending">Pending</option>
                  <option value="Accepted">Accepted</option>
                  <option value="Rejected">Rejected</option></select
                ><br />
                Volunteer Hours: 0
              </p>
            </div>
          </div>
        </div>
      </div>

      <div id="main-footer">COPYRIGHT © 2022 PUNCHCODE COHORT 3</div>
      <modal :show="showModal" @close="showModal = false">
        <template #header>
          <h3>New Listing</h3>
        </template>
      </modal>
    </div>
  </div>
</template>

<script>
// import axios from "axios";
import Modal from "../components/Modal.vue";

export default {
  name: "orgProfile",
  components: {
    Modal,
  },
  data() {
    return {
      showModal: false,
    };
  },
  mounted() {
    // this.userId = localStorage.userId;
    // axios
    //   .get("http://localhost:9000/api/events")
    //   .then((resp) => (this.events = resp.data));
  },
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
}

.event-box {
  width: 80vw;
  height: 15vh;
  border: 2px solid black;
  text-align: left;
  padding-left: 15px;
  border-radius: 10px;
  margin-left: 15px;
  margin-bottom: 15px;
  position: relative;
  bottom: 30px;
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
</style>
