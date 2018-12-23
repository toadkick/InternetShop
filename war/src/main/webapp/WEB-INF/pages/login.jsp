<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.06.2018
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib prefix="spring" uri="http://java.sun.com/jstl/core" %>
<spring:url var="loginURL" value="/j_spring_security_check"/>
<!DOCTYPE html>

<html>
<head><title>Login</title></head>
<body>
<jsp:include page="_header.jsp"/>
<jsp:include page="_menu.jsp"/>

<c:if test="${param.error == 'true'}">
    <div style="color:red;margin:10px 0px;">

        Login Failed!!!<br />
        Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

    </div>
</c:if>

<h3 align="center">Login with Username and Password</h3>

<form name='loginForm'
      action="<c:url value='/j_spring_security_check' />" method='POST'>

    <table align="center">
        <tr>
            <td>User:</td>
            <td><input type='text' name='username'></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit"
                                   value="Login" /></td>
        </tr>
    </table>
    <div align="center">
        <a href="${pageContext.request.contextPath}/register"> Or click here if you are not registered yet</a>
    </div>
    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}" />

</form>
</div>

<jsp:include page="_footer.jsp"/>

</body>
</html>