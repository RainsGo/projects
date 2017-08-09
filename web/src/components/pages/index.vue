<template>
    <div v-bind:style="getTotalDocumentElementClientHeight">
        <Page1 v-bind:style="getDocumentElementClientHeight"></Page1>
        <Page2 v-bind:style="getDocumentElementClientHeight"></Page2>
        <Page3 v-bind:style="getDocumentElementClientHeight"></Page3>
        <Page4 v-bind:style="getDocumentElementClientHeight"></Page4>
        <Page5 v-bind:style="getDocumentElementClientHeight"></Page5>
        <Page6 v-bind:style="getDocumentElementClientHeight"></Page6>
    </div>
</template>

<script>
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
        data() {
            return {
                documentElementClientHeight: 0,
                totalDocumentElementClientHeight: 0
            }
        },
        mounted() {
            this.totalDocumentElementClientHeight = document.documentElement.clientHeight * 6;
            this.documentElementClientHeight = document.documentElement.clientHeight;
        },
        watch: {
            'document.documentElement.clientHeight'() {
                this.documentElementClientHeight = document.documentElement.clientHeight;
            }
        },
        computed: {
            getDocumentElementClientHeight() {
                return "height: " + this.documentElementClientHeight + "px";
            },
            getTotalDocumentElementClientHeight() {
                return "height: " + this.totalDocumentElementClientHeight + "px";
            }
        }
    }
</script>



<style scoped>
    .page {
        height: 100%;
        width: 100%;
        text-align: center;
    }
</style>
