<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script src="${basePath}/js/base/login.js" type="text/javascript"></script>
</head>
<body>
    <form id="loginForm">
        <label>登录名</label> <input name="nameLogin" type="text" required/>
        <label>密码</label> <input name="pwdLogin" type="password" required/>
        <input type="button" value="登录" id="loginButton">
    </form>
</body>
</html>
