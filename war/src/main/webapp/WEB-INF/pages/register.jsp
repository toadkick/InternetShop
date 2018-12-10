<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.06.2018
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Registration</title>
    <style type="text/css">
        .error {
            color: red;
        }
    </style>
</head>
<body>

<jsp:include page="_header.jsp"/>
<jsp:include page="_menu.jsp"/>

<div align="center">
    <form:form action="register" method="post" modelAttribute="userForm">
        <table border="0">
            <tr>
                <td colspan="2" align="center"><h2>Registration</h2></td>
            </tr>
            <tr>
                <td>User Name:</td>
                <td><form:input path="login" /></td>
                <td><form:errors path="login" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><form:password path="password" /></td>
                <td><form:errors path="password" cssClass="error"/></td>

            </tr>
            <tr>
                <td>E-mail:</td>
                <td><form:input path="email" /></td>
                <td><form:errors path="email" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td><form:input path="phone" /></td>
                <td><form:errors path="phone" cssClass="error"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Register" /></td>
            </tr>
        </table>
    </form:form>
</div>

<jsp:include page="_footer.jsp"/>

</body>
</html>
