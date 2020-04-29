<%--
  Created by IntelliJ IDEA.
  User: 芋头
  Date: 2018/6/2
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <title>修改页面</title>
</head>
<body>
<div style="margin-top:180px;" align="center">
<form action="/person?state=update&id=${person.id}" method="post">
    <table border="1">
        <tr>
            <td> 姓名 </td>
            <td>
                <input type="text" name="name" value="${person.name}"/>
            </td>
        </tr>
        <tr>
            <td> 年龄 </td>
            <td>
                <input type="text" name="age" value="${person.age}"/>
            </td>
        </tr>
        <tr>
            <td> 性别 </td>
            <td>
                <select name="sex">
                    <c:if test="${person.sex == '女'}">
                        <option  value="男" >男</option>
                        <option  value="女" selected="selected">女</option>
                    </c:if>

                    <c:if test="${person.sex == '男'}">
                        <option  value="男" selected="selected">男</option>
                        <option  value="女">女</option>
                    </c:if>
                </select>
            </td>
        </tr>
        <tr>
            <th align="center">
                <a href="/person?state=home"><input type="button" value="取消" ></a>
            </th>
            <th align="right">
                <input type="submit" name="submit" value="修改"/>
            </th>
        </tr>
    </table>
</form>
</div>
</body>
</html>
