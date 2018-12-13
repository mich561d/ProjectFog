<%-- 
    Document   : PartPage
    Created on : 13-12-2018, 16:13:51
    Author     : Michael & Christian
--%>

<%@page import="FunctionLayer.Entities.Part"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Materialer</title>
        <%@include file="/WEB-INF/Imports/StyleImporter.jsp" %>
        <link href="Webpages/CSS/FogStyling.css" rel="stylesheet" type="text/css"/>
        <% ArrayList<Part> parts = (ArrayList<Part>) request.getSession().getAttribute("AllParts");%>
    </head>
    <body>
        <%@include file="/WEB-INF/Imports/NavBar.jsp" %>
        <% if (request.getSession().getAttribute("msg") != null) {%>
        <div class="container">
            <div class="row">
                <div class="col-lg">
                    <div class="alert alert-danger alert-dismissible fade show">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Error:</strong> <%= request.getSession().getAttribute("ErrorMsg")%>
                    </div>
                </div>
            </div>
        </div>
        <% }
            request.getSession().setAttribute("msg", null);%>
        <br>
        <div class="container-fluid">        
            <div class="col-lg" style="margin: auto;">
                <div class="card">
                    <div class="card-header border border-warning">
                        <h3>Materialer i databasen</h3>
                    </div>
                    <div class="card-body border border-warning">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">ID</th>
                                    <th scope="col">Type</th>
                                    <th scope="col">Materiale</th>
                                    <th scope="col">Størrelse</th>
                                    <th scope="col">Beskrivelse</th>
                                    <th scope="col">Pris</th>
                                    <th scope="col">Mærke</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% for (int i = 0; i < parts.size(); i++) {
                                        Part part = parts.get(i);%>
                                <tr>
                                    <th scope="row"><%=i + 1%></th>
                                    <td><%=part.getId()%></td>
                                    <td><%=part.getType()%></td>
                                    <td><%=part.getMaterial()%></td>
                                    <td><%=part.getSize()%></td>
                                    <td><%=part.getDescription()%></td>
                                    <td><%=part.getPrice()%></td>
                                    <td><%=part.getBrand()%></td>
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
