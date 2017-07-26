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
    </div>
</template>

<style scoped lang="less">
    .r-home {
        height: 1000px;
        text-align: center;
        margin-top: 100px;
    }
</style>

<script type="text/ecmascript-6">
    import {mapGetters, mapMutations} from "vuex"

    export default {
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
