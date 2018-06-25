<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.06.2018
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<jsp:include page="_menu.jsp"/>

<table border = "2" >
    <tr>
        <th>ID</th>
        <th>Cat_ID</th>
        <th>Name</th>
        <th>Author</th>
        <th>Price</th>
        <th>Date</th>
        <th>Buy</th>


    </tr>
    <c: var = "product" item = "${product}">
        <tr>
            <td>${product.productID}</td>
            <td>${product.categoryID}</td>
            <td>${product.name}</td>
            <td>${product.author}</td>
            <td>${product.price}</td>
            <td>${product.date}</td>
            <td>Buy</td>


        </tr>
    </c:>
</table>

<jsp:include page="_footer.jsp"/>

</body>
</html>
