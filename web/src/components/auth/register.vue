<template>
    <div id="register" class="r-register">
        <div id="register_frame">
            <div id="register_content">
                <h2 class="register_title">RainsGo</h2>
                <Form class="form" ref="formData" :model="formData" :rules="ruleData">
                    <Form-item prop="username">
                        <Input type="text" class="form_items" size="large" v-model="formData.username"
                               placeholder="Username">
                        <i class="fa fa-user fa-size form_items_icon" slot="prepend"></i>
                        </Input>
                    </Form-item>

                    <Form-item prop="password">
                        <Input type="password" class="form_items" size="large" v-model="formData.password"
                               placeholder="Password">
                        <i class="fa fa-key fa-size form_items_icon" slot="prepend"></i>
                        </Input>
                    </Form-item>

                    <Form-item prop="password2">
                        <Input type="password" class="form_items" size="large" v-model="formData.password2"
                               placeholder="Password Confirm">
                        <i class="fa fa-key fa-size form_items_icon" slot="prepend"></i>
                        </Input>
                    </Form-item>

                    <Form-item prop="email">
                        <Input type="text" class="form_items" size="large" v-model="formData.email" placeholder="Email">
                        <i class="fa fa-envelope fa-size form_items_icon" slot="prepend"></i>
                        </Input>
                    </Form-item>

                    <Form-item prop="phone">
                        <Input type="text" class="form_items" size="large" v-model="formData.phone"
                               placeholder="Phone Number" number>
                        <i class="fa fa-phone fa-size form_items_icon" slot="prepend"></i>
                        </Input>
                    </Form-item>

                    <Form-item>
                        <Button type="primary" size="large" class="form_items" @click="handleSubmit('formData')">注 册
                        </Button>
                    </Form-item>
                </Form>
            </div>
            <div class="register_bottom">
                是RainsGo一员了?
                <router-link to="/login">
                    <Button type="text">那就来登录吧!</Button>
                </router-link>
            </div>
        </div>
    </div>
</template>

<style scoped lang="less">
    @rgbBackgroudContent: rgba(245, 245, 245, 0.7);
    @rgbBackgroudBottom: rgba(245, 245, 245, 0.8);

    .r-register {
        height: 100%;
        width: 100%;
    }

    #register_background {
        height: 100%;
        width: 100%;
        margin: -100px 0px 0px 0px;
        text-align: center;
        background-image: url(../../common/images/bg5.jpg);
        filter: blur(3px);
        position: absolute;
    }

    #register_frame {
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

    #register_content {
        height: 100%;
        width: 100%;
        padding: 30px 20px 0px 20px;
    }

    .register_bottom {
        width: 100%;
        padding: 20px;
        text-align: center;
        background: @rgbBackgroudBottom;
        border-top: solid 1px #cccccc;
        border-radius: 0 0 3px 3px;
    }

    .register_title {
        width: 100%;
        text-align: center;
    }

    .form {
        margin: 20px 0;
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
</style>

<script type="text/ecmascript-6">
    export default {
        data() {
            const validateUsername = (rule, value, callback) => {
                if (value === '') {
                    return callback(new Error('用户名不能为空'));
                } else if(value.toString().length < 4) {
                    callback(new Error('用户名至少4位'));
                } else {
                    callback();
                }
            };
            const validatePassword = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入密码'));
                } else if(value.toString().length < 6) {
                    callback(new Error('密码至少6位'));
                } else {
                    if (this.formData.password2 !== '') {
                        // 对第二个密码框单独验证
                        this.$refs.formData.validateField('password2');
                    }
                    callback();
                }
            };
            const validatePassword2 = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请再次输入密码'));
                } else if (value !== this.formData.password) {
                    callback(new Error('两次输入密码不一致!'));
                } else {
                    callback();
                }
            };
            const validatePhone = (rule, value, callback) => {
                if (value === '') {
                    return callback(new Error('手机号不能为空'));
                } else if (!Number.isInteger(value)) {
                    callback(new Error('请输入正确手机号'));
                } else if (value.toString().length != 11) {
                    callback(new Error('请输入正确手机号'));
                } else {
                    callback();
                }
            };
            return {
                formData: {
                    username: '',
                    password: '',
                    password2: '',
                    email: '',
                    phone: ''
                },
                ruleData: {
                    username: [
                        {validator: validateUsername, trigger: 'blur'}
                    ],
                    password: [
                        {validator: validatePassword, trigger: 'blur'}
                    ],
                    password2: [
                        {validator: validatePassword2, trigger: 'blur'}
                    ],
                    email: [
                        {required: true, message: '邮箱不能为空', trigger: 'blur'},
                        {type: 'email', message: '邮箱格式不正确', trigger: 'blur'}
                    ],
                    phone: [
                        {validator: validatePhone, trigger: 'blur'}
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
            }
        }
    }
</script>
