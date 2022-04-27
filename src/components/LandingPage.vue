<template>
  <WebHeader />
  <WebBody />
  <ActionFilm />
  <FantasyFilm />
  <HorrorFilm />
  <WebFooter />
  <!-- <div class="theme">
    <iframe
      src="https://www.nhaccuatui.com/mh/auto/uCLJlIwjFJWt"
      width="1"
      height="1"
      allowfullscreen
      allow="autoplay"
    ></iframe>
  </div> -->
</template>

<script>
import WebHeader from './WebHeader'
import WebFooter from "./WebFooter";
import WebBody from "./WebBody";
import ActionFilm from "./ActionFilm";
import FantasyFilm from "./FantasyFilm";
import HorrorFilm from "./HorrorFilm";
export default {
  name: "LandingPage",
  components: {WebHeader, WebBody, WebFooter, ActionFilm, FantasyFilm, HorrorFilm },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Cookie&family=Dancing+Script&family=Great+Vibes&family=Indie+Flower&family=Kaushan+Script&family=Open+Sans:wght@300&family=Sacramento&display=swap");

.logo-details {
  padding-top: 200px;
  padding-left: 20px;
  width: 900px;
}
.logo-details h1 {
  font-family: "Great Vibes", cursive;
  margin-top: 20px;
}
.logo-details i {
  font-size: 15px;
  color: rgb(204, 202, 204);
}
.logo {
  display: flex;
  justify-content: space-evenly;
  /* align-items: center; */
  margin-bottom: 20px;
  height: 300px;
}
header {
  margin-bottom: 20px;
  color: #fff;
  background-image: url("https://cdnimg.vietnamplus.vn/uploaded/izhsr/2015_05_11/ndldleafray5vu9hot9m_211ox9s.jpg");
  background-position: center;
  background-size: 1520px 500px;
  background-repeat: no-repeat;
}
.signup-login button a {
  text-decoration: none;
  color: #fff;
}
.signup-login {
  display: flex;
  align-items: flex-start;
  justify-content: end;
  width: 400px;
  padding-top: 20px;
  padding-right: 20px;
}
.signup-login div {
  margin-left: 20px;
}
.navbar {
  color: red;
}
.navbar a:hover {
  color: rgb(83, 203, 250);
}
.movie {
  margin-right: 5px;
  width: 295px;
}
.movies-list {
  display: flex;
  flex-wrap: wrap;
  margin: 0px 8px;
  color: #f4f4f4;
  text-decoration: none;
}
.movie-link {
  display: flex;
  flex-direction: column;
  height: 100%;
}
.poster {
  display: block;
}
img {
  height: 400px;
  object-fit: cover;
  display: block;
  width: 295px;
}
.type {
  text-transform: uppercase;
}
.detail {
  border-radius: 10px;
  height: 200px;
  width: 295px;
  background-color: #f4f4f4;
  padding-bottom: 5px;
  margin-bottom: 10px;
  padding: 10px;
}
.search-btn {
  color: #f4f4f4;
  text-decoration: none;
}
</style>
