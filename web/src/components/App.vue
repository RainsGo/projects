<template>
    <div id="app">
        <navbar></navbar>
        <div id="pages">
            <keep-alive>
                <transition name="fade" mode="out-in">
                    <router-view>
                        class="view"
                        keep-alive
                        transition
                        transition-mode="out-in">
                    </router-view>
                </transition>
            </keep-alive>
        </div>
        <div id="background">
            <div class="section " id="section1">
            </div>
            <div class="section" id="section2"><h1>2 Page</h1></div>
            <!--
            <div class="section" id="section1">
                <div class="slide" id="slide1"><h1>2 Page 1</h1></div>
                <div class="slide" id="slide2"><h1>2 Page 2</h1></div>
            </div>
            -->
            <div class="section" id="section3"><h1>3 Page</h1></div>
            <div class="section" id="section4"><h1>4 Page</h1></div>
        </div>
    </div>
</template>

<style type="text/css">
    @import "../common/css/index.css";
    @import "../common/css/jquery.fullPage.css";

    #pages {
        position: absolute;
        margin-top: 0px;
        height: 100%;
        width: 100%;
        z-index: 2;
    }
</style>

<script type="text/ecmascript-6">
    import 'common/js/jquery.fullPage'
    import Navbar from 'components/navbar/navbar-bootstrapvue.vue'

    export default {
        name: 'app',
        components: {
            Navbar
        },
        mounted(){
            this.$nextTick(function () {
                window.Promise = window.Promise || require('es6-promise');
                $('#background').fullpage({
                    verticalCentered: false,

                    //to avoid problems with css3 transforms and fixed elements in Chrome, as detailed here: https://github.com/alvarotrigo/fullPage.js/issues/208
                    css3: false
                });
            })
        }
    }
</script>
