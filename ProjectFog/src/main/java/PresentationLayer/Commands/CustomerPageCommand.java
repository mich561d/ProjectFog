/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer.Commands;

import FunctionLayer.Entities.Address;
import FunctionLayer.Entities.Customer;
import FunctionLayer.Entities.PaymentInformation;
import FunctionLayer.Entities.User;
import FunctionLayer.Exceptions.FogException;
import FunctionLayer.LogicFacade;
import PresentationLayer.Command;
import java.util.logging.Level;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael
 */
public class CustomerPageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        if (request.getSession().getAttribute("CustomerID") == null) {
            throw new FogException("Der skete en fejl!.. Prøv at logge ind igen!", Level.INFO);
        }
        Customer customer = LogicFacade.getCustomerByID((int) request.getSession().getAttribute("CustomerID"));
        Address address = LogicFacade.getAddressByID(customer.getAddressID());
        PaymentInformation payment = LogicFacade.getPaymentInformationByID(customer.getPaymentID());
        User user = LogicFacade.getUserByID(customer.getUserID());
        request.getSession().setAttribute("Customer", customer);
        request.getSession().setAttribute("Address", address);
        request.getSession().setAttribute("Payment", payment);
        request.getSession().setAttribute("User", user);
        return "CustomerPage";
    }

}
