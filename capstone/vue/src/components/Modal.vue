<script>
// import axios from "axios";

export default {
  data() {
    return {
      event: {
        name: "",
        org_owner: "",
        org_logo: "",
        address: "",
        start_date: "",
        end_date: "",
        start_time: "",
        end_time: "",
        description: "",
        user_counter: 0,
      },
    };
  },
  methods: {
    // createEvent() {
    //   axios
    //     .post("http://localhost:9000/api/events", this.event)
    //     .then((response) => {
    //       if (response.status == 201) {
    //         alert("EVENT HAS BEEN CREATED");
    //         window.location.reload();
    //       }
    //     });
    // },
  },
  props: {
    show: Boolean,
  },
  mounted: {},
};
</script>

<template>
  <Transition name="modal">
    <div v-if="show" class="modal-mask">
      <div class="modal-wrapper">
        <div class="modal-container">
          <div class="modal-header">
            <slot name="header">New Listing</slot>
          </div>

          <div class="modal-body">
            <!-- <slot name="body">default body</slot> -->
          </div>
          <div class="event-namebox">
            <input placeholder="Event Name" v-model="event.name" />
          </div>

          <div class="location-box">
            <input placeholder="Location" v-model="event.address" />
          </div>

          <!-- <div class="cont-infobox">
            <input placeholder="Contact Info" />
          </div> -->

          <div class="date-rows">
            <input
              placeholder="Start Date"
              class="form-control"
              type="text"
              onfocus="(this.type='date')"
              onblur="(this.type='text')"
              id="sDate"
              v-model="event.start_date"
            />
            <input
              placeholder="End Date"
              class="form-control"
              type="text"
              onfocus="(this.type='date')"
              onblur="(this.type='text')"
              id="eDate"
              v-model="event.end_date"
            />
          </div>

          <div class="time-box">
            <input
              placeholder="Start Time"
              class="form-control"
              type="text"
              onfocus="(this.type='time')"
              onblur="(this.type='text')"
              id="sTime"
              v-model="event.start_date"
            />
            <input
              placeholder="End Time"
              class="form-control"
              type="text"
              onfocus="(this.type='time')"
              onblur="(this.type='text')"
              id="eTime"
              v-model="event.end_date"
            />
          </div>

          <div class="modal-footer">
            <slot name="footer">
              <textarea
                id="textarea-desc"
                type="text"
                placeholder="Description"
                name="name"
                v-model="event.description"
              />

              <button class="modal-default-button">SUBMIT</button>
            </slot>
          </div>
        </div>
      </div>
    </div>
  </Transition>
</template>

<style>
.date-rows {
  position: relative;
  right: 90px;
}

.modal-mask {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: table;
  transition: opacity 0.3s ease;
}

.modal-wrapper {
  display: table-cell;
  vertical-align: middle;
}

.modal-container {
  width: 300px;
  margin: 0px auto;
  padding: 20px 30px;
  background-color: #fff;
  border-radius: 2px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.33);
  transition: all 0.3s ease;
}

.modal-header h3 {
  margin-top: 0;
  color: red;
}

.modal-body {
  margin: 20px 0;
  height: 70px;
}

.modal-default-button {
  /* float: right; */
  position: relative;
  top: 18px;
  left: 100px;
  width: 100px;
  background: blue;
  color: white;
  border-radius: 5px;
}

/*
 * The following styles are auto-applied to elements with
 * transition="modal" when their visibility is toggled
 * by Vue.js.
 *
 * You can easily play with the modal transition by editing
 * these styles.
 */

.event-namebox {
  position: relative;
  right: 70px;
  bottom: 85px;
}

.location-box {
  position: relative;
  right: 70px;
  bottom: 80px;
}

.cont-infobox {
  position: relative;
  left: 85px;
  bottom: 111px;
}

.time-box {
  display: flex;
  position: relative;
  bottom: 65px;
}

.date-rows {
  display: flex;
  position: relative;
  left: 1px;
  bottom: 70px;
}

#textarea-desc {
  position: relative;
  bottom: 20px;
  width: 300px;
  height: 70px;
}

.modal-enter-from {
  opacity: 0;
}

.modal-leave-to {
  opacity: 0;
}

.modal-enter-from .modal-container,
.modal-leave-to .modal-container {
  -webkit-transform: scale(1.1);
  transform: scale(1.1);
}
</style>
