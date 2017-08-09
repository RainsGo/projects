<template>
    <div id="navbar" class="r-navbar" sticky="sticky-top"
         v-on:mouseover="onMouseOver($event)"
         v-on:mouseout="onMouseOut($event)"
         v-bind:class="{'r-navbar-on-mouse-over': isMouseOver, 'r-navbar-not-page-home': !isPageHome}"
    >

        <transition name="logo-fade">
            <b-link class="r-navbar-logo" v-if="!isPageHome" to="/">
                <img width="65px" src="../../common/images/logo-r.svg"></img>
            </b-link>
        </transition>

        <b-button class="r-navbar-left" variant="link" to="/">
            <i class=" fa fa-search"></i>
        </b-button>

        <b-button-group class="r-navbar-items r-navbar-items-left"
                        v-bind:class="{'r-navbar-items-left-move': !isPageHome}">
            <b-button variant="link" to="/page1">Page1</b-button>
            <b-button variant="link" to="/page2">Page2</b-button>
            <b-button variant="link" to="/page3">Page3</b-button>
        </b-button-group>


        <b-button-group class="r-navbar-items r-navbar-items-right"
                        v-bind:class="{'r-navbar-items-right-move': !isPageHome}">
            <b-button variant="link" to="/page4">Page4</b-button>
            <b-button variant="link" to="/page5">Page5</b-button>
            <b-button variant="link" to="/page6">Page6</b-button>
        </b-button-group>

        <div class="r-navbar-right">
            <b-dropdown v-bind:text=getLangCurrent variant="link">
                <b-dropdown-item class="r-dropdown-items" v-for="item in languageList" key="item.id"
                                 active="lang.id === item.id" @click="switchLang(item.id)">
                    {{ $t(item.name) }}
                </b-dropdown-item>
            </b-dropdown>
            <b-button variant="link" to="/login">{{$t('navbar.login')}}</b-button>
        </div>
    </div>
</template>

<style scoped lang="less">
    @animateTime: 1s;

    .r-navbar {
        position: fixed;
        top: 0;
        width: 100%;
        height: 50px;
        min-height: 50px;
        border: 1px solid transparent;
        z-index: 100;
        padding: 10px;
        background: rgba(0, 0, 0, 0);
        transition: background @animateTime;
        -moz-transition: background @animateTime;
        -webkit-transition: background @animateTime;
        -o-transition: background @animateTime;
    }

    .r-navbar-not-page-home {
        background: rgba(0, 0, 0, 0.4);
    }

    .r-navbar-on-mouse-over {
        background: rgba(0, 0, 0, 0.8);
    }

    .logo-fade-enter-active, .logo-fade-leave-active {
        transition: all @animateTime;
    }

    .logo-fade-enter, .logo-fade-leave-to {
        transform: translateY(-40px);
        opacity: 0;
    }

    .items-translate-enter-active, items-translate-leave-active {
        transition: margin-left @animateTime;
    }

    .items-translate-enter, .items-translate-leave-to {
        transform: translateX(-40px);
        opacity: 0;
    }

    .r-navbar-logo {
        position: absolute;
        left: 50%;
        width: 65px;
        margin: 10px 0px 0px -32.5px;
    }

    .r-navbar-left {
        float: left !important;
    }

    .r-navbar-right {
        float: right !important;
    }

    .r-navbar-items {
        position: absolute;
        transition: margin-right @animateTime, margin-left @animateTime;
        -moz-transition: margin-right @animateTime, margin-left @animateTime;
        -webkit-transition: margin-right @animateTime, margin-left @animateTime;
        -o-transition: margin-right @animateTime, margin-left @animateTime;
    }

    .r-navbar-items-left {
        right: 50%;
    }

    .r-navbar-items-right {
        left: 50%;
    }

    .r-navbar-items-left-move {
        margin-right: 50px;
    }

    .r-navbar-items-right-move {
        margin-left: 50px;
    }

    .r-dropdown-items{
        color: black;
    }
</style>

<script>
    // 引用Color组件
    //import Color from 'color-js';
    //import {actionTweenedColor, actionTweenedNumber} from 'api/animate.js'
    // 引入 Velocity动画
    //import Velocity from 'velocity-animate'

    export default {
        name: 'navbar',
        data() {
            return {
                isMouseOver: false,
                isPageHome: false,
                lang: {},
                languageList: {
                    cn: {
                        id: 'cn',
                        name: "lang.cn"
                    },
                    en: {
                        id: 'en',
                        name: "lang.en"
                    }
                }
            }
        },
        components: {},
        methods: {
            onMouseOver(event) {
                //console.log("[navbar] onMouseOver: ", this.isOnMouse)
                this.isMouseOver = true;
            },
            onMouseOut() {
                //console.log("[navbar] onMouseOut: ", this.isOnMouse)
                this.isMouseOver = false;
            },
            switchLang(id) {
                debugger
                if(id === 'cn'){
                    this.$i18n.locale = 'cn';
                    this.lang = this.languageList.cn;
                    localStorage.setItem('language', 'cn');
                }else{
                    this.$i18n.locale = 'en';
                    this.lang = this.languageList.en;
                    localStorage.setItem('language', 'en')
                }
            }
        },
        watch: {
            $route: function () {
                //console.log("[navbar] $route: ", this.$route)
                if (this.$route.name === "home") {
                    this.isPageHome = true;
                } else {
                    this.isPageHome = false;
                }
            }
        },
        computed: {
            getLangCurrent() {
                return this.$t(this.lang.name);
            }
        },
        beforeCreate() {
            //console.log('[navbar] beforeCreate')
        },
        created() {
        },
        beforeMount() {
            //console.log('[navbar] beforeMount')
            if (this.$route.path === "/") {
                this.isPageHome = true;
            } else {
                this.isPageHome = false;
            }
        },
        mounted() {
            let localLang = localStorage. getItem('language');
            if(localLang){
                this.$i18n.locale = localLang;
            }
            this.lang = this.languageList[this.$i18n.locale];
        },
        beforeUpdate() {
            //console.log('[navbar] beforeUpdate')
        },
        updated() {
            //console.log('[navbar] updated')
        },
        activated() {
            //console.log('[navbar] activated')
        },
        deactivated() {
            //console.log('[navbar] deactivated')
        },
        beforeDestroy() {
            //console.log('[navbar] beforeDestroy')
        },
        destroyed() {
            //console.log('[navbar] destroyed')
        }
    }
</script>
