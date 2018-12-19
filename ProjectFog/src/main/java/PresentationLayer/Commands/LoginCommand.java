package PresentationLayer.Commands;

import FunctionLayer.Entities.Customer;
import FunctionLayer.Entities.Employee;
import FunctionLayer.Exceptions.FogException;
import FunctionLayer.Exceptions.LoginException;
import FunctionLayer.LogicFacade;
import PresentationLayer.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael & Christian
 */
public class LoginCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, LoginException {
        String email = request.getParameter("LoginEmail");
        String password = request.getParameter("LoginPassword");
        int userID = LogicFacade.login(email, password);
        try {
            Customer customer = LogicFacade.getCustomerByUserID(userID);
            request.getSession().setAttribute("CustomerID", customer.getId());
            request.getSession().setAttribute("Name", customer.getFullName());
        } catch (FogException e) {
            Employee employee = LogicFacade.getEmployeeByUserID(userID);
            request.getSession().setAttribute("EmployeeID", employee.getId());
            request.getSession().setAttribute("Name", employee.getFullName());
        }
        return "index";
    }

}
