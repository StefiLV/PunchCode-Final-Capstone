<template>
  <div id="profile">
    <div id="profile-head">
      <div id="home-nav-bar">
        <img src="" alt="" />

        <img src="../img/AppLogo.png" id="main-logo" alt="logo" />

        <div id="to-go-box" v-on:click="openBurger">
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

    <div id="profile-title">
      MY PROFILE
    </div>

    <div id="personal-info">
      <div class="event-box">
        <img class="event-box-logo" src="../img/ProfilePic.png" />
        <h3>NAME</h3>
        <h4>EMAIL<br />PHONE NUMBER<br />ADDRESS</h4>
        <!-- <button class="expand-btn">See More</button> -->
      </div>

      <div class="event-bio">
        <h3>ADD BIO (Optional)</h3>
        <textarea
          id="textarea-bio"
          type="text"
          placeholder="Bio (Optional)"
          name="name"
        />

        <h3></h3>
        <h4></h4>
      </div>
      <div id="bottom-half">
        <h3>MY HOURS</h3>
        <div class="event-hours">
          <textarea placeholder="where" />
        </div>
      </div>
    </div>

    <div id="main-footer">
      COPYRIGHT © 2022 PUNCHCODE COHORT 3
    </div>
  </div>
</template>

<script>
export default {
  name: "volProfile",
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

#profile-title {
  text-align: center;
}

#personal-info {
  height: 85vh;
  overflow: scroll;
  width: 90vw;
  margin: auto;
  padding-top: 15px;
}

img {
  max-width: 100%;
  height: 50%;
}
.event-bio {
  text-align: center;
  width: 80vw;
  height: 15vh;
  border: 2px solid black;
  padding-left: 15px;
  border-radius: 10px;
  margin-left: 15px;
  margin-bottom: 15px;
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
}
.event-hours {
  width: 80vw;
  height: 10vh;
  border: 2px solid black;
  text-align: left;
  padding-left: 15px;
  border-radius: 10px;
  margin-left: 15px;
  margin-bottom: 10px;
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
  width: 160px;
  float: right;
  position: relative;
  top: 20px;
  right: 10px;
}
#bottom-half {
  border-top: 2px solid black;
  height: 5vh;
  padding-top: 5px;
  text-align: center;
}

#main-footer {
  border-top: 2px solid black;
  height: 5vh;
  padding-top: 5px;
  text-align: center;
}
h3 {
  text-decoration: underline;
}

#textarea-bio {
  width: 85%;
  height: 40%;
}
</style>
