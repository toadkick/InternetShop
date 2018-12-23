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

<spring:url value="/category" var="showCategory"/>
<spring:url value="/removeCategory" var="removeCategory"/>
<spring:url value="/addUnderCategory" var="addUnderCategory"/>
<spring:url value="/editCategory" var="editCategory"/>


<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<jsp:include page="_menu.jsp"/>
<div class="standart">
<h1>all categories:</h1>

    <table border="2">
        <tr>
            <th>Category</th>
            <th>Remove</th>
            <th>Add under</th>
            <th>Edit</th>
        </tr>
        <tr>
            <td>TOP</td>
            <td></td>
            <td><input type="text" maxlength="20" minlength="1" name="0"><a href="${addUnderCategory}/${0}">Add under</a></td>
            <td></td>
        </tr>
    <c:forEach var = "category" items = "${list}">
        <tr>
        <td><h5><a href="${showCategory}/${category.categoryID}">${category.name}</a></h5></td>
        <td><a href="${removeCategory}/${category.categoryID}">remove</a></td>
        <td><a href="${addUnderCategory}/${category.categoryID}">Add under</a></td>
        <td><a href="${editCategory}/${category.categoryID}">Edit</a></td>
        </tr>
    </c:forEach>
    </table>
</div>
<jsp:include page="_footer.jsp"/>
</body>
</html>
