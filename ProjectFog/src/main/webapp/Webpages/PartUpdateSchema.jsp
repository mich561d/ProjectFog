<%-- 
    Document   : PartUpdateSchema
    Created on : 13-12-2018, 18:03:43
    Author     : Michael & Christian
--%>

<%@page import="FunctionLayer.Entities.Part"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opdater materiale</title>
        <%@include file="/WEB-INF/Imports/StyleImporter.jsp" %>
        <link href="Webpages/CSS/FogStyling.css" rel="stylesheet" type="text/css"/>
        <% Part part = (Part) request.getSession().getAttribute("part");%>
    </head>
    <body>
        <%@include file="/WEB-INF/Imports/NavBar.jsp" %>
        <br>
        <div class="container-fluid">        
            <div class="col-lg-10" style="margin: auto;">
                <div class="card">
                    <form name="UpdateMaterial" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="UpdateMaterial">
                        <input type="hidden" name="partID" value="<%=part.getId()%>">
                        <div class="card-header border border-warning">
                            <h3>Ændre værdierne og tryk på knappen nederst på siden</h3>
                        </div>
                        <div class="card-body border border-warning">
                            <table style="width:100%">
                                <tr style="width:100%">
                                    <td style="width:50%">
                                        <label>
                                            <p>Type:</p>
                                            <input type="text" class="form-control" name="type" placeholder="Eks. Brædt" value="<%=part.getType()%>" required>
                                        </label>
                                    </td>
                                    <td style="width:50%">
                                        <label>
                                            <p>Materiale:</p>
                                            <input type="text" class="form-control" name="material" placeholder="Eks. Trykimp Fyr" value="<%=part.getMaterial()%>" required>
                                        </label>
                                    </td>
                                </tr>
                                <tr style="width:100%">
                                    <td style="width:50%">
                                        <label>
                                            <p>Størrelse:</p>
                                            <input type="text" class="form-control" name="size" placeholder="Eks. 25x100mm 300cm" value="<%=part.getSize()%>" required>
                                        </label>
                                    </td>
                                    <td style="width:50%">
                                        <label>
                                            <p>Beskrivelse:</p>
                                            <input type="text" class="form-control" name="description" placeholder="Eks. Tryk impreneret brædt" value="<%=part.getDescription()%>" required>
                                        </label>
                                    </td>
                                </tr>
                                <tr style="width:100%">
                                    <td style="width:50%">
                                        <label>
                                            <p>Pris:</p>
                                            <input type="text" class="form-control" name="price" placeholder="Eks. 149.85" value="<%=part.getPrice()%>" required>
                                        </label>
                                    </td>
                                    <td style="width:50%">
                                        <label>
                                            <p>Mærke:</p>
                                            <input type="text" class="form-control" name="brand" placeholder="Eks. FOG" value="<%=part.getBrand()%>" required>
                                        </label>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        </table>
                        <div class="card-footer border border-warning">
                            <div class="row">
                                <div class="col-lg-1 align-self-start">
                                    <input disabled="disabled" type="submit" class="btn btn-secondary" name="back" value="Tilbage">
                                </div>
                                <div class='col-lg-8'></div>
                                <div class="col-lg-1 align-self-end">
                                    <input type="submit" class="btn btn-primary" name="create" value="Opdater materiale">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
