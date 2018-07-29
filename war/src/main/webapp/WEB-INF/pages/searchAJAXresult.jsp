<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Romashka
  Date: 29.07.2018
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<String> bd = new ArrayList<String>();
    bd.add("1");
    bd.add("2");
    bd.add("3");
    String name = request.getParameter("val");
    if (name == null || name.trim().equals("")) {
        out.print("<p>Please enter name</p>");
    } else {
        List<String> temp = new ArrayList<String>();
        for (String str:bd) {
            if (str.startsWith(name)) {
                temp.add(str);
            }
        }

        if (temp.isEmpty()) {
            out.print("<p>No records</p>");
        }else {
            out.print("<ol>");
            for (String str: temp) {
                out.print("<li>"+ str +"</li>");
            }
            out.print("</ol>");
        }
    }
%>
</body>
</html>
