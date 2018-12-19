<%-- 
    Document   : OrderPage
    Created on : 13-12-2018, 14:45:11
    Author     : Michael & Christian
--%>

<%@page import="FunctionLayer.Entities.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Send ordre</title>
        <%@include file="/WEB-INF/Imports/StyleImporter.jsp" %>
        <link href="Webpages/CSS/FogStyling.css" rel="stylesheet" type="text/css"/>
        <% ArrayList<Order> orders = (ArrayList<Order>) request.getSession().getAttribute("AllOrders");%>
    </head>
    <body>
        <%@include file="/WEB-INF/Imports/NavBar.jsp" %>
        <% if (request.getSession().getAttribute("msg") != null) {%>
        <div class="container">
            <div class="row">
                <div class="col-lg">
                    <div class="alert alert-success alert-dismissible fade show">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Info:</strong> <%= request.getSession().getAttribute("msg")%>
                    </div>
                </div>
            </div>
        </div>
        <% request.getSession().setAttribute("msg", null);
            }
        %>
        <br>
        <div class="container-fluid">        
            <div class="col-lg" style="margin: auto;">
                <div class="card">
                    <div class="card-header border border-warning">
                        <h3>Udfyld skema</h3>
                    </div>
                    <div class="card-body border border-warning">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">ID</th>
                                    <th scope="col">Status</th>
                                    <th scope="col">Købsdato</th>
                                    <th scope="col">Afsendelsesdato</th>
                                    <th scope="col">Produkt ID</th>
                                    <th scope="col">Kunde ID</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% for (int i = 0; i < orders.size(); i++) {
                                        Order order = orders.get(i);%>
                                <tr>
                                    <th scope="row"><%=i + 1%></th>
                                    <td><%=order.getId()%></td>
                                    <td><%=order.getStatus()%></td>
                                    <td><%=order.getBoughtDate().split(" ")[0]%></td>
                                    <% if (order.getSentDate() != null) {%>
                                    <td><%=order.getSentDate().split(" ")[0]%></td>
                                    <% } else {%>
                                    <td>
                                        <form name="SendOrder" action="FrontController" method="POST">
                                            <input type="hidden" name="command" value="SendOrder">
                                            <input type="hidden" name="orderID" value="<%=order.getId()%>">
                                            <button type="submit" class="btn btn-outline-primary">Send ordre</button>
                                        </form>
                                    </td>
                                    <% }%>
                                    <td><%=order.getProductsID()%></td>
                                    <td><%=order.getCustomerID()%></td>
                                </tr>
                                <% }%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
