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
public class UpdateCustomerInformationCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, RegisterException {
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
        Customer customer = LogicFacade.getCustomerByID(Integer.parseInt(request.getSession().getAttribute("CustomerID").toString()));
        int id = customer.getId();
        boolean updatedCustomer = false;
        if (needsChange(firstName)) {
            LogicFacade.updateFirstName(id, firstName);
            updatedCustomer = true;
        }
        if (needsChange(lastName)) {
            LogicFacade.updateLastName(id, lastName);
            updatedCustomer = true;
        }
        if (needsChange(phone)) {
            LogicFacade.updatePhone(id, phone);
            updatedCustomer = true;
        }
        boolean updatedAddress = false;
        if (needsChange(city)) {
            LogicFacade.updateCity(id, city);
            updatedAddress = true;
        }
        if (needsChange(zip)) {
            LogicFacade.updateZip(id, zip);
            updatedAddress = true;
        }
        if (needsChange(street)) {
            LogicFacade.updateStreet(id, street);
            updatedAddress = true;
        }
        if (needsChange(number)) {
            LogicFacade.updateNumber(id, number);
            updatedAddress = true;
        }
        boolean updatedPaymentInformation = false;
        if (needsChange(cardNumber)) {
            LogicFacade.updateCardNumber(id, cardNumber);
            updatedPaymentInformation = true;
        }
        if (needsChange(cardExpireDate)) {
            LogicFacade.updateExpireDate(id, cardExpireDate);
            updatedPaymentInformation = true;
        }
        if (updatedCustomer) {
            request.getSession().setAttribute("Customer", LogicFacade.getCustomerByID(id));
        }
        if (updatedAddress) {
            request.getSession().setAttribute("Address", LogicFacade.getAddressByID(id));
        }
        if (updatedPaymentInformation) {
            request.getSession().setAttribute("Payment", LogicFacade.getPaymentInformationByID(id));
        }
        if (updatedCustomer || updatedAddress || updatedPaymentInformation) {
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
