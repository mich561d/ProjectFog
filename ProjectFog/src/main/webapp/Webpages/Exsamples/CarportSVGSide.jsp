<%-- 
    Document   : CarportSVGSide
    Created on : 20-11-2018, 14:18:31
    Author     : ryger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <SVG height="450" width="800" >
        <rect x="0" y="0" height="100%" width="100%" stroke="black" style="fill: white"/>
        <!--Carport frontareal-->
        <rect x="25" y="100" height="200" width="750" stroke="black" style="fill: lightgrey"/>
        <!--Remme-->
        <rect x="25" y="90" height="20" width="750" stroke="black" style="fill:white"/>
        <!--Hjørne Stolper, mindst 90cm ned i jorden-->
        <rect x="40" y="100" height="300" width="9.7" stroke="black" style="fill:white"/>
        <rect x="750" y="100" height="300" width="9.7" stroke="black" style="fill:white"/>
        <!--Ende spær-->
        <rect x="45" y="70" height="20" width="4.7" stroke="black" style="fill:white"/>
        <rect x="750" y="70" height="20" width="4.7" stroke="black" style="fill:white"/>
        <!--Midter Stolper, mindst 90cm ned i jorden-->
        <rect x="278.35" y="100" height="300" width="9.7" stroke="black" style="fill:white"/>
        <rect x="521.58" y="100" height="300" width="9.7" stroke="black" style="fill:white"/>
        <!--Midter spær-->
        <rect x="111.04" y="70" height="20" width="4.7" stroke="black" style="fill:white"/>
        <rect x="179.43" y="70" height="20" width="4.7" stroke="black" style="fill:white"/>
        <rect x="243.12" y="70" height="20" width="4.7" stroke="black" style="fill:white"/>
        <rect x="306.81" y="70" height="20" width="4.7" stroke="black" style="fill:white"/>
        <rect x="370.5" y="70" height="20" width="4.7" stroke="black" style="fill:white"/>
        <rect x="434.19" y="70" height="20" width="4.7" stroke="black" style="fill:white"/>
        <rect x="497.88" y="70" height="20" width="4.7" stroke="black" style="fill:white"/>
        <rect x="561.57" y="70" height="20" width="4.7" stroke="black" style="fill:white"/>
        <rect x="625.26" y="70" height="20" width="4.7" stroke="black" style="fill:white"/>
        <rect x="688.95" y="70" height="20" width="4.7" stroke="black" style="fill:white"/>
        <!--vandbrædder sider-->
        <rect x="23.1" y="65" height="10" width="753.8" stroke="black" style="fill:white"/>
        <!--Krydsmål linjer-->
        <line x1="25" y1="110" x2="775" Y2="300" stroke-dasharray="10, 10" style="stroke:rgb(255,0,0);stroke-width:2"/>
        <line x1="775" y1="110" x2="25" Y2="300" stroke-dasharray="10, 10" style="stroke:rgb(255,0,0);stroke-width:2"/>
    </body>
</html>
