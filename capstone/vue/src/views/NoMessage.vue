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
  
        <div id="messageBodyMain">

            <div id="msg-title">
                <h2 id="msg-h2">MESSAGES</h2>
                <h3 id="msg-h3">Name</h3>
            </div>

        <div id="msg-body1">
                <ul>
                    <li>THERE ARE NO MESSAGES.</li>
                    <li>START A CONVERSATION!</li>
                </ul>
        </div>
        
            <div id="msg-body2">
                <div>
                    <input id="msg-input" type="text">
                    <button id="msg-btn">SEND</button>
                </div>
            </div>
        </div>

        <div id="no-msg-footer"> 
            <p>COPYRIGHT © 2022 PUNCHCODE COHORT 3</p>
        </div>

    </div>
</template>

<script>
export default {
  name: "message"
};
</script>

<style scoped>

#no-msg{
  overflow: no-scroll;
}

#no-msg-head {
  height: 10vh;
}

#messageBodyMain{
    height: 80vh;
}


#msg-body1 {
    height: 70%;
    display: grid;
    justify-items: center;
    align-items: center;
    margin: 0 5%;
    padding: 20px 20px 10px 20px;
    border: 3px solid #ffd374;
    border-radius: 10px;
  }

#msg-body1>ul>li{
    list-style-type: none;
    font-size: larger;
    letter-spacing: 2px;
  }
  
#msg-body2 {
    height: 15%;
    text-align: center;
    margin-top: 20px;
    padding-left: 2px;
  }
  
#msg-input {
    width: 60vw;
    height: 50px;
    border-radius: 10px 0 0 10px;
  }
  
#msg-btn {
    width: 30vw;
    height: 56px;
    background: black;
    color: white;
    letter-spacing: 2px;
    border-radius: 0 10px 10px 0;
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
}

#msg-h2{
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
  padding-top: 10px;
  justify-items: center;
  align-items: center;
}

</style>
