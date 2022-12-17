<template>
  <div id="home">

    <div id="home-head">

      <div id="home-nav-bar">
        <img src="" alt="">

        <img src="../img/AppLogo.png" id="main-logo" alt="logo">

        <div id="to-go-box" v-on:click="openBurger">
          <img src="../img/Message.png" id="message" class="nav-icons">
          <img src="../img/Bell.png" id="bell" class="nav-icons">
          <img src="../img/Hamburger.png" id="hamburger" class="nav-icons">

        </div>
      </div>

      <div id="home-banner">
        <img id="main-hero-banner" src="../img/VegasSign.jpg" alt="Vegas Sign"/>
      </div>

    </div>

    <div id="home-body">
      
      <form action="" id="search-bar">
        <input type="text" placeholder="SEARCH">
        <button>Filter</button>
      </form>

      <div id="vol-events">

        <div class="event-box">
          <img id="Punch-Code-Logo" src="../img/PunchCodeLogo.png"/>
          <h3>Instructor Assistant</h3>
          <h4>PunchCode</h4>
          <h4>401 S. 4th St</h4>
        </div>

        <div class="event-box">
          <img id="Innovate-For-Vegas" src="../img/InnovateForVegas.png"/>
          <h3>Software Developer</h3>
          <h4>Innovate For Vegas</h4>
          <h4>4th St and Lewis Ave</h4>

        </div>

        <div class="event-box">
          <img id="Three-Square" src="../img/ThreeSquareLogo.png"/>
          <h3>Helper</h3>
          <h4>Three Square</h4>
          <h4>4190 N Pecos Rd</h4>
        </div>

        <div class="event-box">
          <img id="Innovate-For-Vegas" src="../img/InnovateForVegas.png"/>
          <h3>Software Developer</h3>
          <h4>Innovate For Vegas</h4>
          <h4>4th St and Lewis Ave</h4>

        </div>

        <div class="event-box">
          <img id="Three-Square" src="../img/ThreeSquareLogo.png"/>
          <h3>Helper</h3>
          <h4>Three Square</h4>
          <h4>4190 N Pecos Rd</h4>
        </div>

      </div>

      <div id="main-footer"> 
        COPYRIGHT © 2022 PUNCHCODE COHORT 3
      </div>

    </div>

  </div>
</template>

<script>
export default {
  name: "home"
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
  height: 55vh;
  overflow: scroll;
  width: 90vw;
  margin: auto;
  padding-top: 15px;
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

#Punch-Code-Logo {
  width: 50%;
  float: right;
  padding-top: 10px;
  padding-right: 10px;
}

#Innovate-For-Vegas {
  width: 25%;
  float: right;
  padding-right: 50px; 
}

#Three-Square {
  width: 50%;
  float: right;
  padding-top: 10px;
  padding-right: 10px;
}

#main-footer {
  border-top: 2px solid black;
  height: 5vh;
  padding-top: 15px;
}

</style>