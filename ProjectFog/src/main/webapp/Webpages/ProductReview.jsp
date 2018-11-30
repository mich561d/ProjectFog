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
                    <div class="card">
                        <form name="Product" action="FrontController" method="POST">
                            <div class="card-header">
                                <h3>Gennemgå din carport</h3>
                            </div>
                            <div class="card-body">
                                <input type="hidden" name="command" value="Cart">
                                <label>
                                    <h3 style="text-align: center">Stykliste</h3>

                                    <div class="container">
                                        <table class="table table-condensed table-striped">
                                            <thead>
                                                <tr>
                                                    <th>Type</th>
                                                    <th>Størrelse</th>
                                                    <th>Detaljer</th>
                                                    <th>Antal</th>
                                                    <th>Stykpris</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%
                                                    Set set = products.keySet();
                                                    ArrayList<String> keys = new ArrayList<>();
                                                    keys.addAll(set);
                                                    for (int i = 0; i < keys.size(); i++) {
                                                        ArrayList<Part> parts = products.get(keys.get(i));
                                                        Part part = parts.get(0);
                                                %>
                                                <tr>
                                                    <td><%= part.getType()%></td>
                                                    <td><%= part.getSize()%></td>
                                                    <td><%= part.getDescription()%></td>
                                                    <td><%= parts.size()%></td>
                                                    <td><%= part.getPrice()%> kr.</td>
                                                </tr>
                                                <% }%>
                                            </tbody>
                                        </table>
                                    </div>
                                    <label style="width: 100%">
                                        <h3 style="text-align: center">Pris</h3>
                                        <div style="text-align: right; margin-right: 5%">
                                            <label>
                                                <p>Total: <%= formattedTotalPrice%> kr.</p>
                                            </label>
                                            <br>
                                            <label>
                                                <p>Heraf moms: <%= formattedTax%> kr.</p>
                                            </label>
                                        </div>
                                    </label>
                                </label>
                            </div>
                            <div class="card-footer">
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
            <br>
            <hr>
            <div style="text-align: center">  
                <h3>Plantegninger af carport:</h3>
                <table align="center" cellspacing="50px">
                    <tr>
                        <td rowspan="2">
                            <h4>Oppe fra:</h4>
                            <%= request.getSession().getAttribute("DrawingAbove")%>
                        </td>
                        <td>
                            <h4>Forfra:</h4>
                            <%= request.getSession().getAttribute("DrawingFront")%>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h4>Fra siden:</h4>
                            <%= request.getSession().getAttribute("DrawingAside")%>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
