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
    <title>Edit Category</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<jsp:include page="_menu.jsp"/>
<div class="standart">
<h1>Edit Category</h1>
<form:form method="post" modelAttribute="modcategory" id="editcatform">
    <a>Name:</a>
    <form:input path="name" maxlength="20" autocomplete="false" id="catname"/>
    <form:errors path="name" cssClass="error"/>
    <a>Choose parent Id (0 is null):</a>
    <form:select path="parentID" items="${listId}">
        <form:option value="${category.getParentId}"/>
    </form:select>
    <input type="submit" onClick="return validName()" value="edit" />
</form:form>
<script type="text/javascript">
    function validName() {
        var form = document.getElementById("editcatform");
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
