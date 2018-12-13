<%-- 
    Document   : CustomerOrders
    Created on : 04-12-2018, 16:59:34
    Author     : Michael & Christian
--%>

<%@page import="FunctionLayer.Entities.Carport"%>
<%@page import="FunctionLayer.Entities.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mine ordre</title>
        <%@include file="/WEB-INF/Imports/StyleImporter.jsp" %>
        <link href="Webpages/CSS/FogStyling.css" rel="stylesheet" type="text/css"/>
        <% ArrayList<Order> orders = (ArrayList<Order>)request.getSession().getAttribute("Orders");
            ArrayList<Carport> products = (ArrayList<Carport>)request.getSession().getAttribute("Products");%>
    </head>
    <body>
        <%@include file="/WEB-INF/Imports/NavBar.jsp" %>
        <br>
        <div class="container-fluid">   
            <div class="row justify-content-md-center">
                <div class="col-lg-10">
                    <div class="card border border-warning">
                        <div class="card-header border border-warning">
                            <h3>Dine ordre</h3>
                        </div>
                        <div class="card-body border border-warning">
                            <% if (!orders.isEmpty()) {%>
                            <label>
                                <div class="container">
                                    <table class="table table-primary table-condensed table-striped">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Status</th>
                                                <th>Købs dato</th>
                                                <th>Forsendelses dato</th>
                                                <th>Carport længde</th>
                                                <th>Carport bredde</th>
                                                <th>Carport højde</th>
                                                <th>Skur længde</th>
                                                <th>Skur bredde</th>
                                                <th>Skur gulv materiale</th>
                                                <th>Tag hældning</th>
                                                <th>Tag material</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <%for (int i = 0; i < orders.size(); i++) {%>
                                                <td><%=orders.get(i).getId()%></td>
                                                <td><%=orders.get(i).getStatus()%></td>
                                                <td><%=orders.get(i).getBoughtDate()%></td>
                                                <% if (orders.get(i).getSentDate() != null) {%>
                                                <td><%=orders.get(i).getSentDate()%></td>
                                                <%} else {%>
                                                <td>Din ordre er ikke blevet sendt endnu!</td>
                                                <%}%>
                                                <td><%=products.get(i).getCarportLength()%> cm</td>
                                                <td><%=products.get(i).getCarportWidth()%> cm</td>
                                                <td><%=products.get(i).getCarportHeight()%> cm</td>
                                                <% if (products.get(i).isShed()) {%>
                                                <td><%=products.get(i).getShedLength()%> cm</td>
                                                <td><%=products.get(i).getShedWidth()%> cm</td>
                                                <td><%=products.get(i).getFlooring()%></td>
                                                <%} else {%>
                                                <td>Denne ordre har ikke et skur</td>
                                                <td>Denne ordre har ikke et skur</td>
                                                <td>Denne ordre har ikke et skur</td>
                                                <%}%>
                                                <% if (products.get(i).isAngledRoof()) {%>
                                                <td><%=products.get(i).getAngle()%> grader</td>
                                                <td><%=products.get(i).getRoofing()%></td>
                                                <%} else {%>
                                                <td>Der er ikke tilvalgt hældning på dette tag</td>
                                                <td>Trapezplader</td>
                                                <%}}%>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </label>
                            <% } else { %>
                            <h3><strong>Bemærk: </strong>Du har ingen ordre gemt!</h3>
                            <% }%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
