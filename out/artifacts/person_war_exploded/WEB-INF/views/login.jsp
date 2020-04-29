<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/6/1
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<div style="margin-top:180px;" align="center">
    <form action="${pageContext.request.contextPath}/user?state=login" method="post">
        <table>
            <tr><td>用户名</td><td><input type="text" name="username"></td></tr>
            <tr><td>密码</td><td><input type="password" name="password"></td></tr>
        </table>
        <p><h3>${msg}</h3></p>
        <button>登录</button><a href="/user?state=toRegister">注册</a>
    </form>
</div>
</body>
</html>
