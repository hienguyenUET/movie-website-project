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
            src="https://www.10wallpaper.com/wallpaper/2560x1600/1610/Doctor_Strange-2016_Movie_Poster_Wallpaper_2560x1600.jpg"
            class="d-block w-100"
            alt="..."
          />
          <div class="carousel-caption d-none d-md-block">
            <h5><strong>Doctor Strange</strong></h5>
          </div>
        </div>
        <div class="carousel-item" data-bs-interval="2000">
          <img
            src="https://8ternal.com.vn/wp-content/uploads/2018/04/15400_1920x1080.jpg"
            class="d-block w-100"
            alt="..."
          />
          <div class="carousel-caption d-none d-md-block">
            <h5><strong>The Avegers</strong></h5>
          </div>
        </div>
        <div class="carousel-item" data-bs-interval="2000">
          <img
            src="https://echannel.vn/wp-content/uploads/2019/04/civilwar.jpg"
            class="d-block w-100"
            alt="..."
          />
          <div class="carousel-caption d-none d-md-block">
            <h5><strong> Captain America: Civil World</strong></h5>
          </div>
        </div>
        <div class="carousel-item" data-bs-interval="2000">
          <img
            src="https://nld.mediacdn.vn/2019/4/25/3515432-endgamedek-15561710302491765206118.jpg"
            class="d-block w-100"
            alt="..."
          />
          <div class="carousel-caption d-none d-md-block">
            <h5><strong>Avengers: Endgame</strong></h5>
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
            <h5><strong>Avengers: Infinity War</strong></h5>
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
export default {
  name: 'WebBody',
};
</script>

<style s>
@import url("https://fonts.googleapis.com/css2?family=Cookie&family=Dancing+Script&family=Great+Vibes&family=Indie+Flower&family=Kaushan+Script&family=Open+Sans:wght@300&family=Sacramento&display=swap");

nav {
  font-weight: 500;
}
img {
  height: 500px;
  object-fit: cover;
}
.body {
  margin-top: 40px;
  display: flex;
}
</style>
