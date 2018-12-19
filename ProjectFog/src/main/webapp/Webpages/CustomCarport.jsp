<%-- 
    Document   : CustomCarport
    Created on : 15-11-2018, 07:46:41
    Author     : Michael & Christian
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Entities.Part"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fog Carport</title>
        <%@include file="/WEB-INF/Imports/StyleImporter.jsp" %>
        <link href="Webpages/CSS/FogStyling.css" rel="stylesheet" type="text/css"/>
        <% ArrayList<Part> roofBrickList = (ArrayList<Part>) request.getSession().getAttribute("RoofBricksList");
        %>
    </head>
    <body>
        <%@include file="/WEB-INF/Imports/NavBar.jsp" %>
        <% if (request.getSession().getAttribute("ErrorMsg") != null) {%>
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
        <% request.getSession().setAttribute("ErrorMsg", null);
            }
        %>
        <br>
        <div class="container-fluid">        
            <div class="col-lg-6" style="margin: auto;">
                <div class="card">
                    <form name="Product" action="FrontController" method="POST">
                        <div class="card-header">
                            <h3>Intast dine mål</h3>
                        </div>
                        <div class="card-body">
                            <input type="hidden" name="command" value="ProductReview">
                            <table border="1" cellpadding='20'>
                                <tr>
                                    <th width="100%" colspan="2">
                                        <label>
                                            <h3>Carport</h3>
                                            <label>
                                                <p>Længde:</p>
                                                <input type="number" class="form-control" name="carportLength" placeholder="Cm" min="240" max="780" value="240" required>
                                            </label>
                                            <label>
                                                <p>Bredde:</p>
                                                <input type="number" class="form-control" name="carportWidth" placeholder="Cm" min="240" max="750" value="240" required>
                                            </label>
                                            <label>
                                                <p>Højde:</p>
                                                <input type="number" class="form-control" name="carportHeight" placeholder="Cm" min="200" max="250" value="200" required>
                                            </label>
                                        </label>
                                    </th>
                                </tr>
                                <tr>
                                    <th width="50%" valign='top'>
                                        <label>
                                            <h3>Tag</h3>
                                            <label class="form-control">
                                                <p>Tag med Rejsning:</p>
                                                <input type="checkbox" name="angledRoof">
                                            </label>
                                            <label>
                                                <p>Belægning:</p>
                                                <select name="roofing" class="form-control">
                                                    <option value="Tagpap">Tagpap</option>
                                                    <% for (int i = 0;
                                                                i < roofBrickList.size();
                                                                i++) {%>
                                                    <option value="<%= roofBrickList.get(i).getType()%>"><%= roofBrickList.get(i).getType()%></option>
                                                    <% }%>
                                                </select>
                                            </label>
                                            <label>
                                                <p>Rejsning:</p>
                                                <input type="number" class="form-control" name="roofAngle" placeholder="Grader" min="0" max="75" value="0" required>
                                            </label>
                                            <p> *Hvis de ikke ønsker rejsning vil deres carport blive leveret med Trapezplade tag </p>
                                        </label>
                                    </th>
                                    <th width="50%" valign='top'>
                                        <label>
                                            <h3>Skur</h3>
                                            <label class="form-control">
                                                <p>Tilvælg Skur:</p>
                                                <input type="checkbox" name="shed">
                                            </label>
                                            <label>
                                                <p>Længde:</p>
                                                <input type="number" class="form-control" name="shedLength" placeholder="Cm" min="0" max="750" value="0" required>
                                            </label>
                                            <label>
                                                <p>Bredde:</p>
                                                <input type="number" class="form-control" name="shedWidth" placeholder="Cm" min="0" max="720" value="0" required>
                                            </label>
                                            <p> *skurets længde skal minimum være 30 cm mindre en carportens længde
                                        </label>
                                    </th>
                                </tr>
                            </table>
                            <div class="card-footer">
                                <div class="row">
                                    <div class="col-lg-1 align-self-start">
                                        <input disabled="disabled" type="submit" class="btn btn-secondary" name="back" value="Tilbage">
                                    </div>
                                    <div class="col-lg-9"></div>
                                    <div class="col-lg-1 align-self-end">
                                        <input type="submit" class="btn btn-primary" name="next" value="Næste">
                                    </div>
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
