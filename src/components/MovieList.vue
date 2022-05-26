<template>
  <h5>DANH SÁCH CÁC PHIM YÊU THÍCH</h5>
  <div class="movies__list">
    <div class="each__movie" v-for="movie in moviesList" :key="movie.id">
      <router-link :to="'/movie/' + movie.idAPI"
        ><img id="poster" :src="movie.profilePath" alt="" />
        <div id="detail">
          <p><strong>Tên:</strong> {{ movie.title }}</p>
          <p><strong>Ngày Phát Hành: </strong>{{ movie.releaseDate }}</p>
        </div></router-link
      >
    </div>
  </div>
</template>


<script>
import axios from "axios";
import { ref, onMounted } from "vue";
export default {
  name: "MovieList",
  setup() {
    const moviesList = ref([]);
    onMounted(() => {
      axios.get("http://localhost:8081/user/favorite").then((res) => {
        moviesList.value = res.data;
      });
    });
    return {
      moviesList,
    };
  },
};
</script>
<style scoped>
.movies__list {
  display: flex;
  justify-content: space-between;
  flex-wrap: wrap;
  margin: 50px;
}
a {
  text-decoration: none;
  color: #000;
}
h5 {
  margin-top: 50px;
  text-align: center;
}
.each__movie {
  width: 21%;
  margin-bottom: 50px;
}
#poster,
#detail {
  width: 100%;
}
</style>
