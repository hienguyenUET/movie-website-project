import { createApp } from 'vue'
import App from './App.vue'
import 'bootstrap/dist/css/bootstrap.css'
import "bootstrap/dist/js/bootstrap.js"
const app = createApp(App);
import axios from 'axios'
import VueAxios from 'vue-axios'
app.use(VueAxios, axios)
import router from './router/'
app.use(router);
import MovieList from './components/MovieList.vue'
import SignUp from './components/SignUp.vue'
import LoginForm from './components/LoginForm.vue'
import WebFooter from './components/WebFooter.vue'
app.component('movie-list', MovieList);
app.component('sign-up', SignUp)
app.component('login-form', LoginForm)
app.component('web-footer', WebFooter)
app.mount('#app')