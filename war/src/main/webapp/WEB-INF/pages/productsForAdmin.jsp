<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.06.2018
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:url value="/product" var="showProduct"/>
<spring:url value="/removeProduct" var="removeProduct"/>
<spring:url value="/editProduct" var="editProduct"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

<html>
<head>
</head>
<body>

<div class="standart">
    <h1>All Products:</h1>

    <table border="2">
        <tr>
            <th>Product</th>
            <th>ID</th>
            <th>Category ID</th>
            <th>Author</th>
            <th>Price</th>
            <th>Count</th>
            <th>Date</th>
            <th>Image</th>
            <th>Remove</th>
            <th>Edit</th>
        </tr>
    <c:forEach var = "product" items = "${list}">
        <tr>
        <td><a href="${showProduct}/${product.productID}">${product.name}</a></td>
            <td><a>${product.productID}</a></td>
            <td><a>${product.categoryID}</a></td>
            <td><a>${product.author}</a></td>
            <td><a>${product.price}</a></td>
            <td><a>${product.count}</a></td>
            <td><a>${product.date}</a></td>
            <td><a>${product.imgSource}</a></td>
            <td><a href="${removeProduct}/${product.productID}">remove</a></td>
        <td><a href="${editProduct}/${product.productID}">Edit</a></td>
        </tr>
    </c:forEach>
    </table>
</div>
</body>
</html>
