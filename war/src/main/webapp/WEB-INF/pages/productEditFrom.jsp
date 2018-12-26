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
<div class="standart">
    <form:form method="post" modelAttribute="modprod" id="formprod">
        <a>Name:</a>
        <form:input path="name" maxlength="50" autocomplete="false" id="prodname"/>
        <a>Choose parent Id (0 is null):</a>
        <form:select path="parentID" items="${listId}"/>
        <a>Choose category Id (0 is null):</a>
        <form:select path="categoryID" items="${catList}"/>
        <a>Price:</a>
        <form:input path="price" maxlength="10" autocomplete="false" id="price"/>
        <a>Year:</a>
        <form:input path="date" maxlength="4" autocomplete="false" id="year"/>
        <a>Author:</a>
        <form:input path="author" maxlength="50" autocomplete="false" id="author"/>
        <a>Count:</a>
        <form:input path="count" maxlength="10" autocomplete="false" id="count"/>
        <a>Image:</a>
        <form:select path="imgSource">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
        </form:select>
        <input type="submit" onClick="return validProduct()" value="save" />
    </form:form>

    <script type="text/javascript">
        function validProduct() {
            var form = document.getElementById("formprod");
            var prodname = form["prodname"].value;
            prodname = prodname.replace(" ");
            if (prodname != null && prodname.length == 0 )
            {
                alert('Fill the name field');
                return false;}
            var price = form["price"].value;
            if (!(price instanceof Number) && price < 0)
            {
                alert('Fill the price correct');
                return false;}
            var year = form["year"].value;
            if (!(year instanceof Number) && year < 0)
            {
                alert('Fill the year field correct');
                return false;}
            var author = form["author"].value;
            author = author.replace(" ");
            if (author != null && author.length == 0 )
            {
                alert('Fill the author field');
                return false;}
            var count = form["count"].value;
            if (!(count instanceof Number) && count < 0)
            {
                alert('Fill the count field correct');
                return false;}
        }
    </script>

</div>
</body>
</html>
