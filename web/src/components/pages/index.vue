<template>
    <md-card>
        <md-card-actions>
            <div class="md-subhead">
                <span>inner-scroll</span>
                <span>（</span>
                <span>在里面滚动</span>
                <span>）</span>
            </div>
            <md-button class="md-icon-button"
                       target="_blank"
                       href="https://github.com/surmon-china/vue-awesome-swiper/blob/master/examples/38-inner-scroll.vue">
                <md-icon>code</md-icon>
            </md-button>
        </md-card-actions>
        <md-card-media>
            <!-- swiper -->
            <swiper :options="parentSwiperOption" class="parent-swiper" ref="pSwiper">
                <swiper-slide><page1></page1></swiper-slide>
                <swiper-slide>
                    <swiper :options="childSwiperOption" class="child-swiper">
                        <swiper-slide><page2></page2></swiper-slide>
                        <div class="swiper-scrollbar" slot="scrollbar"></div>
                    </swiper>
                </swiper-slide>
                <swiper-slide><page3></page3></swiper-slide>
                <swiper-slide><page4></page4></swiper-slide>
                <swiper-slide><page5></page5></swiper-slide>
                <swiper-slide><page6></page6></swiper-slide>
            </swiper>
        </md-card-media>
    </md-card>
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
            let self = this
            return {
                parentSwiperOption: {
                    direction : 'vertical',
                    mousewheelControl: true,
                    onSetTransition: function(swiper){
                        if (swiper.activeIndex == 1) {
                            swiper.params.onlyExternal = true;
                            swiper.disableMousewheelControl();
                        } else {
                            swiper.params.onlyExternal = false;
                            swiper.enableMousewheelControl();
                        }
                    }
                },
                childSwiperOption: {
                    scrollbar: '.swiper-scrollbar',
                    direction: 'vertical',
                    slidesPerView: 'auto',
                    freeMode: true,
                    freeModeMomentum: false,
                    mousewheelControl: true,
                    mousewheelSensitivity: 0.5,
                    onSetTransition(swiper, translate){
                        //translate 一直为0，不可直接用
                        let oSwiper = self.swiper
                        let nowTranslate = swiper.translate;
                        let beforeTranslate = beforeTranslate || 0;
                        let slideHeight = swiper.slides[0].scrollHeight;
                        let swiperHeight = swiper.height
                        if(nowTranslate > -2 && nowTranslate > beforeTranslate){ oSwiper.slideTo(0); }
                        if(slideHeight - swiperHeight + nowTranslate < 2 && nowTranslate < beforeTranslate){ oSwiper.slideTo(2); }
                        beforeTranslate = nowTranslate;
                    }
                }
            }
        },
        computed: {
            swiper() {
                return this.$refs.pSwiper.swiper
            }
        }
    }
</script>

<style scoped>
    .parent-swiper {
        height: 300px;
    }
    .child-swiper .swiper-slide{
        height: 600px;
    }
</style>
