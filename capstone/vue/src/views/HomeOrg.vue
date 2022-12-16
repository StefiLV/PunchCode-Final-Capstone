<template>
  <div id="home">

    <div id="home-head">

      <div id="home-nav-bar">
        <img src="" alt="">

        <h1>Listings</h1>

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
          <h1>Code For Vegas</h1>
        </div>

        <div class="event-box">
          <h1>PunchCode</h1>
        </div>

        <div class="event-box">
          <h1>FoodBank</h1>
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
  margin: auto;
  border: 1px solid black;
  margin: 30px;
}

</style>