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
    </div>
  </template>
  
  <script>
  export default {
    name: "volProfile",
    user: {
      name: "",
      phone: "",
    },
  };
  </script>
  
  <style scoped>