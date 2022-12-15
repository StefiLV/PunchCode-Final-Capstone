<template>
  <div id="home">

    <div id="home-head">

      <div id="home-nav-bar">
        <h1>Logo goes here</h1>
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
          <h1>Event Name</h1>
        </div>
        <div class="event-box">
          <h1>Event Name</h1>
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