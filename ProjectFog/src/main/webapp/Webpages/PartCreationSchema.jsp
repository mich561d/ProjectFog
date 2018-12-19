<%-- 
    Document   : PartCreationSchema
    Created on : 13-12-2018, 16:44:17
    Author     : Michael & Christian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opret materiale</title>
        <%@include file="/WEB-INF/Imports/StyleImporter.jsp" %>
        <link href="Webpages/CSS/FogStyling.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="/WEB-INF/Imports/NavBar.jsp" %>
        <br>
        <div class="container-fluid">        
            <div class="col-lg-10" style="margin: auto;">
                <div class="card">
                    <form name="UploadMaterial" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="UploadMaterial">
                        <div class="card-header border border-warning">
                            <h3>Udfyld skemaet for at oprette materialet i systemet</h3>
                            <p><strong>*Udfyld skemaet som vist ved hjælp at 'pladsholderende'</strong></p>
                        </div>
                        <div class="card-body border border-warning">
                            <table style="width:100%">
                                <tr style="width:100%">
                                    <td style="width:50%">
                                        <label>
                                            <p>Type:</p>
                                            <input type="text" class="form-control" name="type" placeholder="Eks. Brædt" required>
                                        </label>
                                    </td>
                                    <td style="width:50%">
                                        <label>
                                            <p>Materiale:</p>
                                            <input type="text" class="form-control" name="material" placeholder="Eks. Trykimp Fyr" required>
                                        </label>
                                    </td>
                                </tr>
                                <tr style="width:100%">
                                    <td style="width:50%">
                                        <label>
                                            <p>Størrelse:</p>
                                            <input type="text" class="form-control" name="size" placeholder="Eks. 25x100mm 300cm" required>
                                        </label>
                                    </td>
                                    <td style="width:50%">
                                        <label>
                                            <p>Beskrivelse:</p>
                                            <input type="text" class="form-control" name="description" placeholder="Eks. Tryk impreneret brædt" required>
                                        </label>
                                    </td>
                                </tr>
                                <tr style="width:100%">
                                    <td style="width:50%">
                                        <label>
                                            <p>Pris:</p>
                                            <input type="text" class="form-control" name="price" placeholder="Eks. 149.85" required>
                                        </label>
                                    </td>
                                    <td style="width:50%">
                                        <label>
                                            <p>Mærke:</p>
                                            <input type="text" class="form-control" name="brand" placeholder="Eks. FOG" required>
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
                                    <input type="submit" class="btn btn-primary" name="create" value="Opret materiale">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
