// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
// https://trakt.tv/
import Vue from 'vue'

// 引用ui组件 bootstrap-vue
import BootstrapVue from 'bootstrap-vue'
Vue.use(BootstrapVue)

// 引用ui组件 iview
import iView from 'iview'
Vue.use(iView)

// 引用App主入口
import App from 'components/App.vue'

// 引用路由配置文件
import router from 'router/index.js'

// 引入vuex
import store from 'store/index.js'

// 引入bootstrap样式
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

// 引入iView样式
import 'iview/dist/styles/iview.css'

// 引入fonts
import 'common/fonts/font-awesome/css/font-awesome.css'

// passive默认设置为true
import 'default-passive-events/default-passive-events.js'

// import 'animate.css'

new Vue({
    el: '#app',
    router,
    store,
    render: h => h(App)
})
