<template>
  <WebHeader />
  <div class="movie-detail">
    <div class="video">
      <iframe
        title="movie.title"
        :src="getLink()"
        allowfullscreen
        allow="autoplay"
        frameborder="0"
      ></iframe>
      <!-- <iframe v-else-if="!getLink()" src="video.linkEmbed" frameborder="0"></iframe> -->
      <!-- <img v-else :src="movie.image" alt="" /> -->
    </div>
    <div class="content">
      <h2>{{ movie.title }}</h2>
      <p>
        <strong><i>Released: </i></strong>{{ movie.releaseDate }}
      </p>
      <p>
        <strong><i>Actors: </i></strong>{{ movie.stars }}
      </p>
      <p>
        <strong><i>Country: </i></strong>{{ movie.countries }}
      </p>
      <p>
        <strong><i>Genre: </i></strong>{{ movie.genres }}
      </p>
      <p>
        <strong><i>Companies Production: </i></strong> {{ movie.companies }}
      </p>
      <p>
        <strong><i>Directors: </i></strong> {{ movie.directors }}
      </p>
      <p>
        <strong><i>Runtime: </i></strong> {{ movie.runtimeStr }}
      </p>
      <div>
        <button>
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="16"
            height="16"
            fill="currentColor"
            class="bi bi-heart"
            viewBox="0 0 16 16"
          >
            <path
              d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"
            />
          </svg>
          Favourite
        </button>
        <button id="btnDel" v-if="isAdmin">Delete Film</button>
      </div>
    </div>
  </div>
  <form v-if="isAdmin" action="">
    <input type="text" v-model="name" />
    <input type="text" v-model="favourite" />
    <button @click.prevent="post()">Submit</button>
  </form>

  <p>
    <strong><i>Keywords: </i></strong> {{ movie.keywords }}
  </p>
  <p class="plot">
    <strong> <i>Plot: </i> </strong>{{ movie.plot }}
  </p>
  <h2>DIỄN VIÊN</h2>
  <div class="actor-list">
    <div class="actor-item" v-for="actor in actors" :key="actor.id">
      <div class="actorImg">
        <img :src="actor.image" alt="" />
      </div>
      <div class="actorInfo">
        <p>
          <strong>{{ actor.name }}</strong>
        </p>
      </div>
    </div>
  </div>
  <h2>PHIM LIÊN QUAN</h2>
  <div class="similar-list">
    <div class="similar-item" v-for="similar in similars" :key="similar.id">
      <router-link :to="'/movie/' + similar.id" class="similar-link">
        <div class="poster">
          <img :src="similar.image" alt="" />
        </div>
        <div class="similarInfo">
          <p class="title">
            <strong>{{ similar.title }}</strong>
          </p>
        </div>
      </router-link>
    </div>
  </div>
  <WebFooter />
</template>

<script>
import WebHeader from "./WebHeader.vue";
import WebFooter from "./WebFooter.vue";
import { ref, onMounted, watch } from "vue";
import { useRoute } from "vue-router";
import api from "@/api.js";
import axios from "axios";
import {getAuth, onAuthStateChanged} from 'firebase/auth'
export default {
  name: "MovieDetail",
  components: { WebHeader, WebFooter },
  setup() {
    const name = ref();
    const favourite = ref();
    const movie = ref({});
    const video = ref({});
    const actors = ref([]);
    const similars = ref([]);
    const isAdmin = ref(false);
    const route = useRoute();
    let auth;
    const post = onMounted(()=>{
      fetch('https://movies-projects-default-rtdb.asia-southeast1.firebasedatabase.app/user.json', {
        method: 'POST',
        headers: {
          'Content-type': 'application/json'
        },
        body: JSON.stringify({
          name : name.value,
          favourite : favourite.value
        })
      })
    })
    onMounted(() => {
      auth = getAuth();
      onAuthStateChanged(auth, (user) => {
        if (user) {
          if (user.email === 'admin@gmail.com') {
            isAdmin.value = true;
          }
        } else {
          return;
        }
      });
    });
    const title = onMounted(() => {
      axios
        .get(
          `https://imdb-api.com/en/API/Title/${api.apikey3}/${route.params.id}`
        )
        .then((data) => {
          movie.value = data.data;
        });
    });
    const getLink = () => {
      return "https://www.2embed.ru/embed/imdb/movie?id=" + route.params.id;
    };
    onMounted(() => {
      axios
        .get(
          `https://imdb-api.com/en/API/Trailer/${api.apikey3}/${route.params.id}`
        )
        .then((data) => {
          video.value = data.data;
        });
    });
    const actor = onMounted(() => {
      axios
        .get(
          `https://imdb-api.com/en/API/Title/${api.apikey3}/${route.params.id}`
        )
        .then((data) => {
          actors.value = data.data.actorList;
        });
    });
    const similiars = onMounted(() => {
      axios
        .get(
          `https://imdb-api.com/en/API/Title/${api.apikey3}/${route.params.id}`
        )
        .then((data) => {
          similars.value = data.data.similars;
        });
    });
    watch(route,()=>{
      similiars();
      actor();
      title();
    })
    return {
      name,
      favourite,
      movie,
      getLink,
      post,
      video,
      actors,
      similars,
      isAdmin
    };
  },
};
</script>

<style scoped>
.movie-detail {
  display: flex;
  /* justify-content: center; */
  /* align-items: center; */
  height: 550px;
  padding-right: 20px;
  margin-bottom: 20px;
  margin-top: 100px;
  background: linear-gradient(
    to bottom right,
    rgb(184, 39, 39),
    rgb(228, 214, 227)
  );
}
iframe {
  width: 755px;
  height: 550px;
  margin-right: 50px;
}
.content p {
  font-weight: 500;
}
.content {
  margin-top: -40px;
  text-shadow: 2px 2px 10px gray;
}
.actor-list {
  display: flex;
  flex-wrap: wrap;
}
.actor-item {
  margin: 7px;
}
.actorImg > img {
  width: 305px;
  height: 400px;
  border-radius: 5px;
}
h2 {
  margin-bottom: 30px;
  margin-top: 100px;
}
.similar-list {
  display: flex;
  flex-wrap: wrap;
}
.similar-item {
  margin: 3px;
}
.poster > img {
  width: 250px;
  height: 380px;
}
.similarInfo {
  width: 250px;
}
.similar-link {
  text-decoration: none;
  color: #000;
}
.title {
  color: red;
}
.content strong {
  color: rgb(7, 35, 161);
  text-decoration: underline;
}
.content button {
  margin-top: 20px;
  border: 0.5px solid rgb(51, 47, 47);
  border-radius: 5px;
  padding: 10px;
  background-color: rgb(212, 159, 60);
  color: black;
}
svg {
  margin-right: 5px;
}
#btnDel {
  margin-left: 10px;
}
/* .plot {
  font-size: 10px;
} */
</style>
