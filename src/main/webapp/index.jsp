<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sample - 登录</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="http://localhost:8080/css/global.css" rel="stylesheet">
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/jquery.cookie.js"></script>

</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-4">
            <form id="loginForm" class="form-horizontal">

                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <input type = "button" value ="登陆" id="login">
                        <input type = "button" value ="退出" id="logout">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>



<script>
    var Cookie = {
        TOKEN: 'cookie.token',
        LOGINNAME: 'cookie.username',
        THEME: 'cookie.theme',
        USERID: 'cookie.userId'
    };

    var RequestHeader = {
        TOKEN: 'Authorization',
    };
    $(function () {

        // 当遇到 401 状态码时，清空 cookie 中的 token，并跳转到登录页面
        $.ajaxSetup({
            statusCode: {
                401: function () {
                    $.removeCookie(Cookie.TOKEN);
                    location.href = 'index1.jsp';
                }
            }
        });


        // 当发送 ajax 请求开始时，将 cookie 中的 token 与 username 放入 request header 中
        $(document).ajaxSend(function (event, xhr) {
            xhr.setRequestHeader(RequestHeader.TOKEN, $.cookie(Cookie.TOKEN));
        });

        // 当点击退出时，清空 cookie 中的 token，并发送退出 ajax 请求，最后跳转到登录页面
        $('#logout').click(function () {
            if (confirm('确定退出系统吗？')) {
                $.removeCookie(Cookie.TOKEN);
                location.href = 'index1.jsp';
            }
            return false;
        });
    });
    $(function () {
        //登录
        $("#login").click(function (){
           /* $.get("http://123.56.205.77:9080/lehuohuo/rest/member/user/security/get/98de8e5cdb414044ad7ff8205a7a45d4",
                    function(data){
                        var code = "${code}";
                        console.log(code);
                        console.log(data.statusCode);
                        console.log(data.state);
                        console.log(data);
//                        location.href = "home.jsp";
//                        console.log(data["code"]);
////                        if (response.meta.success) {
////                            alert("code:" + data["code"] + "   message:" + data["messageDesc"]);
////                            console.log(data["code"], data["messageDesc"], data["vo"]);
////                        }else{
////                            console.log("error");
////                        }
                    },"json");*/



            $.post("http://localhost:8080/doLogin",
                    {
                        nameLogin:"admin@qq.com",
                        pwdLogin:"admin",
                    },function(data){
                            // 登录成功，将 token 与 username 放入 cookie 中
                            $.cookie(Cookie.TOKEN, data["vo"]["token"]);
                            $.cookie(Cookie.LOGINNAME, data["vo"]["loginName"]);
                            $.cookie(Cookie.USERID, data["vo"]["userId"]);
                            location.href = "home.jsp";
                    },"json");
        });
    });
</script>

</body>
</html>
