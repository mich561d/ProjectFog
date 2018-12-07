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
            <h1>Hej med dig!</h1>
            <h2>Det ser ud til at du er løbet ind i en fejl.</h2>
            <h3>Lad os lige se hvad den siger:</h3>
            <h4><%= request.getSession().getAttribute("error")%></h4>
            <h5>Uhh!.. Det var ikke så godt.</h5>
            <h6>Vi vil gøre vores bedste for at rette dette i fremtiden!</h6>
        </div>
        <%@include file="/WEB-INF/Imports/Footer.jsp" %>
    </body>
</html>
