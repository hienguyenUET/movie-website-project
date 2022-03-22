import { createRouter, createWebHistory } from 'vue-router';
import WebBody from '../components/WebBody.vue';
import LoginForm from '../components/LoginForm.vue';
import SignUp from '../components/SignUp.vue';
const router = createRouter({
    history: createWebHistory(),
    routes: [{
            path: '/',
            component: WebBody
        },
        {
            path: '/signup',
            component: SignUp
        },
        {
            path: '/login',
            component: LoginForm
        }
    ]
})
export default router