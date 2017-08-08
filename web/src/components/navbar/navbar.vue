<template>
    <div id="navbar" class="r-navbar" sticky="sticky-top"
         v-on:mouseover="onMouseOver($event)"
         v-on:mouseout="onMouseOut($event)"
         v-bind:class="{'r-navbar-on-mouse-over': isMouseOver, 'r-navbar-not-page-home': !isPageHome}"
    >
        <transition name="logo-fade">
            <router-link class="r-navbar-logo" v-if="!isPageHome" to="/">
                <img width="65px" src="../../common/images/logo-r.svg"></img>
            </router-link>
        </transition>

        <Button class="r-navbar-left" type="text">
            <i class=" fa fa-search"></i>
        </Button>

        <Button-group class="r-navbar-items r-navbar-items-left"
                      v-bind:class="{'r-navbar-items-left-move': !isPageHome}">
            <router-link to="/page1">
                <Button type="text">Page1</Button>
            </router-link>
            <router-link to="/page2">
                <Button type="text">Page2</Button>
            </router-link>
            <router-link to="/page3">
                <Button type="text">Page3</Button>
            </router-link>
        </Button-group>

        <Button-group class="r-navbar-items r-navbar-items-right"
                      v-bind:class="{'r-navbar-items-right-move': !isPageHome}">
            <router-link to="/page4">
                <Button type="text">Page4</Button>
            </router-link>
            <router-link to="/page5">
                <Button type="text">Page5</Button>
            </router-link>
            <router-link to="/page6">
                <Button type="text">Page6</Button>
            </router-link>
        </Button-group>

        <div class="r-navbar-right">
            <Dropdown placement="bottom-start" trigger="hover" @on-click="switchLang">
                <Button type="text" class="r-navbar-text">
                    {{getLangCurrent}}
                    <Icon type="arrow-down-b"></Icon>
                </Button>
                <Dropdown-menu slot="list">
                    <Dropdown-item class="r-dropdown-items" v-for="item in languageList" :name="item.id" :key="item.id" :divided="true"
                                   :selected="lang.id === item.id">
                        {{ $t(item.name) }}
                    </Dropdown-item>
                </Dropdown-menu>
            </Dropdown>
            <router-link to="/login">
                <Button type="text">{{$t('navbar.login')}}</Button>
            </router-link>
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
