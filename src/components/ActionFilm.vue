<template>
  <div class="film-list">
    <h2>PHIM HÀNH ĐỘNG</h2>
    <div class="film">
      <div class="film-item" v-for="film in films" :key="film.imdbID">
        <router-link :to="'/movie/' + film.imdbID" class="film-link">
          <div class="poster">
            <img :src="film.Poster" alt="Movie Poster" />
            <p class="type"><strong>{{ film.Type }}</strong></p>
          </div>
          <div class="detail">
            <p>
              <strong>{{ film.Title }}</strong>
            </p>
            <p><strong>Năm Phát Hành: </strong>{{ film.Year }}</p>   
         </div>
         
        </router-link>
      </div>
    </div>
  </div>
</template>


<script>
import axios from "axios";
export default {
  name: "MovieList",
  data() {
    return {
      films: [],
    };
  },
  mounted() {
    axios
      .get("https://www.omdbapi.com/?s=avengers&apikey=7f478e24")
      .then((res) => {
        this.films = res.data.Search;
      });
  },
};
</script>

<style scoped>
.poster img {
  position: relative;
  width: 250px;
  height: 380px;
}
.film {
  display: flex;
  /* justify-content: space-between; */
  flex-wrap: wrap;
}
.film-item:hover {
  transform: translate3d(-20px,-20px,20px);
-moz-transform: translate3d(-20px,-20px,20px);
-webkit-transform: translate3d(-20px,-20px,20px);
-o-transform: translate3d(-20px,-20px,20px);
-ms-transform: translate3d(-20px,-20px),20px;
}
.film-item {
  margin: 4px;
  transition: 2s;
}
h2 {
  margin: 30px 10px;
}
.detail {
  background-color: rgb(21, 133, 99);
  color: #fff;
  width: 250px;
  display: none;
  position: absolute;
  left: 0;
  right: 0;
  top: 0;
  transition: 1s;
  padding: 5px;
}
.film-link {
  position: relative;
}
.film-link:hover .detail {
  display: block;
}
h2 {
  margin: 30px 10px;
}
.type {
    position: absolute;
    top:0;
    left: 10;
}
.poster>p {
    background:linear-gradient(to bottom right, rgb(8, 218, 183), rgb(53, 197, 24));
    color: rgb(170, 32, 32);
    width: 60px;
    height: 30px;
    text-align: center;
    text-transform: uppercase;
}
@media screen and (max-width:937px) {
  .film {
    margin-left: auto;
    margin-right: auto;
  }
}
</style>
