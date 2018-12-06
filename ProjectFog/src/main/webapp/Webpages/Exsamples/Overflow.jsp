<%-- 
    Document   : Overflow
    Created on : 06-12-2018, 12:12:39
    Author     : Christian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--
        <label>
                                    <h3 style="text-align: center">Stykliste</h3>

                                    <div class="container">
                                        <table class="table table-condensed table-striped">
                                            <thead>
                                                <tr>
                                                    <th>Type</th>
                                                    <th>Størrelse</th>
                                                    <th>Detaljer</th>
                                                    <th>Antal</th>
                                                    <th>Stykpris</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%
                                                    Set set = products.keySet();
                                                    ArrayList<String> keys = new ArrayList<>();
                                                    keys.addAll(set);
                                                    for (int i = 0; i < keys.size(); i++) {
                                                        ArrayList<Part> parts = products.get(keys.get(i));
                                                        Part part = parts.get(0);
                                                %>
                                                <tr>
                                                    <td><%= part.getType()%></td>
                                                    <td><%= part.getSize()%></td>
                                                    <td><%= part.getDescription()%></td>
                                                    <td><%= parts.size()%></td>
                                                    <td><%= part.getPrice()%> kr.</td>
                                                </tr>
                                                <% }%>
                                            </tbody>
                                        </table>
                                    </div>
                                    <label style="width: 100%">
                                        <h3 style="text-align: center">Pris</h3>
                                        <div style="text-align: right; margin-right: 5%">
                                            <label>
                                                <p>Total: <%= formattedTotalPrice%> kr.</p>
                                            </label>
                                            <br>
                                            <label>
                                                <p>Heraf moms: <%= formattedTax%> kr.</p>
                                            </label>
                                        </div>
                                    </label>
                                </label>
        -->
        <!--
        <br>
            <hr>
            <div style="text-align: center">  
                <h3>Plantegninger af carport:</h3>
                <table align="center" cellspacing="50px">
                    <tr>
                        <td rowspan="2">
                            <h4>Oppe fra:</h4>
                            <%= request.getSession().getAttribute("DrawingAbove")%>
                        </td>
                        <td>
                            <h4>Forfra:</h4>
                            <%= request.getSession().getAttribute("DrawingFront")%>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h4>Fra siden:</h4>
                            <%= request.getSession().getAttribute("DrawingAside")%>
                        </td>
                    </tr>
                </table>
            </div>
        -->
    </body>
</html>
