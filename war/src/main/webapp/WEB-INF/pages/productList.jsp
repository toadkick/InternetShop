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

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
      integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<html>
<head>
    <title>Product list</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<jsp:include page="_menu.jsp"/>

<div class="card-deck-wrapper">
    <div class="card-columns">

        <c:forEach var="product" items="${list}">

            <div class="card" style="padding: 20px; background-color: #cccccc">
                <img class="card-img-top" src="resources/image/book.gif" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title">${product.name}</h5>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"  style="background-color: darkgrey">AUTHOR - ${product.author}</li>
                    <li class="list-group-item"  style="background-color: darkgrey">YEAR - ${product.date}</li>
                    <li class="list-group-item"  style="background-color: darkgrey">PRICE - ${product.price}$</li>
                </ul>
                <div class="card-body">
                    <a href="${showProduct}/${product.productID}" class="card-link">INFO</a>
                    <a href="#" class="card-link">Add to cart</a>
                </div>
            </div>

        </c:forEach>

    </div>
</div>

<jsp:include page="_footer.jsp"/>
</body>
</html>
