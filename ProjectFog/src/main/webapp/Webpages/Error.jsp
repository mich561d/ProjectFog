<%-- 
    Document   : error
    Created on : 16-11-2018, 12:40:04
    Author     : Michael & Christian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <%@include file="/WEB-INF/Imports/StyleImporter.jsp" %>
        <link href="Webpages/CSS/FogStyling.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="/WEB-INF/Imports/NavBar.jsp" %>
        <br>
        <div style="text-align: center">
            <h3>Det ser ud til at du er løbet ind i en fejl.</h3>
            <br>
            <h3><%= request.getSession().getAttribute("error")%></h3>
            <br>
            <h3>Du må rigtig gerne sende en besked til vores udvikler team.</h3>
            <h3>Så vi kan gøre vores bedste for at rette denne fejl i fremtiden!</h3>
            <h3>Mail: fog-developer@gmail.com</h3>
        </div>
        <%@include file="/WEB-INF/Imports/Footer.jsp" %>
    </body>
</html>
