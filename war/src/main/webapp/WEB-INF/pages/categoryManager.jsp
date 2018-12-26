<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.06.2018
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<spring:url value="/category" var="showCategory"/>
<spring:url value="/removeCategory" var="removeCategory"/>
<spring:url value="/editCategory" var="editCategory"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .error {
            color: red;
        }
    </style>
</head>
<body>
<jsp:include page="_header.jsp"/>
<jsp:include page="_menu.jsp"/>
<div class="standart">

    <h1>Create New</h1>
    <form:form method="post" modelAttribute="modcategory" id="form">
        <a>Name:</a>
        <form:input path="name" maxlength="20" autocomplete="false" id="catname"/>
        <form:errors path="name" cssClass="error"/>
        <a>Choose parent Id (0 is null):</a>
        <form:select path="parentID" items="${listId}"/>
        <input type="submit" onClick="return validName()" value="create" />
    </form:form>

    <script type="text/javascript">
        function validName() {
            var form = document.getElementById("form");
            var catname = form["catname"].value;
            catname = catname.replace(" ");
            if (catname != null && catname.length == 0 )
            {
                alert('Fill the name field');
                return false;}
        }
    </script>

    <jsp:include page="categoryForAdmin.jsp"/>
</div>
<jsp:include page="_footer.jsp"/>
</body>
</html>
