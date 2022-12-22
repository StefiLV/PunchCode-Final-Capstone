<template>
  <div id="createEvent">
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
        <h3>NAME</h3>
        <p>EMAIL<br />PHONE NUMBER<br />ADDRESS</p>
      </div>
    </div>

    <!-- Trigger/Open The Modal
    <button id="myBtn">Open Modal</button>

     The Modal 
    <div id="myModal" class="modal">
       Modal content
      <div class="modal-content">
        <span class="close">&times;</span>
        <p>Some text in the Modal..</p>
      </div>
    </div> -->

    <!-- <button id="show-modal" @click="showModal = true">
      Create an Event
    </button> -->

    <button id="show-modal" @click="showModal = true">
      Create an Event
    </button>

    <Teleport to="body">
      <!-- use the modal component, pass in the prop -->
      <modal :show="showModal" @close="showModal = false">
        <template #header>
          <h3>Create an Event</h3>
        </template>
      </modal>
    </Teleport>

    <template>
      <Transition name="modal">
        <div v-if="show" class="modal-mask">
          <div class="modal-wrapper">
            <div class="modal-container">
              <div class="modal-header">
                <slot name="header">Create an Event</slot>
              </div>

              <div class="event-namebox">
                <input placeholder="Event Name" />
              </div>

              <div class="location-box">
                <input placeholder="Location" />
              </div>

              <div class="cont-infobox">
                <input placeholder="Contact Info" />
              </div>

              <input
                placeholder="Start Date"
                class="form-control"
                type="text"
                onfocus="(this.type='date')"
                onblur="(this.type='text')"
                id="date"
              />
              <input
                placeholder="End Date"
                class="form-control"
                type="text"
                onfocus="(this.type='date')"
                onblur="(this.type='text')"
                id="date"
              />

              <div class="time-box">
                <input
                  placeholder="Start Time"
                  class="form-control"
                  type="text"
                  onfocus="(this.type='time')"
                  onblur="(this.type='text')"
                  id="time"
                />
                <input
                  placeholder="End Time"
                  class="form-control"
                  type="text"
                  onfocus="(this.type='time')"
                  onblur="(this.type='text')"
                  id="time"
                />
              </div>

              <div class="modal-footer">
                <textarea
                  id="textarea-desc"
                  type="text"
                  placeholder="Description"
                  name="name"
                />
                <button
                  class="modal-default-button"
                  @click="$emit('close')"
                >
                  Submit
                </button>
              </div>
            </div>
          </div>
        </div>
      </Transition>
    </template>

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

      <div></div>
    </div>
  </div>
</template>

<script>
export default {
  name: "createEvent",
  user: {
    name: "",
    phone: "",
  },
};

// import Modal from './Modal.vue'

// export default {
//   components: {
//     Modal
//   },
//   data() {
//     return {
//       showModal: false
//     }
//   };
//   export default {
//   props: {
//     show: Boolean
// }
</script>

<style scoped>
#createEvent {
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

#textarea-bio {
  width: 85%;
  height: 40%;
}

.edit-nameBio {
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
  width: 15%;
  position: relative;
  top: 10px;
  left: 5px;
}

#my-hours {
  text-decoration: underline;
}
</style>
