<%-- 
    Document   : Cart
    Created on : 16-11-2018, 10:17:23
    Author     : Christian & Michael
--%>

<%@page import="FunctionLayer.Entities.Part"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Betaling</title>
        <%@include file="/WEB-INF/Imports/StyleImporter.jsp" %>
        <link href="Webpages/CSS/FogStyling.css" rel="stylesheet" type="text/css"/>
        <%
            // Price
            DecimalFormat df = new DecimalFormat(".##");
            double totalPrice = (double) request.getSession().getAttribute("ProductPrice");
            double tax = totalPrice / 100 * 25;
            String formattedTotalPrice = df.format(totalPrice);
            String formattedTax = df.format(tax);
            // Product
            HashMap<String, ArrayList<Part>> products = (HashMap<String, ArrayList<Part>>) request.getSession().getAttribute("ProductList");
        %>
    </head>
    <body>
        <%@include file="/WEB-INF/Imports/NavBar.jsp" %>
        <br>
        <div class="container-fluid">   
            <div class="row justify-content-md-center">
                <div class="col-lg-10">
                    <form name="Product" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="PrintPDF">
                        <div class="card border border-warning">
                            <div class="card-header border border-warning">
                                <h3>Dine valgte mål:</h3>
                            </div>
                            <div class="card-body border border-warning">
                                <div class="row">
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
                                        <h3 style="text-align: right; padding-right: 15%">Pris</h3>
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
                                    <div>
                                        <p><strong>*For at se plantegninger rul lidt længere ned på siden.</strong></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card-footer border border-warning">
                            <div class="row">
                                <div class="col-lg-1 align-self-end">
                                    <input disabled type="submit" class="btn btn-primary" name="pdf" value="Print kvittering som PDF">
                                </div>
                            </div>
                            <p><strong>*I PDF-filen vil der også ligge plantegninger samt stykliste til den valgte carport</strong></p>
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
    </body>
</html>
