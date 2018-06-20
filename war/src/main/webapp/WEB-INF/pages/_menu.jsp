<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10.06.2018
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div style="border: 1px solid #ccc;padding:5px;margin-bottom:20px;">

    <a href="${pageContext.request.contextPath}/home">Home</a>

    | &nbsp;

    <a href="${pageContext.request.contextPath}/category">Categories</a>

    | &nbsp;

    <a href="${pageContext.request.contextPath}/productList">Products</a>

    <c:if test="${pageContext.request.userPrincipal.name != null}">

        | &nbsp;
        <a href="${pageContext.request.contextPath}/logout">Logout</a>

    </c:if>

</div>
