<%-- 
    Document   : UserCreationSchema
    Created on : 04-12-2018, 11:19:41
    Author     : Michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Oprettelses skema</title>
        <%@include file="/WEB-INF/Imports/StyleImporter.jsp" %>
        <link href="Webpages/CSS/FogStyling.css" rel="stylesheet" type="text/css"/>
        <% String password = request.getSession().getAttribute("RegisterPassword").toString();
            char c = '*';
            String convertedPass = "";
            for (int i = 0; i < password.length(); i++) {
                convertedPass += c;
            }
        %>
    </head>
    <body>
        <%@include file="/WEB-INF/Imports/NavBar.jsp" %>
        <br>
        <div class="container-fluid">        
            <div class="col-lg-8" style="margin: auto;">
                <div class="card">
                    <form name="CustomerCreation" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="CreateCustomer">
                        <input type="hidden" name="email" value="<%=request.getSession().getAttribute("RegisterEmail")%>">
                        <input type="hidden" name="password" value="<%=password%>">
                        <div class="card-header">
                            <h3>Udfyld skemaet for at oprette dig i systemet</h3>
                            <p><strong>*Udfyld skemaet som vist ved hjælp at 'pladsholderende'</strong></p>
                        </div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <label>
                                        <h3>Person informationer:</h3>
                                        <label>
                                            <p>Fornavn:</p>
                                            <input type="text" class="form-control" name="firstName" placeholder="Johannes" required>
                                        </label>
                                        <br>
                                        <label>
                                            <p>Efternavn:</p>
                                            <input type="text" class="form-control" name="lastName" placeholder="Fog" required>
                                        </label>
                                        <br>
                                        <label>
                                            <p>Mobil nummer:</p>
                                            <input type="text" class="form-control" name="phone" placeholder="45 87 10 01" required>
                                        </label>
                                    </label>
                                </div>
                                <div class="col-lg-6">
                                    <label>
                                        <h3>Login Oplysninger:</h3>
                                        <label>
                                            <p>Email:</p>
                                            <input type="email" class="form-control" name="email" placeholder="<%=request.getSession().getAttribute("RegisterEmail")%>" readonly>
                                        </label>
                                        <br>
                                        <label>
                                            <p>Password:</p>
                                            <input type="password" class="form-control" name="password" placeholder="<%=convertedPass%>" readonly>
                                        </label>
                                    </label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <label>
                                        <h3>Adresse:</h3>
                                        <label>
                                            <p>By:</p>
                                            <input type="text" class="form-control" name="city" placeholder="Kongens Lyngby" required>
                                        </label>
                                        <br>
                                        <label>
                                            <p>Postnummer:</p>
                                            <input type="text" class="form-control" name="zip" placeholder="2800" required>
                                        </label>
                                        <br>
                                        <label>
                                            <p>Vej:</p>
                                            <input type="text" class="form-control" name="street" placeholder="Firskovvej" required>
                                        </label>
                                        <br>
                                        <label>
                                            <p>Nummer:</p>
                                            <input type="text" class="form-control" name="number" placeholder="20" required>
                                        </label>
                                    </label>
                                </div>
                                <div class="col-lg-6">
                                    <label>
                                        <h3>Kort Oplysninger:</h3>
                                        <label>
                                            <p>Kortnummer:</p>
                                            <input type="text" class="form-control" name="cardNumber" placeholder="4830 9657 2189 9352" required>
                                        </label>
                                        <br>
                                        <label>
                                            <p>Udløbsdato:</p>
                                            <input type="text" class="form-control" name="cardExpireDate" placeholder="01/19" required>
                                        </label>
                                    </label>
                                </div>
                            </div>
                        </div>
                        </table>
                        <div class="card-footer">
                            <div class="row">
                                <div class="col-lg-1 align-self-start">
                                    <input disabled="disabled" type="submit" class="btn btn-secondary" name="back" value="Afbryd registrationen">
                                </div>
                                <div class='col-lg-9'></div>
                                <div class="col-lg-1 align-self-end">
                                    <input type="submit" class="btn btn-primary" name="create" value="Opret bruger">
                                </div>
                            </div>
                        </div>
                </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
