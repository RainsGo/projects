<template>
    <div class="navbar">
        <router-link tag="div" class="navbar-item" to="/page1">
            <span class="navbar-link">推荐</span>
        </router-link>
        <router-link tag="div" class="navbar-item" to="/page2">
            <span class="navbar-link">歌手</span>
        </router-link>
        <router-link tag="div" class="navbar-item" to="/page3">
      <span class="navbar-link">排行
      </span>
        </router-link>
        <router-link tag="div" class="navbar-item" to="/page4">
            <span class="navbar-link">搜索</span>
        </router-link>
    </div>
</template>

<script type="text/ecmascript-6">
    export default {
        name: 'navbar',
        component:{}
    }
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">
    @import "~common/stylus/variable"
    .navbar
        display: flex
        height: 44px
        line-height: 44px
        font-size: $font-size-medium
        .navbar-item
            flex: 1
            text-align: center
            .navbar-link
                padding-bottom: 5px
                color: $color-text-l
            &.router-link-active
                .navbar-link
                    color: $color-theme
                    border-bottom: 2px solid $color-theme
</style>
