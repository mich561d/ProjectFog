<%-- 
    Document   : CarportSVG
    Created on : 20-11-2018, 10:37:49
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
        <SVG height="800" width="700" >
        <rect x="0" y="0" height="100%" width="100%" stroke="black" style="fill: white"/>
        <!--Carport tag areal-->
        <rect x="25" y="25" height="750" width="650" stroke="black" style="fill: lightgrey"/>
        <!--Stolper i hjørnerne-->
        <rect x="40" y="40" height="9.7" width="9.7" stroke="black" style="fill:white"/>
        <rect x="650.7" y="40" height="9.7" width="9.7" stroke="black" style="fill:white"/>
        <rect x="40" y="750.3" height="9.7" width="9.7" stroke="black" style="fill:white"/>
        <rect x="650.7" y="750.3" height="9.7" width="9.7" stroke="black" style="fill:white"/>
        <!--Stolper imellem hjørner, maks 300mm mellem hver.-->
        
    </body>
</html>
