// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
// https://trakt.tv/
import Vue from 'vue'

// 引入动画插件
import 'animate.css'

// 引用ui组件 bootstrap-vue
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
Vue.use(BootstrapVue)

// 引用ui组件 iview
import iView from 'iview'
import 'iview/dist/styles/iview.css'
import 'theme/iview/custom-rainsgo.less'
Vue.use(iView)

// 引入单页滚动插件
import 'animate.css'
import VueFullpage from 'vue-fullpage'
Vue.use(VueFullpage)

// 引入滑动插件
import 'swiper/dist/css/swiper.css'
import VueAwesomeSwiper from 'vue-awesome-swiper'
Vue.use(VueAwesomeSwiper)

// 屏幕分辨率适配
import VueViewports from 'vue-viewports'
Vue.use(VueViewports, { 420: 'mobile', 768: 'tablet', 1024: 'desktop', 1920: 'hd-desktop', 2560: 'qhd-desktop', 3840: 'uhd-desktop' })

// 引用App主入口
import App from '@/App.vue'

// 引用路由配置文件
import router from 'router/index.js'

// 引入vuex
import store from 'store/index.js'

// 引入bootstrap样式
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

// 引入fonts
import 'common/fonts/font-awesome/css/font-awesome.css'

// passive默认设置为true
import 'default-passive-events/default-passive-events.js'

// import 'animate.css'

// 导入国际化
import i18n from 'components/i18n/index.js'

new Vue({
    i18n,
    el: '#app',
    router,
    store,
    render: h => h(App)
})
