import { createApp } from 'vue'
import App from './App.vue'

const app = createApp(App);
import 'bootstrap/dist/css/bootstrap.css'
import "bootstrap/dist/js/bootstrap.js"
import axios from 'axios'
import VueAxios from 'vue-axios'
app.use(VueAxios, axios)
import router from './router'
import { initializeApp } from 'firebase/app';
app.use(router);

const firebaseConfig = {
    apiKey: "AIzaSyAUWYG1vBqNt0w6N5yuaVpeKCqfNfMZqmo",
    authDomain: "movies-projects.firebaseapp.com",
    projectId: "movies-projects",
    storageBucket: "movies-projects.appspot.com",
    messagingSenderId: "423774417709",
    appId: "1:423774417709:web:c500e74309e3252e61d9a4",
    measurementId: "G-BM08H7Y2B5"
};

initializeApp(firebaseConfig)

// export { auth }


import SignUp from './components/SignUp.vue'
import LoginForm from './components/LoginForm.vue'
import MovieDetail from './components/MovieDetail.vue'
app.component('sign-up', SignUp)
app.component('login-form', LoginForm)
app.component('movie-detail', MovieDetail)
app.mount('#app')