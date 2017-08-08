<template>
    <div class="r-home">
        <h1>page1</h1>
        <router-link to="/">home</router-link>
        <router-view></router-view>
    </div>
</template>

<style scoped lang="less">
    .r-home {
        position: absolute;
        height: 100%;
        width: 100%;
        text-align: center;
        background-image: url(../../common/images/bg3.jpg);
        background-size: 100% 100%;
    }
</style>
