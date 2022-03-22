<template>
  <div class="body">
    <div
      id="carouselCaptions"
      class="carousel slide carousel-fade w-100"
      data-bs-ride="carousel"
    >
      <div class="carousel-indicators">
        <button
          type="button"
          data-bs-target="#carouselCaptions"
          data-bs-slide-to="0"
          class="active"
          aria-current="true"
          aria-label="Slide 1"
        ></button>
        <button
          type="button"
          data-bs-target="#carouselCaptions"
          data-bs-slide-to="1"
          aria-label="Slide 2"
        ></button>
        <button
          type="button"
          data-bs-target="#carouselCaptions"
          data-bs-slide-to="2"
          aria-label="Slide 3"
        ></button>
        <button
          type="button"
          data-bs-target="#carouselCaptions"
          data-bs-slide-to="3"
          aria-label="Slide 4"
        ></button>
        <button
          type="button"
          data-bs-target="#carouselCaptions"
          data-bs-slide-to="4"
          aria-label="Slide 5"
        ></button>
      </div>
      <div class="carousel-inner">
        <div class="carousel-item active" data-bs-interval="2500">
          <img
            src="https://fandom.vn/wp-content/uploads/2019/06/mcu-team-avengers-1.jpg"
            width="500px"
            class="d-block w-100"
            alt="..."
          />
          <div class="carousel-caption d-none d-md-block">
            <h5>Avengers: Age of Ultron</h5>
            <p>The battle with Ultron</p>
          </div>
        </div>
        <div class="carousel-item" data-bs-interval="2500">
          <img
            src="https://8ternal.com.vn/wp-content/uploads/2018/04/15400_1920x1080.jpg"
            class="d-block w-100"
            alt="..."
          />
          <div class="carousel-caption d-none d-md-block">
            <h5>The Avegers</h5>
            <p>First time together</p>
          </div>
        </div>
        <div class="carousel-item" data-bs-interval="2500">
          <img
            src="https://cdn.stereo.vn/uploads/2016/04/Captain-America-Civil-War-dat-diem-phe-binh-tuyet-doi-4.jpg"
            class="d-block w-100"
            alt="..."
          />
          <div class="carousel-caption d-none d-md-block">
            <h5>Captain America: Civil World</h5>
            <p>Conflict in opinion and thinking</p>
          </div>
        </div>
        <div class="carousel-item" data-bs-interval="2500">
          <img
            src="https://nld.mediacdn.vn/2019/4/25/3515432-endgamedek-15561710302491765206118.jpg"
            class="d-block w-100"
            alt="..."
          />
          <div class="carousel-caption d-none d-md-block">
            <h5>Avengers: Endgame</h5>
            <p>Final Battle</p>
          </div>
        </div>
        <div class="carousel-item" data-bs-interval="2500">
          <img
            src="https://static1.dienanh.net/upload/2018/04/09/avengers-infinity-war-cuoc-chien-vo-cuc-ad2fff.jpg"
            class="d-block w-100"
            alt="..."
          />
          <div class="carousel-caption d-none d-md-block">
            <h5>Avengers: Infinity War</h5>
            <p></p>
          </div>
        </div>
      </div>
      <button
        class="carousel-control-prev"
        type="button"
        data-bs-target="#carouselCaptions"
        data-bs-slide="prev"
      >
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button
        class="carousel-control-next"
        type="button"
        data-bs-target="#carouselCaptions"
        data-bs-slide="next"
      >
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>
  </div>
</template>

<script>
// import LoginForm from 'LoginForm.vue'
// import SignUp from 'SignUp.vue'
export default {
  name: 'WebBody',
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Cookie&family=Dancing+Script&family=Great+Vibes&family=Indie+Flower&family=Kaushan+Script&family=Open+Sans:wght@300&family=Sacramento&display=swap");

nav {
  font-weight: 500;
}
img {
  height: 500px;
}
.body {
  margin-top: 40px;
  display: flex;
}
</style>
