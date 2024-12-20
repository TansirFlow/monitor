import { createRouter, createWebHashHistory } from 'vue-router'

import Home from '@/view/Home.vue'

const routes = [
    {
        path: '/', name: 'home', component: Home, meta: { title: '服务器监控' }
    },
]

const router = createRouter({
    history: createWebHashHistory(),
    routes: routes,

})

export default router

