<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.06.2018
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="products"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>all products</h1>
<table border = "2" >
    <tr><th>ID</th></tr>
    <products:forEach var = "product" items = "${list}">
        <tr>
            <td>${product.name}</td>

        </tr>
    </products:forEach>
</table>
</body>
</html>
