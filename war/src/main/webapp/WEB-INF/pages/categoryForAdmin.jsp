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


<spring:url value="/category" var="showCategory"/>
<spring:url value="/removeCategory" var="removeCategory"/>
<spring:url value="/editCategory" var="editCategory"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

<html>
<head>
</head>
<body>

<div class="standart">
    <h1>All Categories:</h1>

    <table border="2">
        <tr>
            <th>Category</th>
            <th>ID</th>
            <th>Remove</th>
            <th>Edit</th>
        </tr>
    <c:forEach var = "category" items = "${list}">
        <tr>
        <td><a href="${showCategory}/${category.categoryID}">${category.name}</a></td>
            <td><a>${category.categoryID}</a></td>
            <td><a href="${removeCategory}/${category.categoryID}">remove</a></td>
        <td><a href="${editCategory}/${category.categoryID}">Edit</a></td>
        </tr>
    </c:forEach>
    </table>
</div>
</body>
</html>
