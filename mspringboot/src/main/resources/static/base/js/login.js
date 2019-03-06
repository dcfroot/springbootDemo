var loginParams = {
    action: {login: "index/login"},//后台请求接口路径
    jsonAction:{login:"base/data/login/login.json"},//静态json的请求路径url
}
$(function () {
    layui.use(['form'], function() {
        var form = layui.form;
        form.render();

        /**
         * 登录
         * @param account
         * @param passWord
         */
        function login(account, passWord) {
            $.ajax({
                type: "GET", //发送请求的类型
                url: loginParams.jsonAction.login, //请求后台的接口路径
                data: {
                    "account": account,
                    "password": passWord
                }, //设置参数
                dataType: "json",//返回参数类型
                //ajax执行成功后的回调函数
                "success": function(result) {
                    //result为ajax所响应的数据
                    if(result.resultCode == 0) {
                        localStorage.setItem("userId", result.data.user_id);
                        localStorage.setItem("userName", result.data.name);
                        localStorage.setItem("headImg", result.data.head_img_url);
                        location.href = "views/index.html";
                    } else {
                        layer.msg(result.message, {
                            icon: 2, //图标
                            time: 1000, //时间
                            top: 300,
                            left: 500
                        });
                    }
                },
                "error": function() {
                    layer.msg("未知错误，请重新刷新页面", {
                        icon: 2, //图标
                        time: 1000, //时间
                        top: 300,
                        left: 500
                    });
                }

            });

        }

        /**
         *
         * 监听表单提交事件
         */
        form.on('submit(login)', function() {
            var account = $("#account").val();
            var passWord = $("#passWord").val();

            if(checkData()){
                login(account, passWord);
                if($("#remember").is(":checked")) {
                    localStorage.setItem("account", account);
                    localStorage.setItem("passWord", passWord)
                } else {
                    localStorage.setItem("account", "");
                    localStorage.setItem("passWord", "")
                }
            }
            return false;
        });

        /**
         * 验证提交
         * @returns {boolean}
         */
        function checkData() {
            var str = "";
            var user_account = $("#account").val();
            var user_password = $("#passWord").val();
            if (user_account == "") {//帐号为空
                str += "用户名不能为空\n";
            }
            if (user_password == "") {
                str += "密码不能为空\n";
            }
            if (str.length > 0) {//如果消息不为空，则说验证不通过
                alert(str);
                return false;
            }
            return true;
        }
        /**
         * 记住密码
         */
        function remembers() {
            if(localStorage.getItem("account") != "" && localStorage.getItem("passWord") != "") {
                $("#account").val(localStorage.getItem("account"));
                $("#passWord").val(localStorage.getItem("passWord"));
                $("#remember").prop("checked", true);

            }
            form.render();
        }
        //调用记住密码
        remembers();

        /**
         * 添加验证码
         */
        function addUnlock() {
            //定义一个英文字母的数组
            var engLish = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"];
            //定义一个字母下标数组
            var attr = [];

            //定义最终的验证码的值
            var code = "";
            //通过循环获取不重复值得字母下标数组
            for(var i = 0; i < 4; i++) {
                var ranNum = Math.ceil(Math.random() * 25);
                if(attr.indexOf(ranNum) == -1) {
                    attr.push(ranNum);
                } else {
                    i--;
                }
            }
            //通过下标数组将字母数组的字母取出并赋值给code
            for(var i = 0; i < 4; i++) {
                code += engLish[attr[i]];
            }

            $(".captcha_gbws_wrap").remove();
            $(".login").buttonCaptcha({
                codeWord: code, //匹配的验证码
                codeZone: code, //验证码正确摆法的提示
                captchaHeader: "请正确的将字符移动到框内", //提示信息
                captchaUnlocked: "通过验证" //通过验证
            });
            $(".captcha_gbws_wrap").appendTo("#verifyGroup");
        }
        //调用生成验证码的方法
        addUnlock();
    });

});




