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
                <input type="number" name="carportLength" placeholder="Cm" min="240" max="780" required>
                <input type="number" name="carportWidth" placeholder="Cm" min="240" max="750" required>
                <input type="number" name="carportHeight" placeholder="Cm" min="200" max="250" required>
                <h3>Tag</h3>
                <input type="checkbox" name="angledRoof">
                <input type="number" name="roofAngle" placeholder="Grader" min="0" max="75">
                <h3>Skur</h3>
                <input type="checkbox" name="shed">
                <input type="number" name="shedLength" placeholder="Cm" min="210" max="750" required>
                <input type="number" name="shedWidth" placeholder="Cm" min="210" max="720" required>
                <input type="submit" name="next" value="Næste">
                <input type="submit" name="update" value="Opdater">
            </form>
        </div>
    </body>
</html>
