<template>
    <div id="reset" class="r-reset">
        <div id="reset_frame">
            <div id="reset_content">
                <h3 class="reset_title">重 置 密 码</h3>
                <Form class="form" ref="formData" :model="formData" :rules="ruleData">
                    <Form-item prop="emailOfPhone" label="请输入邮箱或者手机号,以接收验证码">
                        <Input type="text" class="form_items" size="large" v-model="formData.emailOfPhone"
                               placeholder="Email Or Phone Number">
                        <i class="fa fa-user fa-size form_items_icon" slot="prepend"></i>
                        <Button type="text" slot="append" :loading="sending" @click="toSend">
                            <span v-if="!sending && !sended">发送验证码</span>
                            <span v-else-if="sending && !sended">发送中</span>
                            <span v-else>验证码已发送</span>
                        </Button>
                        </Input>
                    </Form-item>

                    <Form-item prop="code">
                        <Input type="code" :disabled="!sended" class="form_items" size="large" v-model="formData.code"
                               placeholder="请输入验证码">
                        <i class="fa fa-commenting fa-size form_items_icon" slot="prepend"></i>
                        </Input>
                    </Form-item>

                    <Form-item>
                        <Button type="primary" :disabled="!sended" size="large" class="form_items" @click="handleSubmit('formData')">确认验证码
                        </Button>
                    </Form-item>
                </Form>
            </div>
            <div class="reset_bottom">
                想起来了?
                <router-link to="/login">
                    <Button type="text">那就去登录吧 -> GO</Button>
                </router-link>
            </div>
        </div>
    </div>
</template>

<style scoped lang="less">
    @rgbBackgroudContent: rgba(245, 245, 245, 0.7);
    @rgbBackgroudBottom: rgba(245, 245, 245, 0.8);

    .r-reset {
        height: 100%;
        width: 100%;
    }

    #reset_background {
        height: 100%;
        width: 100%;
        margin: -100px 0px 0px 0px;
        text-align: center;
        background-image: url(../../common/images/bg5.jpg);
        filter: blur(3px);
        position: absolute;
    }

    #reset_frame {
        position: absolute;
        width: 450px;
        margin-left: -225px;
        left: 50%;
        top: 100px;
        color: black;
        background: @rgbBackgroudContent;
        box-shadow: 0px 0px 20px #666666;
        border-radius: 3px;
        margin-bottom: 40px;
    }

    #reset_content {
        height: 100%;
        width: 100%;
        padding: 30px 20px 0px 20px;
    }

    .reset_bottom {
        width: 100%;
        padding: 20px;
        text-align: center;
        background: @rgbBackgroudBottom;
        border-top: solid 1px #cccccc;
        border-radius: 0 0 3px 3px;
    }

    .reset_title {
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
                    return callback(new Error('请填写邮箱或者手机号,以便接收验证码'));
                } else if (value.toString().length < 4) {
                    callback(new Error('至少4位'));
                } else {
                    callback();
                }
            };
            const validateCode = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入验证码'));
                } else if (value.toString().length != 6) {
                    callback(new Error('验证码是6位的'));
                } else {
                    callback();
                }
            };
            return {
                sending: false,
                sended: false,
                formData: {
                    emailOfPhone: '',
                    code: ''
                },
                ruleData: {
                    emailOfPhone: [
                        {validator: validateUsername, trigger: 'blur'}
                    ],
                    code: [
                        {validator: validateCode, trigger: 'blur'}
                    ]
                }
            }
        },
        methods: {
            handleSubmit(name) {
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        this.$Message.success('提交成功!');
                    } else {
                        this.$Message.error('表单验证失败!');
                    }
                })
            },
            toSend() {
                this.$Message.success('验证码已发送!');
            }
        }
    }
</script>
