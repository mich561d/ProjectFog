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
        <div class="container">
            <div class=row style="background-color: #0c2069">
                <div>
                    <img src="Assets/FOGLogo.jpg" alt="Umage betaler sig!" height="150" width="150"/>
                </div>
                <div class="col-lg-1">
                    <h1 style="color: white" font="Ariel" align:right>UMAGE BETALER SIG</h1>
                </div>
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
                <div style="background-color: #0c2069; position: absolute; bottom:0; width:100%;">
                    <p style="color: white" font="Ariel">JOHANNES FOG, CARPORT DESIGNER</p>    
                    <address style="color: white" font="Ariel"> JOHANNES FOG VÆRLØSE   
                    </address>    
                    <p style="color: white" font="Ariel">KONTAKT INFORMATION:   
                        <a href="JohannesFog@gmail.com">JohannesFog@gmail.com</a>.  
                    </p>  
                </div>
        </div>
    </body>
</html>

