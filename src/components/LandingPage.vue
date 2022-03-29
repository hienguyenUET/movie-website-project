<template>
  <WebHeader />
  <WebBody /> 
  <ActionFilm />   
  <FantasyFilm />
  <HorrorFilm />
  <WebFooter />
  <div class="theme">
    <iframe
      src="https://www.nhaccuatui.com/mh/auto/uCLJlIwjFJWt"
      width="1"
      height="1"
      allowfullscreen
      allow="autoplay"
    ></iframe>
  </div>
</template>

<script>
import WebHeader from './WebHeader'
import WebFooter from './WebFooter'
import WebBody from './WebBody'
import ActionFilm from './ActionFilm'
import FantasyFilm from './FantasyFilm'
import HorrorFilm from './HorrorFilm'
export default {
    name: 'LandingPage',
    components: { WebHeader, WebBody, WebFooter, ActionFilm, FantasyFilm, HorrorFilm }
}
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Cookie&family=Dancing+Script&family=Great+Vibes&family=Indie+Flower&family=Kaushan+Script&family=Open+Sans:wght@300&family=Sacramento&display=swap");
</style>