<template>
  <WebHeader />
  <h2>TOP 100 PHIM ĐIỆN ẢNH THỊNH HÀNH</h2>
  <div class="popular-film">
    <div class="movie-item" v-for="movie in movies" :key="movie.id">
      <router-link :to="'/movie/' + movie.id" class="movie-link">
        <div class="poster">
          <img :src="movie.image" alt="" />
          <p class="rank">
            <strong>RANKS: {{ movie.rank }}</strong>
          </p>
        </div>
        <div class="detail">
          <p>
            <strong>{{ movie.title }}</strong>
          </p>
          <p><strong>Năm Phát Hành: </strong>{{ movie.year }}</p>
        </div>
      </router-link>
    </div>
  </div>
  <WebFooter />
</template>

<script>
import axios from "axios";
import WebHeader from "./WebHeader";
import WebFooter from "./WebFooter";
import api from "@/api.js";
export default {
  name: "PopularFilm",
  components: { WebHeader, WebFooter },
  data() {
    return {
      movies: [],
    };
  },
  methods: {
    getData() {
      axios
        .get(`https://imdb-api.com/en/API/MostPopularMovies/${api.apikey3}`)
        .then((data) => {
          this.movies = data.data.items;
        });
    },
  },
  mounted() {
    this.getData();
  },
};
</script>

<style scoped>
.popular-film {
  display: flex;
  flex-wrap: wrap;
  margin-top: 50px;
}
.movie-item {
  margin: 4px;
}
.poster img {
  width: 250px;
  height: 380px;
  object-fit: cover;
  border-radius: 5px;
}
.detail {
  background-color: rgb(21, 133, 99);
  color: #fff;
  width: 250px;
  height: 100px;
  display: none;
  position: absolute;
  left: 0;
  right: 0;
  top: 0;
  transition: 1s;
  padding: 5px;
}
.movie-link {
  position: relative;
}
.movie-link:hover .detail {
  display: block;
}
.rank {
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
  width: 95px;
  height: 30px;
  text-align: center;
  text-transform: uppercase;
}
h2 {
  margin-top: 50px;
}
</style>
