<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10.06.2018
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

<%--
<div style="border: 1px solid #ccc;padding:5px;margin-bottom:20px;">

    <a href="${pageContext.request.contextPath}/home">Home</a>

    | &nbsp;

    <a href="${pageContext.request.contextPath}/category">Categories</a>

    | &nbsp;

    <a href="${pageContext.request.contextPath}/AllProductList">Products</a>

    <c:if test="${pageContext.request.userPrincipal.name != null}">

        | &nbsp;
        <a href="${pageContext.request.contextPath}/logout">Logout</a>

    </c:if>
</div>--%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/home">E-Shop</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation" style="">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarColor02">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/home">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/category">Categories</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/AllProductList">Products</a>
            </li>
            <li class="nav-item">
                <c:if test="${pageContext.request.userPrincipal.name != null}">

                    | &nbsp;
                    <a href="${pageContext.request.contextPath}/logout">Logout</a>

                </c:if>
            </li>>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" placeholder="Search" type="text">
            <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
