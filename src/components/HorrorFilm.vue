<template>
  <div class="film-list">
    <h2>PHIM KINH DỊ</h2>
    <div class="film">
      <div class="film-item" v-for="film in films" :key="film.idAPI">
        <router-link :to="'/movie/' + film.idAPI" class="film-link">
          <div v-if="film.posterPath !== 'N/A'" class="poster">
            <img :src="film.posterPath" alt="Movie Poster" />
          </div>
          <div v-if="film.Poster !== 'N/A'" class="detail">
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
    axios.get("http://localhost:8081/movie/horror").then((res) => {
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
/* .poster {
    position: relative;
} */
.film {
  display: flex;
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
  transition: 0.5s;
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
</style>
