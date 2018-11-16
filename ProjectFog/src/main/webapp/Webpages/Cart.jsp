<%-- 
    Document   : Cart
    Created on : 16-11-2018, 10:17:23
    Author     : Christian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="/WEB-INF/Imports/StyleImporter.jsp" %>
        <%
            double totalPrice = (double) request.getSession().getAttribute("ProductPrice");
            double price = totalPrice / 100 * 75;
            double tax = totalPrice - price;
        %>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
