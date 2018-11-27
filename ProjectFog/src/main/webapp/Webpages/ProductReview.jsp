<%-- 
    Document   : ProductReview
    Created on : 15-11-2018, 13:38:47
    Author     : Michael & Christian
--%>

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
        <%
            DecimalFormat df = new DecimalFormat(".##");
            double totalPrice = (double) request.getSession().getAttribute("ProductPrice");
            double price = totalPrice / 100 * 75;
            double tax = totalPrice - price;
            String formattedTotalPrice = df.format(totalPrice);
            String formattedPrice = df.format(price);
            String formattedTax = df.format(tax);
            ArrayList<Part> products = (ArrayList<Part>) request.getSession().getAttribute("ProductList");
        %>
    </head>
    <body>
        <%@include file="/WEB-INF/Imports/NavBar.jsp" %>
        <div class="container-fluid">   
            <div class="row">
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
                                        <th width="35%" colspan="2" valign='top'>
                                            <label>
                                                <h3>Pris</h3>
                                                <label>
                                                    <p>Pris: <%= formattedPrice%></p>
                                                </label>
                                                <br>
                                                <label>
                                                    <p>Moms: <%= formattedTax%></p>
                                                </label>
                                                <br>
                                                <label>
                                                    <p>Total: <%= formattedTotalPrice%></p>
                                                </label>
                                            </label>
                                        </th>
                                        <th width='65%' valign='top'>
                                            <label>
                                                <h3>Stykliste</h3>
                                                <label>
                                                    <% for (int i = 0; i < products.size(); i++) {
                                                            Part part = products.get(i);
                                                            if (part == null) {
                                                                out.println(part + "<br>");
                                                            } else {
                                                                String line = part.getType() + " " + part.getMaterial() + " " + part.getSize();
                                                                out.println(line + "<br>");
                                                            }
                                                        }%>
                                                </label>
                                            </label>
                                        </th>
                                    </tr>
                                </table>
                            </div>
                            <div class="card-footer">
                                <input type="submit" class="btn btn-secondary" name="back" value="Tilbage">
                                <input type="submit" class="btn btn-primary" name="Cart" value="Tilføj til kurv">
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-lg-6">
                    <h3>Plantegninger af carport:</h3>
                    <h4>Oppe fra:</h4>
                    <%= request.getSession().getAttribute("DrawingAbove")%>
                    <h4>Fra siden:</h4>
                    <%= request.getSession().getAttribute("DrawingAside")%>
                    <h4>Forfra:</h4>
                    <%= request.getSession().getAttribute("DrawingFront")%>
                </div>
            </div>
        </div>
    </body>
</html>
