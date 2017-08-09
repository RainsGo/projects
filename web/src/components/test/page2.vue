<template>
    <div class="r-home">
        <h1>page2</h1>
        <router-link to="/">home</router-link>
        <router-view></router-view>
    </div>
</template>

<style scoped lang="less">
    .r-home {
        height: 100%;
        width: 100%;
        text-align: center;
        background-image: url(../../common/images/bg4.jpg);
        background-size: 100% 100%;
    }
</style>
