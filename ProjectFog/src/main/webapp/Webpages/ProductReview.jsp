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
                                <h3>Mål:</h3>
                                <h6>Carport: <%= request.getSession().getAttribute("CarportLength")%>x<%= request.getSession().getAttribute("CarportWidth")%>x<%= request.getSession().getAttribute("CarportHeight")%>mm</h6>
                                <h6>Skur:</h6>
                                <h6>Gulv:</h6>
                                <h6>Tag: <%= request.getParameter("angledRoof")%></h6>
                                <h6>Tagmateriale:</h6>
                                <h6>Pris:</h6>
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
        </div>
    </body>
</html>
