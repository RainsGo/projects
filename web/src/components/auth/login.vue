<template>
    <div id="login" class="r-login">
        <div id="login_frame" ref="abc">
            <div id="login_content">
                <h2 class="login_title">RainsGo</h2>
                <Form class="form" ref="formData" :model="formData" :rules="ruleData">
                    <Form-item prop="username">
                        <Input type="text" class="form_items" size="large" v-model="formData.username"
                               placeholder="Username Or Email Or Phone Number">
                        <i class="fa fa-user fa-size form_items_icon" slot="prepend"></i>
                        </Input>
                    </Form-item>

                    <Form-item prop="password">
                        <Input type="password" class="form_items" size="large" v-model="formData.password"
                               placeholder="Password">
                        <i class="fa fa-key fa-size form_items_icon" slot="prepend"></i>
                        </Input>
                    </Form-item>

                    <div class="forget">
                        <router-link to="/reset">
                            <Button type="text">忘记密码?</Button>
                        </router-link>
                    </div>
                    <Form-item>
                        <Button type="primary" size="large" class="form_items" @click="handleSubmit('formData')">登 录
                        </Button>
                    </Form-item>
                </Form>
            </div>
            <div class="login_bottom">
                新来的?
                <router-link to="/register">
                    <Button type="text">来注册,加入我们吧!</Button>
                </router-link>
            </div>
        </div>
    </div>
</template>

<style scoped lang="less">
    @rgbBackgroudContent: rgba(245, 245, 245, 0.7);
    @rgbBackgroudBottom: rgba(245, 245, 245, 0.8);

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
        background: @rgbBackgroudContent;
        box-shadow: 0px 0px 20px #666666;
        border-radius: 3px;
        margin-bottom: 40px;
    }

    #login_content {
        height: 100%;
        width: 100%;
        padding: 30px 20px 0px 20px;
    }

    .login_bottom {
        width: 100%;
        padding: 20px;
        text-align: center;
        background: @rgbBackgroudBottom;
        border-top: solid 1px #cccccc;
        border-radius: 0 0 3px 3px;
    }

    .login_title {
        width: 100%;
        text-align: center;
    }

    .form {
        margin: 50px 0;
    }

    .form_items {
        width: 100%;
    }

    .form_items_icon {
        width: 30px;
    }

    .fa-size {
        font-size: 18px;
    }

    .forget {
        text-align: right;
    }
</style>

<script type="text/ecmascript-6">
    export default {
        data() {
            const validateUsername = (rule, value, callback) => {
                if (value === '') {
                    return callback(new Error('登录名不能为空: [用户名] 或 [邮箱] 或 [手机号]'));
                } else if (value.toString().length < 4) {
                    callback(new Error('登录名至少4位'));
                } else {
                    callback();
                }
            };
            const validatePassword = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入密码'));
                } else if (value.toString().length < 6) {
                    callback(new Error('密码至少6位'));
                } else {
                    callback();
                }
            };
            return {
                formData: {
                    username: '',
                    password: ''
                },
                ruleData: {
                    username: [
                        {validator: validateUsername, trigger: 'blur'}
                    ],
                    password: [
                        {validator: validatePassword, trigger: 'blur'}
                    ]
                }
            }
        },
        methods: {
            handleSubmit(name) {
                console.log(this.$refs.abc.getBoundingClientRect().height);
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        this.$Message.success('提交成功!');
                    } else {
                        this.$Message.error('表单验证失败!');
                    }
                })
            }
        }
    }
</script>
