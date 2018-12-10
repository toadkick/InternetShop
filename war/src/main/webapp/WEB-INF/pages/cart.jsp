<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.06.2018
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<jsp:include page="_menu.jsp"/>
<h1>all categories</h1>
<table border = "2" >
    <tr>
        <th>Product</th>
        <th>Price</th>
        <th>Quantity</th>
    </tr>
    <c:forEach var = "list" items = "${list}">
        <tr>
            <td>${list.productName}</td>
            <td>${list.price}</td>
            <td>${list.count}</td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="_footer.jsp"/>

</body>
</html>
