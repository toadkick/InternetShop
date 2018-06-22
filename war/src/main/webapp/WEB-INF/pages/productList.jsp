<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.06.2018
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://java.sun.com/jstl/core" %>
<spring:url value="/product" var="showProduct"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<jsp:include page="_menu.jsp"/>

<h1>all products</h1>
<table border = "2" >
    <tr>
        <th>ID</th>
        <th>Cat_ID</th>
        <th>Name</th>
        <th>Author</th>
        <th>Price</th>
        <th>Date</th>
        <th>Info</th>

    </tr>
    <c:forEach var = "product" items = "${list}">
        <tr>
            <td>${product.productID}</td>
            <td>${product.categoryID}</td>
            <td>${product.name}</td>
            <td>${product.author}</td>
            <td>${product.price}</td>
            <td>${product.date}</td>
            <td><a href="${showProduct}/${product.productID}">INFO</a></td>>

        </tr>
    </c:forEach>
</table>

<jsp:include page="_footer.jsp"/>
</body>
</html>
