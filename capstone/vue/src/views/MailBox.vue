<template>
  <div id="no-msg">
    
    <div id="no-msg-head">

      <div id="home-nav-bar">
        <img src="../img/AppLogo.png" id="main-logo" alt="logo">

        <div id="to-go-box">
          <img src="../img/Message.png" id="hamburger" class="nav-icons">
          <img src="../img/Bell.png" id="hamburger" class="nav-icons">
          <img src="../img/Hamburger.png" id="hamburger" class="nav-icons">
        </div>
      
      </div>

    </div>

    <div id="no-msg-body">
      
      <div id="msg-title">
        <h1 id="msg-h1">MESSAGES</h1>
      </div>

    <div id="msg-body1">
                <div class="msg-contact blue">
                    <div class="profile-pic"></div>
                    <p class="msg-name">John Matthews</p>
                    <p class="msg-ts">12/01/2022 09:00am</p>
                </div>
                <div class="msg-contact red">
                    <div class="profile-pic"></div>
                    <p class="msg-name">Lance Amolo</p>
                    <p class="msg-ts">12/10/2022 11:00pm</p>
                </div>
                <div class="msg-contact blue">
                    <div class="profile-pic"></div>
                    <p class="msg-name">Stefi Kraemer</p>
                    <p class="msg-ts">12/01/2022 09:30am</p>
                </div>
                <div class="msg-contact red">
                    <div class="profile-pic"></div>
                    <p class="msg-name">Chris Gomez</p>
                    <p class="msg-ts">11/23/2022 8:00pm</p>
                </div>
                <div class="msg-contact blue">
                    <div class="profile-pic"></div>
                    <p class="msg-name">Bryan Munoz</p>
                    <p class="msg-ts">11/22/2022 10:30am</p>
                </div>
                <div class="msg-contact red">
                    <div class="profile-pic"></div>
                    <p class="msg-name">Gabriel Kramp</p>
                    <p class="msg-ts">11/20/2022 6:00pm</p>
                </div>
                <div class="msg-contact blue">
                    <div class="profile-pic"></div>
                    <p class="msg-name">Kaleb McCalla</p>
                    <p class="msg-ts">11/19/2022 11:30am</p>
                </div>
                <!-- <div class="msg-contact red">
                    <p class="msg-name">name</p>
                    <p class="msg-ts">timestamp</p>
                </div> -->
            </div>
    </div>
  

    <div id="no-msg-footer"> 
      <p>COPYRIGHT © 2022 PUNCHCODE COHORT 3</p>
    </div>

  </div>
</template>

<script>
export default {
  name: "emptyMailbox"
};
</script>

<style scoped>


#no-msg{
  overflow: no-scroll;
}

#no-msg-head {
  height: 15vh;
}

#home-nav-bar {
  max-height: 15vh;
  display: flex;
}

#to-go-box {
  float: right;
  margin-top: 15px;
  margin-right: 10px;
}

.nav-icons {
  width: 6vw;
  height: 3.5vh;
  margin-left: 12px;
}

#main-logo {
  display: block;
  margin-right: auto;
  width: 27%;
  padding-top: 5px;
  padding-bottom: 5px;
}

#no-msg-body {
  height: 77vh;
  display: grid;
  grid-template-areas:
  msg-title
  msg-body1
  no-msg-footer
}

#msg-body1 {
    overflow: scroll;
    height: 60vh;
    display: block;
    overflow: scroll;
    margin: 0 5%;
    border: 3px solid #ffd374;
    border-radius: 10px;
  }

#msg-title {
  height: 15%;
  text-align: center;
  letter-spacing: 2px;
  text-decoration: underline;
}

.msg-ts, .msg-name{
    margin: 0px 6px 0px 6px;
    padding: 10px;
}

.blue{
    background-color: #4fbde2;
    color: white;
}

#msg-body2{
  height: 5vh;
  display: grid;
  align-items: end;
  justify-items: center;

}

#no-msg-footer {
  display: grid;
  border-top: 2px solid black;
  height: 5vh;
  padding-top: 20px;
  justify-items: center;
  align-items: center;
}
.profile-pic {
    width: 80px;
    height: 80px;
    background: black;
    border-radius: 50%;
    flex-grow: 1;
}

.msg-name {
    flex-grow: 3;
    font-size: 150%;
}

.msg-ts {
    flex-grow: 1;
}
.msg-contact {
    display: flex;
    height: 9vh;
    padding: 3px;
    justify-content: space-evenly;
    align-items: center;
}

</style>