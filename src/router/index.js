import { createRouter, createWebHistory } from 'vue-router';
import LandingPage from '../components/LandingPage.vue';
import LoginForm from '../components/LoginForm.vue';
import SignUp from '../components/SignUp.vue';
const routes = [{
        path: '/signup',
        component: SignUp
    },
    {
        path: '/login',
        component: LoginForm
    },
    {
        path: '/',
        component: LandingPage
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router