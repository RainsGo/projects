<template>
    <div id="app">
        <Navbar></Navbar>
        <div class="content">
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
        <rFooter></rFooter>
        <!--
        <div id="background">
        <div class="section " id="section1"><h1>2 Page</h1></div>
        <div class="section" id="section2"><h1>2 Page</h1></div>
        <div class="section" id="section1">
            <div class="slide" id="slide1"><h1>2 Page 1</h1></div>
            <div class="slide" id="slide2"><h1>2 Page 2</h1></div>
        </div>
        <div class="section" id="section3"><h1>3 Page</h1></div>
        <div class="section" id="section4"><h1>4 Page</h1></div>
        </div>
        -->
    </div>
</template>

<style scoped lang="less">
    @animateTime: 1s;
    /*
    @import "../common/css/index.css";
    @import "../common/css/jquery.fullPage.css";
    */
    html, body, #app {
        transition: all @animateTime;
        -moz-transition: all @animateTime;
        -webkit-transition: all @animateTime;
        -o-transition: all @animateTime;
    }

    #app {
        position: absolute;
        height: 100%;
        width: 100%;
        margin: 0;
        color: white;
    }

    .content {
        min-height: 100%;
        min-width: 100%;
        margin: 0px 0px -50px 0px; /* 等于footer的高度 */
        padding-top: 80px;
        //background-image: url(common/images/bg1.jpg);
        background-color: #9ea7b4;
    }
</style>

<script type="text/ecmascript-6">
    //import 'common/js/jquery.fullPage'
    import Navbar from 'components/navbar/navbar-ivew.vue'
    import rFooter from 'components/footer/footer.vue'

    export default {
        name: 'app',
        components: {
            Navbar,
            rFooter
        },
        mounted() {
            this.$Message.config({
                top: 100,
                duration: 2
            });
            /*
            this.$nextTick(function () {
                window.Promise = window.Promise || require('es6-promise');
                $('#background').fullpage({
                    verticalCentered: false,

                    //to avoid problems with css3 transforms and fixed elements in Chrome, as detailed here: https://github.com/alvarotrigo/fullPage.js/issues/208
                    css3: false
                });
            })
            */
        }
    }
</script>
