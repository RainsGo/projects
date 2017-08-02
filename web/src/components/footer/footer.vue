<template>
    <div id="footer" class="r-footer">
        <div id="footer_content">
            <span>© 2017 RainsGo All rights reserved.</span>

            <ul>
                <li>法律声明</li>
                <li>帮助</li>
                <li>反馈</li>
            </ul>
        </div>
        <!--
        <ul id="footer_text" data-width="959">
            <li><span>© 2017 Microsoft</span></li>
            <li> | <span>京ICP备10036305号</span></li>
            <li> | <span>京公网安备11010802022657号</span></li>
            <li> | <a id="sb_privacy" href="http://go.microsoft.com/fwlink/?LinkId=521839&amp;CLCID=804"
                      h="ID=SERP,5075.1">隐私声明和 Cookie</a></li>
            <li> | <a id="sb_legal" href="http://go.microsoft.com/fwlink/?LinkID=246338&amp;CLCID=804"
                      h="ID=SERP,5076.1">法律声明</a></li>
            <li> | <a id="sb_advertise" href="http://go.microsoft.com/?linkid=9844344" h="ID=SERP,5077.1">广告</a>
            </li>
            <li> | <a id="sb_report" href="http://go.microsoft.com/fwlink/?LinkID=275671&amp;clcid=0x04"
                      h="ID=SERP,5078.1">举报问题</a></li>
            <li> | <a id="sb_help" target="_blank"
                      href="http://go.microsoft.com/fwlink/?LinkID=617297&amp;clcid=0x04" h="ID=SERP,5079.1">帮助</a>
            </li>
            <li> | <a id="sb_feedback" href="#" h="ID=SERP,5080.1" class="feedback-binded">反馈</a></li>
        </ul>
        -->
    </div>
</template>

<style scoped lang="less">
    .r-footer {
        width: 100%;
        height: 50px;
        padding: 13px 0;
        background: rgba(0, 0, 0, 0.8);
    }

    #footer_content {
        height: 24px;
        line-height: 24px;
        padding: 0 20px;
        color: #777777;
        font-size: small;
    }

    #footer_content span {
        margin-right: 24px;
        margin-left: 48px;
        float: right;
    }

    #footer_content li {
        display: inline;
        -webkit-margin-before: 1em;
        -webkit-margin-after: 1em;
        -webkit-margin-start: 0px;
        -webkit-margin-end: 0px;
        -webkit-padding-end: 40px;
    }
</style>

<script type="text/ecmascript-6">
    export default {
        name: "footer"
    }
</script>
