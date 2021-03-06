<%-- 
    Document   : index
    Created on : 21-11-2018, 11:21:45
    Author     : Michael & Christian
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
        <% if (request.getSession().getAttribute("ErrorMsg") == null) { %>
        <% if (request.getSession().getAttribute("CustomerID") == null && request.getSession().getAttribute("EmployeeID") == null) { %>
        <div class="container">
            <div class="row">
                <div class="col-lg">
                    <div class="alert alert-info alert-dismissible fade show">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Info:</strong> Husk at logge ind før, at du går videre.
                    </div>
                </div>
            </div>
        </div>
        <%} %>
        <% } else {%>
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
        <% }
        request.getSession().setAttribute("ErrorMsg", null);%>
        <br>
        <div class="container">
            <div class="row no-gutters">
                <div class="col-lg-7 border border-primary" style="background-color: white;">
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
                    <% if (request.getSession().getAttribute("CustomerID") == null && request.getSession().getAttribute("EmployeeID") == null) { %>
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
                                <input type="email" class="form-control" name="email" placeholder="example@gmail.com" max="45" required>
                                <strong>Password:</strong>
                                <input type="password" class="form-control" name="password1" placeholder="password" min="8" max="45" required>
                                <input type="password" class="form-control" name="password2" placeholder="gentag password" min="8" max="45" required>
                                <button type="submit" class="btn btn-primary" style="margin-top: 10px; margin-bottom: 10px">Opret bruger</button>
                            </form>
                        </div>
                        <div class="tab-pane container fade" id="login">   
                            <form name="Login" action="FrontController" method="POST">
                                <input type="hidden" name="command" value="Login">
                                <strong>Email:</strong>
                                <input type="email" class="form-control" name="LoginEmail" placeholder="example@gmail.com" required>
                                <strong>Password:</strong>
                                <input type="password" class="form-control" name="LoginPassword" placeholder="password" required>
                                <button type="submit" class="btn btn-primary" style="margin-top: 10px; margin-bottom: 48px">Log ind</button>
                            </form>
                        </div>
                        <div class="tab-pane container fade" id="forgotPassword">
                            <form name="Login" action="FrontController" method="POST">
                                <input type="hidden" name="command" value="Login">
                                <strong>Email:</strong>
                                <br>
                                <input type="email" class="form-control" name="LoginEmail" placeholder="example@gmail.com" required>
                                <p style="margin-bottom: 14px"><strong>*Der sendes et nyt autogenereret password til ovenstående email, som du har mulighed for at ændre, når du er logget ind.</strong></p>
                                <button disabled type="submit" class="btn btn-primary" style="margin-bottom: 10px">Send nyt password</button>
                            </form>
                        </div>
                    </div>
                    <% } else {%>
                    <div style="padding: 5%; text-align: center">
                        <p><Strong>Hej <%=request.getSession().getAttribute("Name")%>!</Strong></p>
                        Du er allerede logget ind.<br>
                        Hvis du vil logge ud,<br>
                        skal du klikke på knappen.<br><br>
                        <form name="Register" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="Logout">
                            <button type="submit" class="btn btn-primary">Log ud</button>
                        </form>
                    </div>
                    <% }%>
                </div>
            </div>
        </div>
        <%@include file="/WEB-INF/Imports/Footer.jsp" %>
    </body>
</html>

