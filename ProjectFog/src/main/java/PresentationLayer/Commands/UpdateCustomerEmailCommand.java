package PresentationLayer.Commands;

import FunctionLayer.Entities.Customer;
import FunctionLayer.Exceptions.FogException;
import FunctionLayer.Exceptions.RegisterException;
import FunctionLayer.LogicFacade;
import PresentationLayer.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael & Christian
 */
public class UpdateCustomerEmailCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws RegisterException, FogException {
        String email = request.getParameter("changeEmail");
        if (needsChange(email)) {
            Customer customer = LogicFacade.getCustomerByID(Integer.parseInt(request.getSession().getAttribute("CustomerID").toString()));
            int id = customer.getId();
            
            LogicFacade.doEmailExist(email);
            LogicFacade.updateEmail(id, email);
            
            request.getSession().setAttribute("User", LogicFacade.getUserByID(id));
            request.getSession().setAttribute("Updated", true);
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
