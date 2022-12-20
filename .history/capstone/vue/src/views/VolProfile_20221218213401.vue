<template>
  <div id="profile">
    <div id="nav-bar">
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

    <div id="profile-title">
      <h2 id="my-profile">MY PROFILE</h2>
    </div>

    <div id="personal-info">
      <div class="event-box">
        <img class="event-box-logo" src="../img/ProfilePic.png" />
        <h3>NAME</h3>
        <h4>EMAIL<br />PHONE NUMBER<br />ADDRESS</h4>
        <!-- <button class="expand-btn">See More</button> -->
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
      </div>
    </div>

    <div id="bottom-half">
      <h3 id="my-hours">MY HOURS</h3>

      <div id="event-app">
        <div class="event-hours">
          <h4>Where</h4>
        </div>
        <div class="event-hours">
          <h4>Where</h4>
        </div>
        <div class="event-hours">
          <h4>Where</h4>
        </div>
        <div class="event-hours">
          <h4>Where</h4>
        </div>
        <div class="event-hours">
          <h4>Where</h4>
        </div>
        <div class="event-hours">
          <h4>Where</h4>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "volProfile",
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
  background-color: red;
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
  border: 2px solid black;
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

#main-logo {
  display: block;
  margin-right: auto;
  width: 27%;
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
  border: 1px solid black;
  height: 41vh;
  width: 90vw;
  margin: auto;
  overflow: scroll;
}

.event-hours {
  width: 80vw;
  height: 10vh;
  border: 2px solid black;
  text-align: left;
  border-radius: 10px;
  margin: auto;
  margin-bottom: 20px;
  position: relative;
  top: 20px;
}
</style>
