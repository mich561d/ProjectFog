package PresentationLayer.Commands;

import FunctionLayer.Entities.Carport;
import FunctionLayer.Exceptions.FogException;
import FunctionLayer.LogicFacade;
import PresentationLayer.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Christian & Michael
 */
public class PaymentCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        int customerID = (int) request.getSession().getAttribute("CustomerID");
        // Create order & product
        // Upload to database
        Carport carport = (Carport) request.getSession().getAttribute("Product");
        int productID = LogicFacade.createProduct(carport);
        LogicFacade.createOrder(customerID, productID);
        // Go on
        if (request.getSession().getAttribute("ProductPrice") == null) {
            request.getSession().setAttribute("ProductPrice", LogicFacade.getPriceFromCarport());
        }
        if (request.getSession().getAttribute("ProductList") == null) {
            request.getSession().setAttribute("ProductList", LogicFacade.getProductMapFromCarport());
        }
        return "Payment";
    }

}
