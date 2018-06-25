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
<spring:url value="/category" var="showCategory"/>
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
        <th>CategoryID</th>
        <th>CategoryName</th>
        <th>All product by this category</th>
    </tr>
    <c:forEach var = "category" items = "${list}">
        <tr>
            <td>${category.categoryID}</td>
            <td>${category.name}</td>
            <td><a href="${showCategory}/${category.categoryID}">Products in this category</a></td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="_footer.jsp"/>
</body>
</html>
