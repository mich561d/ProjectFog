<%-- 
    Document   : index
    Created on : 21-11-2018, 11:21:45
    Author     : Michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FOG</title>
        <%@include file="/WEB-INF/Imports/StyleImporter.jsp" %>
    </head>
    <body>
        <div style="background-color: #002699">
            <div>
                <img src="Assets/FOGLogo.jpg" alt="Umage betaler sig!" height="150" width="150"/>
            </div>
        </div>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-lg-9 border border-primary">
                    <h1>Her kommer indexsiden</h1>
                    <h2>Indtil videre kan de prøve vores carport beregner.</h2>
                    <p>Prøv vores nye carport system</p>
                    <form name="Calculator" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="CustomCarport">
                        <input type="submit" name="toCalc" value="Til systemet">
                    </form>
                </div>
                <div class="col-lg-3 border border-primary">
                    Login
                </div>
            </div>
        </div>
    </body>
</html>

