<template>
  <div class="waves-container">
    <div class="waves">
      <div class="wave1"></div>
      <div class="wave2"></div>
      <div class="wave3"></div>
      <div class="wave4"></div>
      <div class="wave5"></div>
    </div>
    <div class="background-waves">
      <div class="bwave1"></div>
      <div class="bwave2"></div>
      <div class="bwave3"></div>
      <div class="bwave4"></div>
      <div class="bwave5"></div>
    </div>
  </div>
</template>
<style scoped>
  .waves-container{
    position: relative;
  }
  .wave1 {
    left: 0%;
    margin-left: -50px;
  }

  .wave2 {
    margin-left: -69px;
  }

  .wave3 {
    margin-left: -69px;
  }

  .wave4 {
    margin-left: -69px;
  }

  .waves {
    width: 200%;
    clear: none;
    z-index: 100;
    position: absolute;
    margin-top: 200px;
    margin-left: -150px;
  }

  .waves div {
    float: left;
    width: 500px;
    height: 100px;
    border: solid 5px #000;
    border-color: transparent;
    border-radius: 70%/100px 100px 0 0;
    background-color: #fff;
  }

  .bottom-half {
    width: 100%;
    height: 50%;
    top: 70%;
    position: absolute;
    background-color: #fff;
  }

  .background-waves {
    width: 200%;
    clear: none;
    z-index: 50;
    position: absolute;
    margin-top: 190px;
    margin-left: 75px;
  }

  .bwave1 {
    left: 0%;
    margin-left: -50px;
  }

  .bwave2 {
    margin-left: -69px;
  }

  .bwave3 {
    margin-left: -69px;
  }

  .bwave4 {
    margin-left: -69px;
  }

  .background-waves div {
    float: left;
    width: 500px;
    height: 100px;
    border: solid 5px #000;
    border-color: transparent;
    border-radius: 70%/100px 100px 0 0;
    background-color: #fff;
    opacity: 0.5;
  }
</style>