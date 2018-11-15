<%-- 
    Document   : CustomCarport
    Created on : 15-11-2018, 07:46:41
    Author     : Michael & Christian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fog Carport</title>
        <%@include file="/WEB-INF/Imports/StyleImporter.jsp" %>
    </head>
    <body>
        <div class="container-fluid">        
            <div class="col-lg-6">
                <div class="card">
                    <form name="Calculator" action="FrontController" method="POST">
                        <div class="card-header">
                            <h3>Intast dine mål</h3>
                        </div>
                        <div class="card-body">
                            <input type="hidden" name="command" value="Calculator">
                            <table>
                                <tr>
                                    <th width="100%">
                                        <label>
                                            <h3>Carport</h3>
                                            <label>
                                                <p>Længde:</p>
                                                <input type="number" class="form-control" name="carportLength" placeholder="Cm" min="240" max="780" required>
                                            </label>
                                            <br>
                                            <label>
                                                <p>Bredde:</p>
                                                <input type="number" class="form-control" name="carportWidth" placeholder="Cm" min="240" max="750" required>
                                            </label>
                                            <br>
                                            <label>
                                                <p>Højde:</p>
                                                <input type="number" class="form-control" name="carportHeight" placeholder="Cm" min="200" max="250" required>
                                            </label>
                                        </label>
                                    </th>
                                </tr>
                                <tr>
                                    <th>
                                        <label>
                                            <h3>Tag</h3>
                                            <label class="form-control">
                                                <p>Tag:</p>
                                                <input type="checkbox" name="angledRoof">
                                            </label>
                                            <label>
                                                <p>Rejsning:</p>
                                                <input type="number" class="form-control" name="roofAngle" placeholder="Grader" min="0" max="75">
                                            </label>
                                        </label>
                                    </th>
                                    <th>
                                        <label>
                                            <h3>Skur</h3>
                                            <label class="form-control">
                                                <p>Skur:</p>
                                                <input type="checkbox" name="shed">
                                            </label>
                                            <label>
                                                <p>Længde:</p>
                                                <input type="number" class="form-control" name="shedLength" placeholder="Cm" min="210" max="750">
                                            </label>
                                            <br>
                                            <label>
                                                <p>Bredde:</p>
                                                <input type="number" class="form-control" name="shedWidth" placeholder="Cm" min="210" max="720">
                                            </label>
                                        </label>
                                    </th>
                                </tr>
                            </table>
                            <div class="card-footer">
                                <input type="submit" class="btn btn-secondary" name="update" value="Opdater">
                                <input type="submit" class="btn btn-primary" name="next" value="Næste">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
