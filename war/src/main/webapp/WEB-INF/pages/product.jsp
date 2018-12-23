<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.06.2018
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<spring:url value="/addToCart" var="addProductToCart"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">


<html>
<head>
    <title>Product</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<jsp:include page="_menu.jsp"/>
<div class="standart">
<img src="${pageContext.request.contextPath}/resources/image/${product.imgSource}">
    <br/>
    <sec:authorize access="isAuthenticated()">
    <a href="${addProductToCart}/${product.productID}">Add to cart</a>
</sec:authorize>
<table border="2">
<tr>
        <th>ID</th>
        <th>Cat_ID</th>
        <th>Name</th>
        <th>Author</th>
        <th>Price</th>
        <th>Date</th>
    </tr>
    <c: var = "product" item = "${product}">
        <tr>
            <td>${product.productID}</td>
            <td>${product.categoryID}</td>
            <td>${product.name}</td>
            <td>${product.author}</td>
            <td>${product.price}</td>
            <td>${product.date}</td>
        </tr>
    </c:>
</table>
</div>
<jsp:include page="_footer.jsp"/>

</body>
</html>
