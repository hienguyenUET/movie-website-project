<template>
  <header>
    <div class="logo">
      <div class="logo-details">
        <svg
          xmlns="http://www.w3.org/2000/svg"
          width="30"
          height="30"
          fill="currentColor"
          class="bi bi-film"
          viewBox="0 0 20 20"
        >
          <path
            d="M0 1a1 1 0 0 1 1-1h14a1 1 0 0 1 1 1v14a1 1 0 0 1-1 1H1a1 1 0 0 1-1-1V1zm4 0v6h8V1H4zm8 8H4v6h8V9zM1 1v2h2V1H1zm2 3H1v2h2V4zM1 7v2h2V7H1zm2 3H1v2h2v-2zm-2 3v2h2v-2H1zM15 1h-2v2h2V1zm-2 3v2h2V4h-2zm2 3h-2v2h2V7zm-2 3v2h2v-2h-2zm2 3h-2v2h2v-2z"
          />
        </svg>
        <h1>PhimMovi.com</h1>
        <svg
          xmlns="http://www.w3.org/2000/svg"
          width="16"
          height="16"
          fill="currentColor"
          class="bi bi-badge-hd-fill"
          viewBox="0 0 16 16"
        >
          <path
            d="M10.53 5.968h-.843v4.06h.843c1.117 0 1.622-.667 1.622-2.02 0-1.354-.51-2.04-1.622-2.04z"
          />
          <path
            d="M2 2a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V4a2 2 0 0 0-2-2H2zm5.396 3.001V11H6.209V8.43H3.687V11H2.5V5.001h1.187v2.44h2.522V5h1.187zM8.5 11V5.001h2.188c1.824 0 2.685 1.09 2.685 2.984C13.373 9.893 12.5 11 10.69 11H8.5z"
          />
        </svg>
      </div>

      <div class="signup-login">
        <div>
          <button v-if="!isLoggedIn" class="btn btn-danger">
            <router-link to="/signup">Đăng ký</router-link>
          </button>
        </div>
        <div>
          <button v-if="!isLoggedIn" class="btn btn-primary">
            <router-link to="/login">Đăng nhập</router-link>
          </button>
        </div>
        <div v-if="isLoggedIn">
          <div class="nav-item dropdown">
            <div
              class="active info dropdown-toggle"
              id="navbarDropdown"
              role="button"
              data-bs-toggle="dropdown"
              aria-expanded="false"
            >
            <strong>Welcome,</strong>
              <span
                ><i><strong>{{ username }}</strong></i></span>
              <img id="avatar" :src="userImg" alt="">
            </div>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <div id="profile"><router-link id="route" :to="'/user/' + userID ">Thông Tin Cá Nhân</router-link> </div>
              <div id="signout" @click="handleSignOut()">Đăng Xuất</div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <nav class="navbar navbar-expand-lg navbar-dark">
      <div class="container-fluid">
        <router-link to="/" class="navbar-brand"
          >Trang Chủ</router-link
        >
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <router-link
                to="/popularity"
                class="nav-link active"
                aria-current="page"
                >Phổ Biến</router-link
              >
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#"></a>
            </li>
            <li class="nav-item dropdown">
              <router-link
                to=""
                class="nav-link active dropdown-toggle"
                id="navbarDropdown"
                role="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                Nội Dung
              </router-link>
              <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                <li>
                  <router-link to="/actionfilm" class="dropdown-item"
                    >Phim Hành Động</router-link
                  >
                </li>
                <li>
                  <router-link to="/adventurefilm" class="dropdown-item"
                    >Phim Phiêu Lưu</router-link
                  >
                </li>
                <li>
                  <router-link to="/horrorfilm" class="dropdown-item"
                    >Phim Kinh Dị</router-link
                  >
                </li>
                <li>
                  <router-link to="/comedyfilm" class="dropdown-item"
                    >Phim Hài Kịch</router-link
                  >
                </li>
              </ul>
            </li>
            <li class="nav-item dropdown">
              <router-link
                to=""
                class="nav-link active dropdown-toggle"
                id="navbarDropdown"
                role="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                Thể Loại
              </router-link>
              <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                <li>
                  <router-link to="featurefilm" class="dropdown-item"
                    >Phim Điện Ảnh</router-link
                  >
                </li>
                <li>
                  <router-link to="tvmovies" class="dropdown-item"
                    >Phim Truyền Hình</router-link
                  >
                </li>
              </ul>
            </li>
          </ul>
          <form class="d-flex search-box">
            <button class="btn btn-success" type="submit" value="search">
              <router-link class="search-btn" to="/search"
                >Search Movie</router-link
              >
            </button>
          </form>
        </div>
      </div>
    </nav>
  </header>
</template>
<script>
import { onMounted, ref } from "vue";
import { getAuth, onAuthStateChanged, signOut } from "firebase/auth";
import { useRouter } from "vue-router";
export default {
  name: "WebHeader",
  setup() {
    const isLoggedIn = ref(false);
    const username = ref("");
    const userID = ref("")
    const userImg = ref("")
    const router = useRouter();
    let auth;
    onMounted(() => {
      auth = getAuth();
      onAuthStateChanged(auth, (user) => {
        if (user) {
          isLoggedIn.value = true;
          username.value = user.displayName;
          userID.value = user.uid;
          userImg.value = user.photoURL
          // console.log(user);
        } else {
          isLoggedIn.value = false;
        }
      });
    });
    const handleSignOut = () => {
      signOut(auth).then(() => {
        router.push("/login");
      });
    };
    return {
      handleSignOut,
      isLoggedIn,
      username,
      userID,
      userImg
    };
  },
};
</script>

<style scoped>
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
.info {
  font-size: 15px;
  display: flex;
}
span {
  margin-left: 5px;
  color: yellow;
}
#signout:hover, #route:hover {
  color: rgb(61, 168, 132);
}
#signout {
  cursor: pointer;
  font-size: 15px;
  margin-top: 8px;
}
#profile {
  cursor: pointer;
  font-size: 15px;
}
#route {
  text-decoration: none;
  color: black;
}
#avatar {
  margin-left: 10px;
  width: 40px;
  height: 40px;
  border-radius: 50%;
  object-fit: cover;
}
</style>
