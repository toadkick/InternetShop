<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.06.2018
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Add category</title>
</head>
<body>
<tr>
    <td>Name</td>
    <td><form:input path="name" /></td>
    <td><form:errors path="name" cssClass="error"/></td>
</tr>
</body>
</html>
