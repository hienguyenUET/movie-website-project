<template>
  <div class="film-list">
    <h2>PHIM HÀNH ĐỘNG</h2>
    <div class="film">
      <div class="film-item" v-for="film in films" :key="film.idAPI">
        <router-link :to="'/movie/' + film.idAPI" class="film-link">
          <div class="poster">
            <img :src="film.posterPath" alt="Movie Poster" />
            <p class="type">
              <strong>Action</strong>
            </p>
          </div>
          <div class="detail">
            <p>
              <strong>{{ film.Title }}</strong>
            </p>
            <p><strong>Năm Phát Hành: </strong>{{ film.releaseDate }}</p>
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
    axios.get("http://localhost:8081/movie/action").then((res) => {
      this.films = res.data;
    });
  },
};
</script>

<style scoped>
.poster img {
  position: relative;
  width: 300px;
  height: 380px;
}
.film {
  display: flex;
  /* justify-content: space-between; */
  flex-wrap: wrap;
}
.film-item:hover {
  transform: scale(1.1, 1.1);
  -moz-transform: scale(1.1, 1.1);
  -webkit-transform: scale(1.1, 1.1);
  -o-transform: scale(1.1, 1.1);
  -ms-transform: scale(1.1, 1.1);
}
.film-item {
  margin: 12px;
  transition: 1s;
  width: 300px;
  height: 380px;
}
h2 {
  margin: 30px 10px;
}
.detail {
  background-color: rgb(21, 133, 99);
  color: #fff;
  width: 300px;
  height: 100px;
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
  top: 0;
  left: 10;
}
.poster > p {
  background: linear-gradient(
    to bottom right,
    rgb(8, 218, 183),
    rgb(53, 197, 24)
  );
  color: rgb(170, 32, 32);
  width: 60px;
  height: 30px;
  text-align: center;
  text-transform: uppercase;
}
@media screen and (max-width: 937px) {
  .film {
    margin-left: auto;
    margin-right: auto;
  }
}
</style>
