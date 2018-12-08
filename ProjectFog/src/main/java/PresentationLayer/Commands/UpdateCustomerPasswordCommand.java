package PresentationLayer.Commands;

import FunctionLayer.Entities.Customer;
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
public class UpdateCustomerPasswordCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, RegisterException, LoginException {
        String pass1 = request.getParameter("changePass1");
        String pass2 = request.getParameter("changePass2");
        if (needsChange(pass1) && needsChange(pass2)) {
            if (LogicFacade.checkPasswords(pass1, pass2)) {
                Customer customer = LogicFacade.getCustomerByID(Integer.parseInt(request.getSession().getAttribute("CustomerID").toString()));
                int id = customer.getId();

                String email = LogicFacade.getUserByID(id).getEmail();
                String salt = LogicFacade.getSaltString(email);
                String hashedPassword = LogicFacade.hashPassword(pass1, salt);
                LogicFacade.updatePassword(id, hashedPassword);

                request.getSession().setAttribute("User", LogicFacade.getUserByID(id));
                request.getSession().setAttribute("Updated", true);
            }
        }
        return "CustomerPage";
    }

    private boolean needsChange(String input) {
        if (input == null) {
            return false;
        } else if (input.isEmpty()) {
            return false;
        }
        return true;
    }

}
