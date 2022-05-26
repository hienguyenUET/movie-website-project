<template>
  <WebHeader />
  <div class="">
    <form @submit.prevent="getData()" class="d-flex search-box">
      <input
        class="form-control me-2"
        type="search"
        placeholder="Nhập phim bạn muốn tìm kiếm"
        aria-label="Search"
        v-model="search"
        @input="debounceSearch()"
      />
      <button class="btn btn-success" type="submit" value="search">
        Search
      </button>
    </form>
    <span
      ><i
        >Phim có từ khóa <strong>{{ search }}</strong></i
      ></span
    >
    <div class="movies-list">
      <div class="movie" v-for="movie in movies" :key="movie.idAPI">
        <router-link :to="'/movie/' + movie.idAPI" class="movie-link">
          <div v-if="movie.posterPath !== 'N/A'" class="poster">
            <img :src="movie.posterPath" alt="Movie Poster" />
            <p class="type">
              <strong>{{ movie.Type }}</strong>
            </p>
          </div>
          <div v-if="movie.Poster !== 'N/A'" class="detail">
            <p>{{ movie.Title }}</p>
            <p><strong>Năm Phát Hành: </strong> {{ movie.Year }}</p>
          </div>
        </router-link>
      </div>
    </div>
  </div>
  <WebFooter />
</template>

<script>
import WebHeader from "./WebHeader";
import WebFooter from "./WebFooter";
import axios from "axios";
// import api from "@/api.js";
export default {
  name: "FilmSearch",
  components: { WebFooter, WebHeader },
  data() {
    return {
      search: "",
      seasonSearch: "",
      episodeSearch: "",
      movies: [],
    };
  },
  methods: {
    getData() {
      axios
        // .get(`https://www.omdbapi.com/?s=${this.search}&apikey=${api.apikey1}`)
        .get(`http://localhost:8081/movie/search/${this.search}`)
        .then((data) => {
          this.movies = data.data;
        });
    },
    debounceSearch() {
      clearTimeout(this.debounce);
      this.debounce = setTimeout(() => {
        this.getData();
      }, 0);
    },
  },
  mounted() {
    this.getData();
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Cookie&family=Dancing+Script&family=Great+Vibes&family=Indie+Flower&family=Kaushan+Script&family=Open+Sans:wght@300&family=Sacramento&display=swap");

.logo-details {
  padding-top: 200px;
  width: 1200px;
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

.navbar a:hover {
  color: rgb(83, 203, 250);
}
.movie {
  margin: 4px;
}
.movies-list {
  margin-top: 50px;
  display: flex;
  flex-wrap: wrap;
}
form {
  display: flex;
  justify-content: center;
  position: relative;
}
.debouce {
  position: absolute;
  top: 0;
}
.poster img {
  width: 250px;
  height: 380px;
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
.search-box {
  margin-bottom: 20px;
}
</style>
