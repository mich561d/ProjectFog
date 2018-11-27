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
        <!--Stolper imellem hjørner, maks 300mm mellem hver. langsider-->
        <rect x="40" y="249.9" height="9.7" width="9.7" stroke="black" style="fill:white"/>
        <rect x="40" y="497.36" height="9.7" width="9.7" stroke="black" style="fill:white"/>
        <rect x="650.7" y="249.9" height="9.7" width="9.7" stroke="black" style="fill:white"/>
        <rect x="650.7" y="497.36" height="9.7" width="9.7" stroke="black" style="fill:white"/>
        <!--Stolper imellem hjørner, maks 300mm mellem hver. top-->
        <rect x="230.5" y="40" height="9.7" width="9.7" stroke="black" style="fill:white"/>
        <rect x="430." y="40" height="9.7" width="9.7" stroke="black" style="fill:white"/>
        <!--Remme-->
        <rect x="45" y="25" height="750" width="4.7" stroke="black" style="fill:white"/>
        <rect x="650" y="25" height="750" width="4.7" stroke="black" style="fill:white"/>
        <!--Endespær-->
        <rect x="25" y="45" height="4.7" width="650" stroke="black" style="fill:white"/>
        <rect x="25" y="750" height="4.7" width="650" stroke="black" style="fill:white"/>
        <!--Midter spær-->
        <rect x="25" y="114.6" height="4.7" width="650" stroke="black" style="fill:white"/>
        <rect x="25" y="184.2" height="4.7" width="650" stroke="black" style="fill:white"/>
        <rect x="25" y="253.8" height="4.7" width="650" stroke="black" style="fill:white"/>
        <rect x="25" y="323.4" height="4.7" width="650" stroke="black" style="fill:white"/>
        <rect x="25" y="393" height="4.7" width="650" stroke="black" style="fill:white"/>
        <rect x="25" y="462.6" height="4.7" width="650" stroke="black" style="fill:white"/>
        <rect x="25" y="532.2" height="4.7" width="650" stroke="black" style="fill:white"/>
        <rect x="25" y="601.8" height="4.7" width="650" stroke="black" style="fill:white"/>
        <rect x="25" y="671.4" height="4.7" width="650" stroke="black" style="fill:white"/>
        <!--Vandbrædder ender-->
        <rect x="25" y="23.1" height="1.9" width="650" stroke="black" style="fill:white"/>
        <rect x="25" y="775" height="1.9" width="650" stroke="black" style="fill:white"/>
        <!--Vandbrædder sider-->
        <rect x="23.1" y="23.1" height="753.8" width="1.9" stroke="black" style="fill:white"/>
        <rect x="675" y="23.1" height="753.8" width="1.9" stroke="black" style="fill:white"/>
        <!--Krydsmål linjer-->
        <line x1="25" y1="25" x2="675" Y2="775" stroke-dasharray="10, 10" style="stroke:rgb(255,0,0);stroke-width:2"/>
        <line x1="25" y1="775" x2="675" Y2="25" stroke-dasharray="10, 10" style="stroke:rgb(255,0,0);stroke-width:2"/>
        <!--pile-->
        <defs>
    <marker id="beginArrow" 
            markerWidth="9" markerHeight="9" 
            refX="0" refY="4" 
            orient="auto">
        <path d="M0,4 L8,0 L8,8 L0,4" style="fill: #000000s;" />
    </marker>
    <marker id="endArrow" 
            markerWidth="9" markerHeight="9" 
            refX="8" refY="4" 
            orient="auto">
        <path d="M0,0 L8,4 L0,8 L0,0" style="fill: #000000;" />
    </marker>
    </defs>
    <line x1="15"  y1="10" x2="675"   y2="10" 
          style="stroke: Red;
          marker-start: url(#beginArrow);
          marker-end: url(#endArrow);"/>
    <defs>
    <marker id="beginArrow" 
            markerWidth="9" markerHeight="9" 
            refX="0" refY="4" 
            orient="auto">
        <path d="M0,4 L8,0 L8,8 L0,4" style="fill: #000000s;" />
    </marker>
    <marker id="endArrow" 
            markerWidth="9" markerHeight="9" 
            refX="8" refY="4" 
            orient="auto">
        <path d="M0,0 L8,4 L0,8 L0,0" style="fill: #000000;" />
    </marker>
    </defs>
    <line x1="15"  y1="10" x2="15"   y2="775" 
          style="stroke: Red;
          marker-start: url(#beginArrow);
          marker-end: url(#endArrow);"/>
    <text x="295" y="25" fill="red">{650mm}</text>
    <text x="25" y="425" fill="red">{780mm}</text>
</body>
</html>
