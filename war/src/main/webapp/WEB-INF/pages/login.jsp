<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.06.2018
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><title>Login</title></head>
<body>
<jsp:include page="_menu.jsp" />


<h1>Login</h1>

<!-- /login?error=true -->
<c:if test="${param.error == 'true'}">
    <div style="color:red;margin:10px 0px;">

        Login Failed!!!<br />
        Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

    </div>
</c:if>

<h3>Enter user name and password:</h3>
<a href="${pageContext.request.contextPath}/register">Register</a>

<form name='f' action="${pageContext.request.contextPath}/j_spring_security_check" method='POST'>
    <table>
        <tr>
            <td>User:</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
        </tr>
        <tr>
            <td><input name="submit" type="submit" value="submit" /></td>
        </tr>
    </table>
</form>
</body>
</html>