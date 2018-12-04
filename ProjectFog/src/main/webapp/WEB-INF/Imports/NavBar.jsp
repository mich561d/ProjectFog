<%-- 
    Document   : NavBar
    Created on : 27-11-2018, 09:22:50
    Author     : Michael
--%>

<div class="container">
    <div class="row" style="background-color: #0c2069; height:110px">
        <div>
            <form name="Logo" action="FrontController" method="POST">
                <input type="hidden" name="command" value="Index">
                <input type="image" src="Assets/FOGLogo.jpg" alt="Umage betaler sig!" height="110" width="110"/>
            </form>
        </div>
        <div class="col-lg-5" style="padding-top:2%">
            <h1 style="color: white; border-top-style: solid; border-bottom-style: solid; border-color: #ffcc00; text-align: center;" font="Ariel">UMAGE BETALER SIG</h1>
        </div>
        <% if (request.getSession().getAttribute("CustomerID") != null) {%>
        <div class="col-lg-1"></div>
        <div class="col-lg-1" style="padding-top:2%">
            <form name="Fogro" action="https://www.johannesfog.dk/pro/">
                <button type="submit" class="btn btn-outline-primary ">FogPro</button>
            </form>
        </div>
        <div class="col-lg-1" style="padding-top:2%">
            <form name="UserPage" action="FrontController" method="POST">
                <input type="hidden" name="command" value="UserPage">
                <button type="submit" class="btn btn-outline-warning ">Min side</button>

            </form>
        </div>
        <div class="col-lg-1" style="padding-top:2%">
            <form name="UserPage" action="FrontController" method="POST">
                <input type="hidden" name="command" value="UserPage">
                <button type="submit" class="btn btn-outline-warning">Ordre</button>
            </form>
        </div>
        <div class="col-lg-1" style="padding-top:2%">
            <form name="Logout" action="FrontController" method="POST">
                <input type="hidden" name="command" value="Logout">
                <button type="submit" class="btn btn-outline-danger">Log ud</button>
        </div>
        </form>
    </div>
    <% }%>
</div>
</div>