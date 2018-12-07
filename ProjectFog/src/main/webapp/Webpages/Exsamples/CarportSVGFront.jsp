<%-- 
    Document   : CarportSVGFront
    Created on : 20-11-2018, 12:47:28
    Author     : Christian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <SVG height="450" width="700" >
        <rect x="0" y="0" height="100%" width="100%" stroke="black" style="fill: white"/>
        <!--Carport frontareal-->
        <rect x="25" y="90" height="200" width="650" stroke="black" style="fill: lightgrey"/>
        <!--spær-->
        <rect x="25" y="70" height="20" width="650" stroke="black" style="fill:white"/>
        <!--Stolper mindst 90cm ned i jorden-->
        <rect x="40" y="100" height="300" width="9.7" stroke="black" style="fill:white"/>
        <rect x="650" y="100" height="300" width="9.7" stroke="black" style="fill:white"/>
        <!--Remme Front-->
        <rect x="25" y="90" height="20" width="650" stroke="black" style="fill:white"/>
        <!--Remme Sider-->
        <rect x="45" y="90" height="20" width="4.7" stroke="black" style="fill:white"/>
        <rect x="650" y="90" height="20" width="4.7" stroke="black" style="fill:white"/>
        <!--vandbrædder sider-->
        <rect x="23.1" y="65" height="10" width="1.9" stroke="black" style="fill:white"/>
        <rect x="675" y="65" height="10" width="1.9" stroke="black" style="fill:white"/>
        <!--vandbrædder front og bagende-->
        <rect x="25" y="65" height="10" width="650" stroke="black" style="fill:white"/>
        <!--Krydsmål linjer-->
        <line x1="25" y1="110" x2="677" Y2="290" stroke-dasharray="10, 10" style="stroke:rgb(255,0,0);stroke-width:2"/>
        <line x1="677" y1="110" x2="25" Y2="290" stroke-dasharray="10, 10" style="stroke:rgb(255,0,0);stroke-width:2"/>
    </body>
</html>
