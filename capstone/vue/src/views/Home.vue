<template>
  <div id="home">

    <div id="home-head">

      <div id="home-nav-bar">
        <img src="" alt="">

        <img src="../img/AppLogo.png" id="main-logo" alt="logo">

        <div id="to-go-box" v-on:click="openBurger">
          <div class="hamburger"></div>
          <div class="hamburger"></div>
          <div class="hamburger"></div>
        </div>
      </div>

      <div id="home-banner">
        <img id="main-hero-banner" src="../img/VegasSign.jpg" alt="Vegas Sign"/>
      </div>

    </div>

    <div id="home-body">
      
      <form action="" id="search-bar">
        <input type="text">
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

#home-nav-bar {
  max-height: 15vh;
  display: flex;
}

#to-go-box {
  float: right;
  margin-right: 10px;
  padding-top: 10px;
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
  /* center event boxes here */
}

img {
  max-width: 100%;
  height: auto;
}

#search-bar {
  margin-top: 10px;
}

.event-box {
  width: 85vw;
  height: 15vh;
  border: 1px solid black;
  margin: 30px;
  text-align: left;
  padding-left: 15px;
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
</style>