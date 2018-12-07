<%-- 
    Document   : ProductReview
    Created on : 15-11-2018, 13:38:47
    Author     : Michael & Christian
--%>

<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Entities.Part"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produkt Opsumering</title>
        <%@include file="/WEB-INF/Imports/StyleImporter.jsp" %>
        <link href="Webpages/CSS/FogStyling.css" rel="stylesheet" type="text/css"/>
        <%
            DecimalFormat df = new DecimalFormat(".##");
            double totalPrice = (double) request.getSession().getAttribute("ProductPrice");
            double price = totalPrice / 100 * 75;
            double tax = totalPrice - price;
            String formattedPrice = df.format(price);
            String formattedTotalPrice = df.format(totalPrice);
            String formattedTax = df.format(tax);
            HashMap<String, ArrayList<Part>> products = (HashMap<String, ArrayList<Part>>) request.getSession().getAttribute("ProductList");
        %>
    </head>
    <body>
        <%@include file="/WEB-INF/Imports/NavBar.jsp" %>
        <br>
        <div class="container-fluid">   
            <div class="row justify-content-md-center">
                <div class="col-lg-8">
                    <form name="Product" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="Cart">
                        <div class="card border border-warning">
                            <div class="card-header border border-warning">
                                <h3>Dine valgte mål:</h3>
                            </div>
                            <div class="card-body border border-warning">
                                <div class="row">
                                    <div class="col-lg-8">
                                        <div class="container">
                                            <h3>Carport:</h3>
                                            <table class="table table-primary table-condensed table-striped">
                                                <thead>
                                                    <tr>
                                                        <th>Længde:</th>
                                                        <th>Bredde:</th>
                                                        <th>Højde:</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td><%= request.getSession().getAttribute("CarportLength")%> cm</td>
                                                        <td><%= request.getSession().getAttribute("CarportWidth")%> cm</td>
                                                        <td><%= request.getSession().getAttribute("CarportHeight")%> cm</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            <%if ((boolean) request.getSession().getAttribute("Shed")) {%>
                                            <h3>Skur:</h3>
                                            <table class="table table-primary table-condensed table-striped">
                                                <thead>
                                                    <tr>
                                                        <th>Længde:</th>
                                                        <th>Bredde:</th>
                                                            <%if (request.getSession().getAttribute("Floor") != null) {
                                                                    if ((boolean) request.getSession().getAttribute("Floor")) { %>
                                                        <th>Gulv:</th>
                                                            <%}
                                                                }%>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td><%=request.getSession().getAttribute("ShedLength")%> cm</td>
                                                        <td><%=request.getSession().getAttribute("ShedWidth")%> cm</td>
                                                        <%if (request.getSession().getAttribute("Floor") != null) {
                                                                if ((boolean) request.getSession().getAttribute("Floor")) {%>
                                                        <td>Gulv: <%= request.getSession().getAttribute("Floor")%></td>
                                                        <%}
                                                            }%>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            <%}%>
                                            <h3>Tag:</h3>
                                            <table class="table table-primary table-condensed table-striped">
                                                <thead>
                                                    <tr>
                                                        <th>Tag type:</th>
                                                            <%if (request.getParameter("angledRoof") != null) {%>
                                                        <th>Hældning i grader:</th>
                                                            <%}%>
                                                        <th>Materiale:</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <%if (request.getParameter("angledRoof") != null) {%>
                                                        <td>Tag med hældning</td>
                                                        <td><%= request.getSession().getAttribute("RoofAngle")%></td>
                                                        <td><%= request.getSession().getAttribute("Roofing")%></td>
                                                        <%} else {%>
                                                        <td>Fladt tag</td>
                                                        <td>Trapezplade</td>
                                                        <%}%>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 align-self-end">
                                        <div class="container">
                                            <h3>Pris:</h3>
                                            <table class="table table-primary table-condensed table-striped">
                                                <thead>
                                                    <tr>
                                                        <th>Ex. moms:</th>
                                                        <th>Moms:</th>
                                                        <th>Total:</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td><%=formattedPrice%>,-</td>
                                                        <td><%=formattedTax%>,-</td>
                                                        <td><%=formattedTotalPrice%>,-</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>        
                                </div>
                            </div>
                        </div>
                        <div class="card-footer border border-warning">
                            <div class="row">
                                <div class="col-lg-1 align-self-start">
                                    <input disabled="disabled" type="submit" class="btn btn-secondary" name="back" value="Tilbage">
                                </div>
                                <div class="col-lg-9"></div>
                                <div class="col-lg-1 align-self-end">
                                    <input type="submit" class="btn btn-primary" name="Cart" value="Tilføj til kurv">
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
