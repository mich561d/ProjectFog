<%-- 
    Document   : Cart
    Created on : 16-11-2018, 10:17:23
    Author     : Christian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Indkøbskurv</title>
        <%@include file="/WEB-INF/Imports/StyleImporter.jsp" %>
        <%
            double totalPrice = (double) request.getSession().getAttribute("ProductPrice");
            double price = totalPrice / 100 * 75;
            double tax = totalPrice - price;
        %>
    </head>
    <body>
        <div class="container-fluid">        
            <div class="col-lg-6">
                <div class="card">
                    <form name="Product" action="FrontController" method="POST">
                        <div class="card-header">
                            <div class="card-header">
                                <h3>Indkøbskurv.</h3>
                            </div>
                            <div class="card-body">
                                <input type="hidden" name="command" value="Cart">
                                <table border="1" cellpadding='20' width='100%'>
                                    <tr>
                                        <th width="100%" colspan="2" valign='top'>
                                            <label>
                                                <th>
                                                <label>
                                                    <p>Pris: <%= totalPrice%></p>
                                                </label>
                                                </th>
                                                <th>
                                                <label>
                                                    <p>Moms udgør: <%= tax%></p>
                                                </label>
                                                </th>
                                            </label>
                                        </th>
                                        </div>
                                        </form>
                                        </div>
                                        </div>
                                        </div>
                                        </div>
                                        </body>
                                        </html>
