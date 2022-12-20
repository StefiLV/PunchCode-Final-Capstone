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

      <div id="msg-envLogo">
        <img src="../img/envLogo.png">
      </div>

      <div id="noMsgs">
        <h2 id="no-msg">There are no messages!</h2>
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

#no-msg-body {
  height: 77vh;
  display: grid;
  grid-template-areas:
  msg-title
  msg-envLogo
  noMsgs
  no-msg-footer
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

.msg-ts, .msg {
  margin-left: 6px;
}

#msg-title {
  height: 15%;
  text-align: center;
  letter-spacing: 2px;
  text-decoration: underline;
}

#noMsgs{
 display: grid;
  height: 15%;
  text-align: center;
  align-items: end;
  color: #0964cb;

}

#msg-envLogo{ 
  display: grid;
  justify-content: center;
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

</style>