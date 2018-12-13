<%-- 
    Document   : NavBar
    Created on : 27-11-2018, 09:22:50
    Author     : Michael & Christian
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
        <div class="col-lg-5" style="padding-top:2%">
            <div class="row">
                <div class="col-lg-auto">
                    <form name="CustomerPage" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="CustomerPage">
                        <button type="submit" class="btn btn-outline-warning ">Min side</button>
                    </form>
                </div>
                <div class="col-lg-auto">
                    <form name="CustomerOrders" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="CustomerOrders">
                        <button type="submit" class="btn btn-outline-warning">Ordre</button>
                    </form>
                </div>
                <div class="col-lg-auto">
                    <form name="FogPro" action="https://www.johannesfog.dk/pro/">
                        <button type="submit" class="btn btn-outline-primary ">FogPro</button>
                    </form>
                </div>
                <div class="col-lg-auto">
                    <form name="Logout" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="Logout">
                        <button type="submit" class="btn btn-outline-danger">Log ud</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <% } else if (request.getSession().getAttribute("EmployeeID") != null) {%>
    <div class="col-lg-5" style="padding-top:2%">
        <div class="row">
            <div class="col-lg-auto">
                <form name="EmployeePage" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="EmployeePage">
                    <button type="submit" class="btn btn-outline-warning ">Opret ny medarbejder</button>
                </form>
            </div>
            <div class="col-lg-auto">
                <form name="CustomerOrders" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="CustomerOrders">
                    <button type="submit" class="btn btn-outline-warning">Opdater materialer</button>
                </form>
            </div>
            <div class="col-lg-auto">
                <form name="FogPro" action="https://www.johannesfog.dk/pro/">
                    <button type="submit" class="btn btn-outline-warning ">Send ordre</button>
                </form>
            </div>
            <div class="col-lg-auto">
                <form name="Logout" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="Logout">
                    <button type="submit" class="btn btn-outline-danger">Log ud</button>
                </form>
            </div>
        </div>
    </div>
    <% }%>
</div>