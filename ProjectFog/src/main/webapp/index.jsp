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
        <link href="Webpages/CSS/FogStyling.css" rel="stylesheet" type="text/css"/>
        <link href="Webpages/CSS/HoverEffect.css" rel="stylesheet" type="text/css"/>
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
            <div class="row no-gutters">
                <div class="col-lg-7 border border-primary">
                    <form name="Calculator" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="CustomCarport">
                        <div class="imageContainer">
                            <input class="indexImage" type="image" src="Assets/CarportBillede.png" alt="Lav din egen carport!"/>
                            <div class="centerText">
                                <div class="textContainer">
                                    <p>Tryk her for at lave din egen carport!</p>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-lg-1">
                    <!--This is a placeholder for whitespace! Since i cannot figure out how to do this properly... this is a quick fix!-->
                </div>
                <div class="col-lg-4 border border-primary">
                    Register --> Login --> Forgot Password
                </div>
            </div>
        </div>
        <!--TODO: Fix this!-->
        <br><br><br><br><br><br><br>
        <!--TODO: Fix this!-->
        <div class="container">
            <div class="row">
                <div class="col">
                    <div style="background-color: #0c2069; position: absolute; bottom:0; width:100%; left:0">
                        <p style="color: white" font="Ariel">JOHANNES FOG, CARPORT DESIGNER</p>    
                        <address style="color: white" font="Ariel"> JOHANNES FOG VÆRLØSE   
                        </address>    
                        <p style="color: white" font="Ariel">KONTAKT INFORMATION:   
                            <a href="JohannesFog@gmail.com">JohannesFog@gmail.com</a>.  
                        </p>  
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

