<%-- 
    Document   : EmployeePage
    Created on : 13-12-2018, 12:19:30
    Author     : Michael
--%>

<%@page import="FunctionLayer.Enums.EmployeeRole"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="/WEB-INF/Imports/StyleImporter.jsp" %>
        <link href="Webpages/CSS/FogStyling.css" rel="stylesheet" type="text/css"/>
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
        <% request.getSession().setAttribute("ErrorMsg", null);
            }
        %>
        <br>
        <div class="container-fluid">        
            <div class="col-lg-8" style="margin: auto;">
                <div class="card">
                    <form name="Employee" action="FrontController" method="POST">
                        <div class="card-header border border-warning">
                            <h3>Udfyld skema</h3>
                        </div>
                        <div class="card-body border border-warning">
                            <input type="hidden" name="command" value="CreateEmployee">
                            <table>
                                <tr>
                                    <td class="employeeTable">
                                        <p>Email:</p>
                                    </td>
                                    <td class="employeeTable">
                                        <input type="email" class="form-control" name="email" placeholder="example@gmail.com" max="45" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="employeeTable">
                                        <p>Password:</p>
                                    </td>
                                    <td class="employeeTable">
                                        <input type="password" class="form-control" name="password1" placeholder="password" min="8" max="45" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="employeeTable">
                                        <p>Gentag password:</p>
                                    </td>
                                    <td class="employeeTable">
                                        <input type="password" class="form-control" name="password2" placeholder="gentag password" min="8" max="45" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="employeeTable">
                                        <p>Fornavn:</p>
                                    </td>
                                    <td class="employeeTable">
                                        <input type="text" class="form-control" name="firstName" placeholder="Johannes" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="employeeTable">
                                        <p>Efternavn:</p>
                                    </td>
                                    <td class="employeeTable">
                                        <input type="text" class="form-control" name="lastName" placeholder="Fog" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="employeeTable">
                                        <p>Tlf:</p>
                                    </td>
                                    <td class="employeeTable">
                                        <input type="text" class="form-control" name="phone" placeholder="12 34 56 78" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="employeeTable">
                                        <p>Arbejd tlf:</p>
                                    </td>
                                    <td class="employeeTable">
                                        <input type="text" class="form-control" name="workPhone" placeholder="87 65 43 21" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="employeeTable">
                                        <p>Stilling:</p>
                                    </td>
                                    <td class="employeeTable">
                                        <select name="role" class="form-control" required>
                                            <% for (EmployeeRole role : EmployeeRole.values()) {%>
                                            <option value="<%=role%>"><%=role%></option>
                                            <%}%>
                                        </select>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div class="card-footer border border-warning">
                            <div class="row">
                                <div class="col-lg-8"></div>
                                <div class="col-lg-1 align-self-end">
                                    <input type="submit" class="btn btn-primary" name="next" value="Opret ny medarbejder">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
