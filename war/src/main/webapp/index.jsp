<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 17.06.2018
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

<html>
<head>
    <title>Welcome</title>
</head>
<body>
<jsp:include page="/WEB-INF/pages/_header.jsp"/>
<jsp:include page="/WEB-INF/pages/_menu.jsp"/>
<div class="standart">
<h1>WELCOME</h1>
<div>
<h4>If You are quest:</h4>
<ul>
    <li>Watch products</li>
    <li>Watch product's detail</li>
    <li>Watch categories</li>
    <li>Search by name</li>
    <li>Registration</li>
    <li>LogIn</li>
</ul>
</div>
<div>
    <h4>If You are logged as user:</h4>
    <ul>
        <li>All previous</li>
        <li>Watch your info</li>
        <li>Add/Remove products to Cart</li>
        <li>Buy the products</li>
        <li>Logout</li>
    </ul>
</div>
<div>
    <h4>If You are logged as admin:</h4>
    <ul>
        <li>All previous</li>
        <li>Create/Remove products</li>
        <li>Create/Remove categories</li>
    </ul>
</div>
</div>
<jsp:include page="/WEB-INF/pages/_footer.jsp"/>

</body>
</html>
