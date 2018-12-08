<%-- 
    Document   : CustomerPage
    Created on : 04-12-2018, 16:59:57
    Author     : Michael & Christian
--%>

<%@page import="FunctionLayer.Entities.User"%>
<%@page import="FunctionLayer.Entities.PaymentInformation"%>
<%@page import="FunctionLayer.Entities.Address"%>
<%@page import="FunctionLayer.Entities.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Min side</title>
        <%@include file="/WEB-INF/Imports/StyleImporter.jsp" %>
        <link href="Webpages/CSS/FogStyling.css" rel="stylesheet" type="text/css"/>
        <%
            Customer customer = (Customer) request.getSession().getAttribute("Customer");
            Address address = (Address) request.getSession().getAttribute("Address");
            PaymentInformation payment = (PaymentInformation) request.getSession().getAttribute("Payment");
            User user = (User) request.getSession().getAttribute("User");
        %>
    </head>
    <body>
        <%@include file="/WEB-INF/Imports/NavBar.jsp" %>
        <%  if (request.getSession().getAttribute("Updated") != null) {
                if ((boolean) request.getSession().getAttribute("Updated")) { %>
        <div class="container">
            <div class="row">
                <div class="col-lg">
                    <div class="alert alert-info alert-dismissible fade show">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Info:</strong> Dine oplysninger er blevet ændret!
                    </div>
                </div>
            </div>
        </div>
        <% request.getSession().setAttribute("Updated", null);
                }
            }%>
        <br>
        <div class="container-fluid">   
            <div class="row justify-content-md-center">
                <div class="col-lg-5">
                    <div class="card border border-warning">
                        <div class="card-header border border-warning">
                            <h3>Dine informationer</h3>
                        </div>
                        <div class="card-body border border-warning">
                            <label>
                                <div class="container">
                                    <h3>Person oplysninger:</h3>
                                    <table class="table table-primary table-condensed table-striped">
                                        <thead>
                                            <tr>
                                                <th>Fornavn</th>
                                                <th>Efternavn</th>
                                                <th>Tlf.</th>
                                                <th>Email</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td><%=customer.getFirstName()%></td>
                                                <td><%=customer.getLastName()%></td>
                                                <td><%=customer.getPhone()%></td>
                                                <td><%=user.getEmail()%></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <h3>Adresse oplysninger:</h3>
                                    <table class="table table-primary table-condensed table-striped">
                                        <thead>
                                            <tr>
                                                <th>By</th>
                                                <th>Postnummer</th>
                                                <th>Vej</th>
                                                <th>Nummer</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td><%=address.getCity()%></td>
                                                <td><%=address.getZip()%></td>
                                                <td><%=address.getStreet()%></td>
                                                <td><%=address.getNumber()%></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <h3>Kort oplysninger:</h3>
                                    <table class="table table-primary table-condensed table-striped">
                                        <thead>
                                            <tr>
                                                <th>Kort nummer</th>
                                                <th>udløbsdato</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td><%=payment.getCardNumber()%></td>
                                                <td><%=payment.getExpireDate()%></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="col-lg-5">
                    <div class="card border border-warning">
                        <div class="card-header border border-warning">
                            <h3>Ændre informationer</h3>
                        </div>
                        <div class="card-body border border-warning">
                            <label>
                                <div class="container">
                                    <h3>Nye oplysninger:</h3>
                                    <form name="CustomerInformationChange" action="FrontController" method="POST">
                                        <input type="hidden" name="command" value="UpdateCustomerInformation">
                                        <input type="String" class="form-control" name="changeFirstName" placeholder="Fornavn">
                                        <input type="String" class="form-control" name="changeLastName" placeholder="Efternavn">
                                        <input type="String" class="form-control" name="changePhone" placeholder="Telefon nummer">
                                        <input type="String" class="form-control" name="changeCity" placeholder="By">
                                        <input type="String" class="form-control" name="changeZip" placeholder="Postnummer">
                                        <input type="String" class="form-control" name="changeStreet" placeholder="Vej">
                                        <input type="String" class="form-control" name="changeNumber" placeholder="Nummer">
                                        <input type="String" class="form-control" name="changeCardNumber" placeholder="Kort nummer">
                                        <input type="String" class="form-control" name="changeExpireDate" placeholder="Kort udløbsdato">
                                        <br><br>
                                        <div class="row">
                                            <div class="col-lg-1 align-self-end">
                                                <input type="submit" class="btn btn-primary" name="next" value="Gem ændringer">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <div class="row justify-content-md-center">
                <div class="col-lg-5">
                    <div class="card border border-warning">
                        <div class="card-header border border-warning">
                            <h3>Ændre Email</h3>
                        </div>
                        <div class="card-body border border-warning">
                            <label>
                                <div class="container">
                                    <h3>Indtast ny email:</h3>
                                    <form name="CustomerEmailChange" action="FrontController" method="POST">
                                        <input type="hidden" name="command" value="UpdateCustomerEmail">
                                        <input type="email" class="form-control" name="changeEmail" placeholder="Indtast ny email">
                                        <p><strong>*Der vil blive sendt et nyt aktiverings link til den nye mail!</strong></p>
                                        <br>
                                        <div class="row">
                                            <div class="col-lg-1 align-self-end">
                                                <input type="submit" class="btn btn-primary" name="next" value="Gem ændringer">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="col-lg-5">
                    <div class="card border border-warning">
                        <div class="card-header border border-warning">
                            <h3>Ændre password</h3>
                        </div>
                        <div class="card-body border border-warning">
                            <label>
                                <div class="container">
                                    <h3>Lav et nyt password:</h3>
                                    <form name="CustomerPasswordChange" action="FrontController" method="POST">
                                        <input type="hidden" name="command" value="UpdateCustomerPassword">
                                        <input type="password" class="form-control" name="changePass1" placeholder="Password">
                                        <input type="password" class="form-control" name="changePass2" placeholder="Password">
                                        <br>
                                        <div class="row">
                                            <div class="col-lg-1 align-self-end">
                                                <input type="submit" class="btn btn-primary" name="next" value="Gem ændringer">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
