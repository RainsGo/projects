<template>
    <swiper :options="swiperOption" v-bind:style="getDocumentElementClientHeight">
        <swiper-slide><Page1></Page1></swiper-slide>
        <swiper-slide><Page2></Page2></swiper-slide>
        <swiper-slide><Page3></Page3></swiper-slide>
        <swiper-slide><Page4></Page4></swiper-slide>
        <swiper-slide><Page5></Page5></swiper-slide>
        <swiper-slide><Page6></Page6></swiper-slide>
        <div class="swiper-pagination" slot="pagination"></div>
    </swiper>
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
                swiperOption: {
                    pagination: '.swiper-pagination',
                    direction: 'vertical',
                    slidesPerView: 1,
                    paginationClickable: true,
                    spaceBetween: 30,
                    mousewheelControl: true
                },
                documentElementClientHeight: 0
            }
        },
        mounted() {
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
