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
        <% if (request.getSession().getAttribute("UserID") == null) { %>
        <% if (request.getSession().getAttribute("ErrorMsg") == null) { %>
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
        <%} else {%>
        <div class="container">
            <div class="row">
                <div class="col-lg">
                    <div class="alert alert-danger alert-dismissible fade show">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Error:</strong> <%= request.getSession().getAttribute("ErrorMsg")%>
                    </div>
                </div>
            </div>
        </div>
        <% request.getSession().setAttribute("ErrorMsg", null);
                }
            }%>
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
                    <% if (request.getSession().getAttribute("UserID") == null) { %>
                    <!-- Nav tabs -->
                    <ul class="nav nav-tabs">
                        <li class="nav-item">
                            <a class="nav-link active" data-toggle="tab" href="#registration"><strong>Register</strong></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="tab" href="#login"><strong>Log ind</strong></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="tab" href="#forgotPassword"><strong>Glemt password</strong></a>
                        </li>
                    </ul>
                    <!-- Tab panes -->
                    <br>
                    <div class="tab-content">
                        <div class="tab-pane container active" id="registration">
                            <form name="Register" action="FrontController" method="POST">
                                <input type="hidden" name="command" value="Register">
                                <strong>Email:</strong>
                                <br>
                                <input type="email" name="email" placeholder="example@gmail.com" max="45" required>
                                <br>
                                <strong>Password:</strong>
                                <br>
                                <input type="password" name="password1" placeholder="password" min="8" max="45" required>
                                <input type="password" name="password2" placeholder="gentag password" min="8" max="45" required>
                                <br><br>
                                <input type="submit" name="register" value="Opret bruger">
                            </form>
                        </div>
                        <div class="tab-pane container fade" id="login">   
                            <form name="Login" action="FrontController" method="POST">
                                <input type="hidden" name="command" value="Login">
                                <strong>Email:</strong>
                                <br>
                                <input type="email" name="LoginEmail" placeholder="example@gmail.com" required>
                                <br>
                                <strong>Password:</strong>
                                <br>
                                <input type="password" name="LoginPassword" placeholder="password" required>
                                <br><br><br>
                                <input type="submit" name="register" value="Log ind">
                            </form>
                        </div>
                        <div class="tab-pane container fade" id="forgotPassword">
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
                    <% } else {%>
                    <div style="padding: 5%; text-align: center">
                        <p>Hej <%=request.getSession().getAttribute("CustomerName")%> !</p>
                        Du er allerede logget ind!<br>
                        Hvis du vil logge ud,<br>
                        skal du klikke på knappen!<br><br>
                        <form name="Register" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="Logout">
                            <input type="submit" name="register" value="Log ud">
                        </form>
                    </div>
                    <% }%>
                </div>
            </div>
        </div>
        <%@include file="/WEB-INF/Imports/Footer.jsp" %>
    </body>
</html>

