<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.entity.person.Person" %>
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/6/14
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="personDaoImpl" scope="page" class="com.dao.person.impl.PersonDaoImpl"/>
<jsp:useBean id="person" scope="page" class="com.entity.person.Person"/>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>模糊查询</title>
</head>
<body>
<div style="margin-top:150px;" align="center">
    <table border="1" >
        <tr bgcolor="#a9a9a9">
            <th>编号</th><th>姓名</th><th>年龄</th><th>性别</th><th colspan="2" align="center">操作</th>
        </tr>
        <c:forEach items="${list}"  var="person" varStatus="status">
            <tr>
                <td>${status.index+1}</td>
                <td>
                        ${person.name}
                </td>
                <td>
                        ${person.age}
                </td>
                <td>
                        ${person.sex}
                </td>
                <td>
                    <a href="/person?state=toUpdate&id=${person.id}">修改</a>
                </td>
                <td>
                    <a href="/person?state=del&id=${person.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="7" align="right"><a href="/person?state=toAdd">添加</a></td>
        </tr>
    </table>
</div>
</body>
</html>
