<%-- 
    Document   : plantegning
    Created on : 19-11-2018, 08:44:29
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
        <h1>Carport plantegning</h1>
        <h3>Del A.</h3>
        <SVG width="650" height="850">
        <rect x="0" y="0" height="100%" width="100%" stroke="black" style="fill: lightgrey"/>
        <rect x="25" y="25" height="40" width="40" stroke="black" style="fill:white"/>
        <rect x="25" y="780" height="40" width="40" stroke="black" style="fill:white"/>
        <rect x="25" y="275" height="40" width="40" stroke="black" style="fill:white"/>
        <rect x="25" y="575" height="40" width="40" stroke="black" style="fill:white"/>
        <rect x="305" y="25" height="40" width="40" stroke="black" style="fill:white"/>
        <rect x="580" y="25" height="40" width="40" stroke="black" style="fill:white"/>
        <rect x="580" y="275" height="40" width="40" stroke="black" style="fill:white"/>
        <rect x="580" y="575" height="40" width="40" stroke="black" style="fill:white"/>
        <rect x="580" y="780" height="40" width="40" stroke="black" style="fill:white"/>
        <rect x="45" y="1" height="848" width="20" stroke="black" style="fill:white"/>
        <rect x="580" y="1" height="848" width="20" stroke="black" style="fill:white"/>
        <rect x="1" y="45" height="20" width="648" stroke="black" style="fill:white"/>
        <rect x="1" y="780" height="20" width="648" stroke="black" style="fill:white"/>
        <line x1="0" y1="0" x2="650" Y2="850" stroke-dasharray="10, 10" style="stroke:rgb(255,0,0);stroke-width:2"/>
        <line x1="0" y1="850" x2="650" Y2="0" stroke-dasharray="10, 10" style="stroke:rgb(255,0,0);stroke-width:2"/>
        </SVG>
        <BR>
        <h3>Del B.</h3>
        <SVG width="650" height="850">
        <rect x="0" y="0" height="100%" width="100%" stroke="black" style="fill: lightgrey"/>
        <rect x="25" y="25" height="40" width="40" stroke="black" style="fill:white"/>
        <rect x="25" y="780" height="40" width="40" stroke="black" style="fill:white"/>
        <rect x="25" y="275" height="40" width="40" stroke="black" style="fill:white"/>
        <rect x="25" y="575" height="40" width="40" stroke="black" style="fill:white"/>
        <rect x="305" y="25" height="40" width="40" stroke="black" style="fill:white"/>
        <rect x="580" y="25" height="40" width="40" stroke="black" style="fill:white"/>
        <rect x="580" y="275" height="40" width="40" stroke="black" style="fill:white"/>
        <rect x="580" y="575" height="40" width="40" stroke="black" style="fill:white"/>
        <rect x="580" y="780" height="40" width="40" stroke="black" style="fill:white"/>
        <rect x="45" y="1" height="848" width="20" stroke="black" style="fill:white"/>
        <rect x="580" y="1" height="848" width="20" stroke="black" style="fill:white"/>
        <rect x="1" y="45" height="20" width="648" stroke="black" style="fill:white"/>
        <rect x="1" y="780" height="20" width="648" stroke="black" style="fill:white"/>
        <line x1="0" y1="0" x2="650" Y2="850" stroke-dasharray="10, 10" style="stroke:rgb(255,0,0);stroke-width:2"/>
        <line x1="0" y1="850" x2="650" Y2="0" stroke-dasharray="10, 10" style="stroke:rgb(255,0,0);stroke-width:2"/>
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
    <line x1="0"  y1="10" x2="650"   y2="10" 
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
    <line x1="10"  y1="0" x2="10"   y2="850" 
          style="stroke: Red;
          marker-start: url(#beginArrow);
          marker-end: url(#endArrow);"/>
    <text x="295" y="25" fill="red">{600mm}</text>
    <text x="25" y="425" fill="red">{780mm}</text>
    </SVG>
</body>
</html>
