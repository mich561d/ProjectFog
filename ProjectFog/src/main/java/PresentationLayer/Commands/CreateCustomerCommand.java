package PresentationLayer.Commands;

import FunctionLayer.Exceptions.FogException;
import FunctionLayer.Exceptions.LoginException;
import FunctionLayer.Exceptions.RegisterException;
import FunctionLayer.LogicFacade;
import PresentationLayer.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael & Christian
 */
public class CreateCustomerCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, RegisterException, LoginException {
        // Get data
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone").replaceAll(" ", "");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String city = request.getParameter("city");
        String zip = request.getParameter("zip");
        String street = request.getParameter("street");
        String number = request.getParameter("number");
        // Upload data to database
        int userID = LogicFacade.createUser(email, password);
        int customerID = LogicFacade.createCustomer(firstName, lastName, phone, userID);
        LogicFacade.createAddress(city, zip, street, number, customerID);
        return "index";
    }

}
