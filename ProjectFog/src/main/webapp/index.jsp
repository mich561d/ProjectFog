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
        <%@include file="/WEB-INF/Imports/NavBar.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-lg">
                    <div class="alert alert-info alert-dismissible fade show">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Info:</strong> Husk at logge ind før, at du går videre, for at springe udfyldningsformularen over.
                    </div>
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
                <div class="col-lg-4 border border-primary" style="background-color: #D1ECF1;">
                    <!-- Nav tabs -->
                    <ul class="nav nav-tabs">
                        <li class="nav-item">
                            <a class="nav-link active" data-toggle="tab" href="#home"><strong>Register</strong></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="tab" href="#menu1"><strong>Log ind</strong></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="tab" href="#menu2"><strong>Glemt password</strong></a>
                        </li>
                    </ul>
                    <!-- Tab panes -->
                    <br>
                    <div class="tab-content">
                        <div class="tab-pane container active" id="home">
                            <form name="Register" action="FrontController" method="POST">
                                <input type="hidden" name="command" value="Register">
                                <strong>Email:</strong>
                                <br>
                                <input type="email" name="email" placeholder="example@gmail.com" required>
                                <br>
                                <strong>Password:</strong>
                                <br>
                                <input type="password" name="password1" placeholder="password" required>
                                <input type="password" name="password2" placeholder="gentag password" required>
                                <br><br>
                                <input disabled="disabled" type="submit" name="register" value="Opret bruger">
                            </form>
                        </div>
                        <div class="tab-pane container fade" id="menu1">   
                            <form name="Login" action="FrontController" method="POST">
                                <input type="hidden" name="command" value="Login">
                                <strong>Email:</strong>
                                <br>
                                <input type="email" name="LoginEmail" placeholder="example@gmail.com" required>
                                <br>
                                <strong>Password:</strong>
                                <br>
                                <input type="password" name="loginPassword" placeholder="password" required>
                                <br><br><br>
                                <input disabled="disabled" type="submit" name="register" value="Log ind">
                            </form>
                        </div>
                        <div class="tab-pane container fade" id="menu2">
                            <form name="Login" action="FrontController" method="POST">
                                <input type="hidden" name="command" value="Login">
                                <strong>Email:</strong>
                                <br>
                                <input type="email" name="LoginEmail" placeholder="example@gmail.com" required>
                                <p><strong>*Der sendes et nyt autogenereret password til ovenstående email, som du har mulighed for at ændre, når du er logget ind.</strong></p>
                                <br>
                                <input disabled="disabled" type="submit" name="register" value="Nulstil password">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="/WEB-INF/Imports/Footer.jsp" %>
    </body>
</html>

