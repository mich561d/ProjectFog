package PresentationLayer.Commands;

import FunctionLayer.Entities.Customer;
import FunctionLayer.Exceptions.FogException;
import FunctionLayer.LogicFacade;
import PresentationLayer.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael & Christian
 */
public class UpdateCustomerInformationCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        // Get Input
        String firstName = request.getParameter("changeFirstName");
        String lastName = request.getParameter("changeLastName");
        String phone = request.getParameter("changePhone");
        String city = request.getParameter("changeCity");
        String zip = request.getParameter("changeZip");
        String street = request.getParameter("changeStreet");
        String number = request.getParameter("changeNumber");
        String cardNumber = request.getParameter("changeCardNumber");
        String cardExpireDate = request.getParameter("changeExpireDate");
        // Change data in database
        Customer customer = null;
        if (needsChange(firstName) || needsChange(lastName) || needsChange(phone)) {
            customer = LogicFacade.getCustomerByID(Integer.parseInt(request.getSession().getAttribute("CustomerID").toString()));
            // Change customer
        }
        if (needsChange(city) || needsChange(zip) || needsChange(street) || needsChange(number)) {
            if (customer == null) {
                customer = LogicFacade.getCustomerByID(Integer.parseInt(request.getSession().getAttribute("CustomerID").toString()));
            }
            // Change address
        }
        if (needsChange(cardNumber) || needsChange(cardExpireDate)) {
            if (customer == null) {
                customer = LogicFacade.getCustomerByID(Integer.parseInt(request.getSession().getAttribute("CustomerID").toString()));
            }
            // Change paymentInformation
        }
        // Go on
        request.getSession().setAttribute("Updated", true);
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
