<template>
  <div class="film-list">
    <h2>PHIM VIỄN TƯỞNG</h2>
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
      .get("https://www.omdbapi.com/?s=harry potter&apikey=7f478e24")
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
  flex-wrap: wrap;
}
.film-item:hover {
  transform: rotate(-30deg);
-moz-transform: rotate(-30deg);
-webkit-transform: rotate(-30deg);
-o-transform: rotate(-30deg);
-ms-transform: rotate(-30deg);
}
.film-item {
  margin: 4px;
  transition: 1s;
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
</style>
