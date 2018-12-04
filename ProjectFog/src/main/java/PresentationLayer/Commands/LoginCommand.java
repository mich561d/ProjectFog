package PresentationLayer.Commands;

import FunctionLayer.Entities.Customer;
import FunctionLayer.Exceptions.FogException;
import FunctionLayer.Exceptions.LoginException;
import FunctionLayer.LogicFacade;
import PresentationLayer.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael
 */
public class LoginCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, LoginException {
        String email = request.getParameter("LoginEmail");
        String password = request.getParameter("LoginPassword");
        int id = LogicFacade.login(email, password);
        Customer customer = LogicFacade.getCustomerByUserID(id);
        request.getSession().setAttribute("CustomerID", customer.getId());
        request.getSession().setAttribute("CustomerName", customer.getFullName());
        return "index";
    }

}
