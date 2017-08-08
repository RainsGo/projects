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
        </h4>
        <Page1></Page1>
        <Page2></Page2>
        <Page3></Page3>
    </div>
</template>

<style scoped lang="less">
    .r-home {
        height: 800;
        width: 100%;
        text-align: center;
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
