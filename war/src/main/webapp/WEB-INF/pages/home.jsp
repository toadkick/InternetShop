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
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<html>
<head>
    <title>E-shop</title>
</head>
<body>
 <jsp:include page="_header.jsp"/>
 <jsp:include page="_menu.jsp"/>
 <h1>These books for you!</h1>
 <div class="card-deck">

     <c:forEach var="product" items="${list}">
         <div class="col-sm-2 col-sm-offset-1" style="max-width: 20rem; min-width: 15rem;  padding: 1rem">
             <div class="wrapper">
                 <div class="card" style=" background-color: #cccccc">
                     <img class="card-img-top" src="${pageContext.request.contextPath}/resources/image/${product.imgSource}"
                          alt="Card image cap">
                     <div class="card-body">
                         <h5 class="card-title">${product.name}</h5>
                     </div>
                     <ul class="list-group list-group-flush">
                         <li class="list-group-item" style="background-color: darkgrey">AUTHOR - ${product.author}</li>
                         <li class="list-group-item" style="background-color: darkgrey">YEAR - ${product.date}</li>
                         <li class="list-group-item" style="background-color: darkgrey">PRICE - ${product.price}$</li>
                     </ul>
                     <div class="card-body">
                         <a href="${showProduct}/${product.productID}" class="card-link">INFO</a>
                         <sec:authorize access="isAuthenticated()">
                             <a href="#" class="card-link">Add to cart</a>
                         </sec:authorize>
                     </div>
                 </div>
             </div>
         </div>

     </c:forEach>

 </div>
 <jsp:include page="_footer.jsp"/>
</body>
</html>
