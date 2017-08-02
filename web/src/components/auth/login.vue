<template>
    <div id="login" class="r-login">
            <div id="login_frame" :transition="transitionName">

                <div id="login_content">
                    <h2 class="login_title">RainsGo</h2>

                    <b-input-group class="login_input_username">
                        <b-form-input type="text"
                                      placeholder="Username or Email">
                        </b-form-input>
                        <b-input-group-addon slot="left">
                            <i class="fa fa-user-o" aria-hidden="true"></i>
                        </b-input-group-addon>
                    </b-input-group>

                    <b-input-group class="login_input_password">
                        <b-form-input type="text"
                                      placeholder="Password">
                        </b-form-input>
                        <b-input-group-addon slot="left">
                            <i class="fa fa-key" aria-hidden="true"></i>
                        </b-input-group-addon>
                    </b-input-group>

                    <router-link class="login_forget" to="/">forget?</router-link>

                    <button type="button" class="login_button btn btn-primary">登录</button>
                </div>
                <div class="login_bottom">
                    新来的?
                    <router-link to="/">加入我们 -> GO</router-link>
                </div>
            </div>
    </div>
</template>

<style scoped lang="less">

    .slide-fade-enter-active {
        transition: all .3s ease;
    }
    .slide-fade-leave-active {
        transition: all .8s cubic-bezier(1.0, 0.5, 0.8, 1.0);
    }
    .slide-fade-enter, .slide-fade-leave-to
        /* .slide-fade-leave-active for below version 2.1.8 */ {
        transform: translateX(10px);
        opacity: 0;
    }

    .r-login {
        height: 100%;
        width: 100%;
    }

    #login_background {
        height: 100%;
        width: 100%;
        margin: -100px 0px 0px 0px;
        text-align: center;
        background-image: url(../../common/images/bg5.jpg);
        filter: blur(3px);
        position: absolute;
    }

    #login_frame {
        position: absolute;
        width: 360px;
        margin-left: -180px;
        left: 50%;
        top: 100px;
        color: black;
        background-color: #f5f5f7;
        box-shadow: 0px 0px 20px #666666;
        border-radius: 3px;
        margin-bottom: 40px;
    }

    #login_content {
        height: 100%;
        width: 100%;
        padding: 30px 20px 30px 20px;
    }

    .login_title {
        width: 100%;
        text-align: center;
    }

    .login_input_username {
        margin: 30px 0px 20px 0px;
    }

    .login_button {
        width: 100%;
        margin: 20px 0px 0px 0px;
    }

    .login_bottom {
        width: 100%;
        padding: 20px;
        text-align: center;
        background-color: white;
        border-top: solid 1px #cccccc;
        border-radius: 0 0 3px 3px;
    }
</style>

<script type="text/ecmascript-6">
    export default {
        name: "login",
        data() {
            return {
                transition: "slide-left"
            }
        }
        /*
        watch: {
            '$route'(to, from) {
                const toDepth = to.path.split('/').length
                const fromDepth = from.path.split('/').length
                this.transitionName = toDepth < fromDepth ? 'slide-right' : 'slide-left'
            }
        }
        */
    }
</script>
