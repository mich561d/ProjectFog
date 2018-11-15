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
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h3>Intast dine mål</h3>
            <form name="Calculator" action="FrontController" method="POST">
                <input type="hidden" name="command" value="Calculator">
                <h3>Carport</h3>
                <input type="number" name="carportlength" placeholder="cm" min="240" max="780">
                <input type="number" name="carportwidth" placeholder="cm" min="240" max="750">
                <input type="number" name="carportheight" placeholder="cm" min="200" max="250">
                <h3>Tag</h3>
                <input type="number" name="carportlength" placeholder="cm" min="240" max="780">
            </form>
        </div>
    </body>
</html>
