<%-- 
    Document   : error
    Created on : 16-11-2018, 12:40:04
    Author     : Michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello You!</h1>
        <h2>Look like you got yourself an error!</h2>
        <h3>Let's see what it says:</h3>
        <h4><%= request.getSession().getAttribute("error")%></h4>
        <h5>That's not good!</h5>
        <h6>We will try to fix this in the furture</h6>
    </body>
</html>