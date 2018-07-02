<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.06.2018
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="header-container" style="background-color: #343a40; text-align: right; color: #cccccc;">

    <div class="header-bar" style="margin-right: 3rem">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            Hello
            <a href="${pageContext.request.contextPath}/accountInfo">
                    ${pageContext.request.userPrincipal.name} </a>
            &nbsp;|&nbsp;
            <a href="${pageContext.request.contextPath}/j_spring_security_logout">Logout</a>
            &nbsp;|&nbsp;
            <a href="${pageContext.request.contextPath}/cart">Cart</a>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <a href="${pageContext.request.contextPath}/login">Login</a>
        </c:if>

    </div>

</div>
