<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.06.2018
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<jsp:include page="_menu.jsp"/>
<div class="standart">
    <h1>Edit Product</h1>
    <jsp:include page="productEditFrom.jsp"/>
    <jsp:include page="productsForAdmin.jsp"/>
</div>
<jsp:include page="_footer.jsp"/>
</body>
</html>
