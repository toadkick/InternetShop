<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.06.2018
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<jsp:include page="_menu.jsp"/>
<div class="standart">
<h1>User Info:</h1>
<table border = "2" >
<tr>
    <th>Login</th>
    <th>Email</th>
    <th>Phone</th>
</tr>
<c: var = "user" item = "${user}">
    <tr>
        <td>${user.login}</td>
        <td>${user.email}</td>
        <td>${user.phone}</td>
    </tr>
</c:>
</table>
</div>
<jsp:include page="_footer.jsp"/>

</body>
</html>
