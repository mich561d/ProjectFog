<%-- 
    Document   : SVG
    Created on : 19-11-2018, 08:19:27
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
        <h1>Det Svenske Flag</h1>
        <SVG width="255" height=210 style="background-color: yellow">
        <rect x="0" y="0" height="90" width="90"
              style="stroke:#000000; fill: #0000FF"/>
        <rect x="120" y="0" height="90" width="135"
              style="stroke:#000000; fill: #0000FF"/>
        <rect x="0" y="120" height="90" width="90"
              style="stroke:#000000; fill: #0000FF"/>
        <rect x="120" y="120" height="90" width="135"
              style="stroke:#000000; fill: #0000FF"/>
        </SVG>
        <br>
        <h1>En Kasse med cirkler</h1>
        <SVG width="256" height=256>
        <rect x="0" y="0" height="100%" width="100%" stroke="black" style="fill: white"/>
        <circle cx="64" cy="64" r="64" stroke="black" style="fill: white"/>
        <circle cx="192" cy="64" r="64" stroke="black" style="fill: white"/>
        <circle cx="192" cy="192" r="64" stroke="black" style="fill: white"/>
        <circle cx="64" cy="192" r="64" stroke="black" style="fill: white"/>
        </SVG>
    </body>
</html>
