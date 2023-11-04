import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/home'
  },
  {
    path:'/home',
    component: () => import('@/views/home/index.vue'),
    redirect: '/home/homepage',
    children: [
      { 
        path: 'homepage',
        component: () => import('@/views/home/homepage.vue')
      },
      { 
        path: 'grade',
        component: () => import('@/views/grade/index.vue')
      },
    ]
  }
]

const router = new VueRouter({
  routes
})

export default router
