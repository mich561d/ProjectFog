<%-- 
    Document   : ProductReview
    Created on : 15-11-2018, 13:38:47
    Author     : Michael & Christian
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produkt Opsumering</title>
        <%@include file="/WEB-INF/Imports/StyleImporter.jsp" %>
        <%
            double totalPrice = (double) request.getSession().getAttribute("ProductPrice");
            double price = totalPrice / 100 * 75;
            double tax = totalPrice - price;
            ArrayList<String> products = (ArrayList<String>) request.getSession().getAttribute("ProductList");
        %>
    </head>
    <body>
        <div class="container-fluid">        
            <div class="col-lg-6">
                <div class="card">
                    <form name="Product" action="FrontController" method="POST">
                        <div class="card-header">
                            <h3>Gennemgå din carport.</h3>
                        </div>
                        <div class="card-body">
                            <input type="hidden" name="command" value="Cart">
                            <table border="1" cellpadding='20' width='100%'>
                                <tr>
                                    <th width="50%" colspan="2" valign='top'>
                                        <label>
                                            <h3>Pris</h3>
                                            <label>
                                                <p>Pris: <%= price%></p>
                                            </label>
                                            <br>
                                            <label>
                                                <p>Moms: <%= tax%></p>
                                            </label>
                                            <br>
                                            <label>
                                                <p>Total: <%= totalPrice%></p>
                                            </label>
                                        </label>
                                    </th>
                                    <th width='50%' valign='top'>
                                        <label>
                                            <h3>Stykliste</h3>
                                            <label>
                                                <% for (int i = 0; i < products.size(); i++) {
                                                        String partOfProduct = products.get(i);
                                                        out.println(partOfProduct + "<br>");
                                                    }%>
                                            </label>
                                        </label>
                                    </th>
                                <div class="card-footer">
                                    <input type="submit" class="btn btn-secondary" name="back" value="Tilbage">
                                    <input type="submit" class="btn btn-primary" name="cart" value="Tilføg til kurv">
                                </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
