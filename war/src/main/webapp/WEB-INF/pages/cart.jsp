<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.06.2018
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
<spring:url value="/decrease" var="decrease"/>
<spring:url value="/increase" var="increase"/>
<spring:url value="/removeFromCart" var="removeFromCart"/>
<spring:url value="/product" var="showProduct"/>
<spring:url value="/buy" var="buy"/>

<html>
<head>
    <title>CART</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<jsp:include page="_menu.jsp"/>
<div class="standart">
    <h1>CART</h1>
    <table border = "2" id="cartItems" class="cart">
        <tr>
            <th>Product</th>
            <th>Price</th>
            <th>-1</th>
            <th>Quantity</th>
            <th>+1</th>
            <th>Sum</th>
            <th>Remove</th>

        </tr>
    <c:forEach var = "list" items = "${list}">
        <tr>
            <td><a href="${showProduct}/${list.product_id}">${list.productName}</a></td>
            <td align="center">${list.price}</td>
            <td align="center"><a href="${decrease}/${list.product_id}"> <c:if test="${list.count > 1}">-</c:if> </a></td>
            <td align="center">${list.count}</td>
            <td align="center"><a href="${increase}/${list.product_id}"> + </a></td>
            <td align="center">${list.count * list.price}</td>
            <td align="center"><a href="${removeFromCart}/${list.product_id}"> x </a></td>

        </tr>
    </c:forEach>
    </table>
</div>
<div class="standart">
    <a>TOTAL: </a>
    <a id='total'></a>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/totalCalc.js">sum();</script>
</div>
<div class="standart">
<form method="get" action="${buy}">
<button type="submit" onclick="thanks()" >BUY!</button>
</form>
<script>function thanks() {
   alert("Thanks for oder");
}</script>
</div>
<jsp:include page="_footer.jsp"/>

</body>
</html>
