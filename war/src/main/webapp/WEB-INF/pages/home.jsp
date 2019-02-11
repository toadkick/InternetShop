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
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
<html>
<head>
    <title>E-shop</title>
</head>
<body>
 <jsp:include page="_header.jsp"/>
 <jsp:include page="_menu.jsp"/>
 <h1>These books for you!</h1>
 <jsp:include page="productList.jsp"/>
 <jsp:include page="_footer.jsp"/>
</body>
</html>
