<template>
    <div class="r-home">
        <h1>home</h1>
        <h4>
            <p>
                Todos: {{todosDoneCount}}
            </p>
            <p>
                Counter: {{count}} <br>
                <b-button @click="increment">+</b-button>
                <b-button @click="decrement">-</b-button>
            </p>

            <p>
                页面对象宽度（即BODY对象宽度加上Margin宽）：document.documentElement.clientWidth = {{documentDocumentElementClientWidth}}
            </p>
            <p>
                页面对象高度（即BODY对象高度加上Margin高）：document.documentElement.clientHeight = {{documentDocumentElementClientHeight}}
            </p>
            <p>
            网页可见区域宽：document.body.clientWidth = {{documentBodyClientWidth}}
            </p>
            <p>
            网页可见区域高：document.body.clientHeight = {{documentBodyClientHeight}}
            </p>
            <p>
            网页可见区域宽：document.body.offsetWidth (包括边线的宽) = {{documentBodyOffsetWidth}}
            </p>
            <p>
            网页可见区域高：document.body.offsetHeight (包括边线的宽) = {{documentBodyOffsetHeight}}
            </p>
            <p>
            网页正文全文宽：document.body.scrollWidth = {{documentBodyScrollWidth}}
            </p>
            <p>
            网页正文全文高：document.body.scrollHeight = {{documentBodyScrollHeight}}
            </p>
            <p>
            网页被卷去的高：document.body.scrollTop = {{documentBodyScrollTop}}
            </p>
            <p>
            网页被卷去的左：document.body.scrollLeft = {{documentBodyScrollLeft}}
            </p>
            <p>
            网页正文部分上：window.screenTop = {{windowScreenTop}}
            </p>
            <p>
            网页正文部分左：window.screenLeft = {{windowScreenLeft}}
            </p>
            <p>
            屏幕分辨率的高：window.screen.height = {{windowScreenHeight}}
            </p>
            <p>
            屏幕分辨率的宽：window.screen.width = {{windowScreenWidth}}
            </p>
            <p>
            屏幕可用工作区高度：window.screen.availHeight = {{windowScreenAvailHeight}}
            </p>
            <p>
            屏幕可用工作区宽度：window.screen.availWidth = {{windowScreenAvailWidth}}
            </p>
        </h4>
        <Page1></Page1>
        <Page2></Page2>
        <Page3></Page3>
    </div>
</template>

<style scoped lang="less">
    .r-home {
        height: 800   ;
        width: 100%;
        text-align: left;
        background-image: url(../../common/images/bg2.jpg);
        background-size: contain;
    }
</style>

<script type="text/ecmascript-6">
    import {mapGetters, mapMutations} from "vuex"

    import Page1 from 'components/test/page1.vue'
    import Page2 from 'components/test/page2.vue'
    import Page3 from 'components/test/page3.vue'
    import Page4 from 'components/test/page4.vue'
    import Page5 from 'components/test/page5.vue'
    import Page6 from 'components/test/page6.vue'

    export default {
        components: {
            Page1,
            Page2,
            Page3,
            Page4,
            Page5,
            Page6
        },
        computed: {
            count() {
                return this.count
            },
            todosDoneCount() {
                return this.todosDoneCount
            },
            documentDocumentElementClientHeight() {
                return document.documentElement.clientHeight;
            },
            documentDocumentElementClientWidth() {
                return document.documentElement.clientWidth;
            },
            documentBodyClientHeight() {
                return document.body.clientHeight;
            },
            documentBodyClientWidth() {
                return document.body.clientWidth;
            },
            documentBodyOffsetWidth() {
                return document.body.offsetWidth;
            },
            documentBodyOffsetHeight() {
                return document.body.offsetHeight;
            },
            documentBodyScrollWidth() {
                return document.body.scrollWidth;
            },
            documentBodyScrollHeight() {
                return document.body.scrollHeight;
            },
            documentBodyScrollTop() {
                return document.body.scrollTop;
            },
            documentBodyScrollLeft() {
                return document.body.scrollLeft;
            },
            windowScreenTop() {
                return window.screenTop;
            },
            windowScreenLeft() {
                return window.screenLeft;
            },
            windowScreenHeight() {
                return window.screen.height;
            },
            windowScreenWidth() {
                return window.screen.width;
            },
            windowScreenAvailHeight() {
                return window.screen.availHeight;
            },
            windowScreenAvailWidth() {
                return window.screen.availWidth;
            },
            ...mapGetters([
                "count",
                "todosDoneCount"
            ])
        },
        methods: {
            ...mapMutations([
                "increment",
                "decrement"
            ])
        }
    }
</script>
