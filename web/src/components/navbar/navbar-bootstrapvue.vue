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

        <b-nav class="r-navbar-left">
            <b-nav-item>
                <i class=" fa fa-search"></i>
            </b-nav-item>
        </b-nav>

        <b-nav class="r-navbar-right">
            <b-nav-item to="/join">加入</b-nav-item>
            <b-nav-item to="/login">登陆</b-nav-item>
        </b-nav>

        <b-nav is-nav class="r-navbar-items r-navbar-items-left"
               v-bind:class="{'r-navbar-items-left-move': !isPageHome}">
            <b-nav-item to="/page1">Page1</b-nav-item>
            <b-nav-item to="/page2">Page2</b-nav-item>
            <b-nav-item to="/page3">Page3</b-nav-item>
        </b-nav>

        <b-nav is-nav class="r-navbar-items r-navbar-items-right"
               v-bind:class="{'r-navbar-items-right-move': !isPageHome}">
            <b-nav-item to="/page4">Page4</b-nav-item>
            <b-nav-item to="/page5">Page5</b-nav-item>
            <b-nav-item to="/page6">Page6</b-nav-item>
        </b-nav>
    </div>
</template>

<style scoped lang="less">
    @animateTime: 0.7s;

    .r-navbar {
        top: 0;
        width: 100%;
        border: 1px solid transparent;
        z-index: 1000;
        height: 50px;
        min-height: 50px;
        margin-bottom: 20px;
        position: fixed;
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
        position: relative;
        float: left !important;
        font-size: 14px;
        padding: 0;
        margin: 7px 0px 0px 0px;
    }

    .r-navbar-right {
        position: relative;
        float: right !important;
        font-size: 14px;
        font-weight: bold;
        padding: 0;
        margin: 7px 0px 0px 0px;
    }

    .r-navbar-items {
        position: absolute;
        font-size: 14px;
        color: black;
        padding: 0;
        margin: 7px 0px 0px 0px;
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

    .btn-secondary {
        background-color: transparent;
        border-color: transparent;
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
            }
        },
        components: {},
        methods: {
            onMouseOver(event){
                //console.log("[navbar] onMouseOver: ", this.isOnMouse)
                this.isMouseOver = true;
            },
            onMouseOut(){
                //console.log("[navbar] onMouseOut: ", this.isOnMouse)
                this.isMouseOver = false;
            },
        },
        watch: {
            $route: function () {
                //console.log("[navbar] $route: ", this.$route)
                if (this.$route.path === "/") {
                    this.isPageHome = true;
                } else {
                    this.isPageHome = false;
                }
            },
        },
        computed: {
        },
        beforeCreate() {
            //console.log('[navbar] beforeCreate')
        },
        created: function () {
            //console.log('[navbar] created')
            //this.navbarBgColor = Object.assign({}, this.color)
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
            //console.log('[navbar] mounted')
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
        beforeDestroy()  {
            //console.log('[navbar] beforeDestroy')
        },
        destroyed() {
            //console.log('[navbar] destroyed')
        }
    }
</script>
