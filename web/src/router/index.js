import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

// 引用模板
import Home from 'components/home/home.vue'
import Join from 'components/login/join.vue'
import Login from 'components/login/login.vue'
import Page1 from 'components/test/page1.vue'
import Page2 from 'components/test/page2.vue'
import Page3 from 'components/test/page3.vue'
import Page4 from 'components/test/page4.vue'
import Page5 from 'components/test/page5.vue'
import Page6 from 'components/test/page6.vue'
import NotFound from 'components/error/notFound.vue'

// 配置路由
export default new VueRouter({
    routes: [
        {
            path: '/',
            component: Home
        },
        {
            path: '/join',
            component: Join
        },
        {
            path: '/login',
            component: Login
        },
        {
            path: '/page1',
            component: Page1
        },
        {
            path: '/page2',
            component: Page2
        },
        {
            path: '/page3',
            component: Page3
        },
        {
            path: '/page4',
            component: Page4
        },
        {
            path: '/page5',
            component: Page5
        },
        {
            path: '/page6',
            component: Page6
        },
        {
            path: '*',
            component: NotFound
        }
    ]
})
