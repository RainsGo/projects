import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

// 引用模板
import Register from 'components/auth/register.vue'
import Login from 'components/auth/login.vue'
import Reset from 'components/auth/reset.vue'
import Home from 'components/pages/index.vue'
import Page1 from 'components/test/page1.vue'
import Page2 from 'components/test/page2.vue'
import Page3 from 'components/test/page3.vue'
import Page4 from 'components/test/page4.vue'
import Page5 from 'components/test/page5.vue'
import Page6 from 'components/test/page6.vue'
import Test from 'components/test/home.vue'
import NotFound from 'components/error/notFound.vue'

// 配置路由
export default new VueRouter({
    routes: [
        {
            path: '/',
            name: 'home',
            component: Home
        },
        {
            path: '/test',
            name: 'test',
            component: Test
        },
        {
            path: '/register',
            name: 'register',
            component: Register
        },
        {
            path: '/login',
            name: 'login',
            component: Login
        },
        {
            path: '/reset',
            name: 'reset',
            component: Reset
        },
        {
            path: '/page1',
            name: 'page1',
            component: Page1
        },
        {
            path: '/page2',
            name: 'page2',
            component: Page2
        },
        {
            path: '/page3',
            name: 'page3',
            component: Page3
        },
        {
            path: '/page4',
            name: 'page4',
            component: Page4
        },
        {
            path: '/page5',
            name: 'page5',
            component: Page5
        },
        {
            path: '/page6',
            name: 'page6',
            component: Page6
        },
        {
            path: '*',
            component: NotFound
        }
    ]
})
