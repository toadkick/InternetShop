<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10.06.2018
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/home">E-Shop</a>
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

            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <%--                  <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/addAdminCategory">Add category</a>
                                </li>

                              <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/addAdminProduct">Add product</a>
                                </li>

                                <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/editAdminCategory">Edit category</a>
                                </li>

                                <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/editAdminProduct">Edit product</a>
                                </li>--%>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/categoryManager">Category Manager</a>
                </li>
            </sec:authorize>

        </ul>
        <form:form name="searchForm" class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/search" method="get">
            <input name="searchVal" class="form-control mr-sm-2" placeholder="Search" type="text"/>
            <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
        </form:form>
        <span id="searchResults"></span>

    </div>
</nav>
