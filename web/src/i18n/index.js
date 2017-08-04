import Vue from 'vue'
import VueI18n from 'vue-i18n'

Vue.use(VueI18n)

import en from './lang/en'
import cn from './lang/cn'

const messages = {
    en,
    cn
}

// 获取用户浏览器优先选择语言
function getLanguage () {
    let lang
    if (navigator.language) {
        lang = navigator.language
    } else {
        lang = navigator.browserLanguage
    }
    return lang
}

let loc

// 判断用户使用的语言
if (getLanguage() === 'zh-CN') {
    loc = 'cn'
} else {
    loc = 'en'
}
export default new VueI18n({
    locale: loc, // set locale
    messages // set locale messages
})
debugger
