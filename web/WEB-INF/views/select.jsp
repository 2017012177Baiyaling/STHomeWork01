<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="personDaoImpl" scope="page" class="com.dao.person.impl.PersonDaoImpl"/>
<jsp:useBean id="person" scope="page" class="com.entity.person.Person"/>
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
