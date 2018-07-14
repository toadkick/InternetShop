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


<h1>Login</h1>

<!-- /login?error=true -->
<c:if test="${param.error == 'true'}">
    <div style="color:red;margin:10px 0px;">

        Login Failed!!!<br />
        Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

    </div>
</c:if>

<h3>Login with Username and Password</h3>

<sec:authorize access="isAnonymous()">
    <form action="${loginURL}" method="post">
        <table>
            <tr>
                <td>User:</td>
                <td><input type='text' name='j_username'></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='j_password'/></td>
            </tr>
            <tr>
                <td><input name="submit" type="submit" value="Login"/>
                    | &nbsp;
                    <a href="${pageContext.request.contextPath}/register">Register</a>
                </td>
            </tr>
        </table>
    </form>
</sec:authorize>


<jsp:include page="_footer.jsp"/>

</body>
</html>