package PresentationLayer.Commands;

import FunctionLayer.Entities.Order;
import FunctionLayer.Exceptions.CarportCreationException;
import FunctionLayer.Exceptions.FogException;
import FunctionLayer.Exceptions.LoginException;
import FunctionLayer.Exceptions.RegisterException;
import FunctionLayer.LogicFacade;
import PresentationLayer.Command;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael & Christian
 */
public class OrderPageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, RegisterException, LoginException, CarportCreationException {
        // Get all orders
        ArrayList<Order> orders = LogicFacade.getAllOrders();
        request.getSession().setAttribute("AllOrders", orders);
        return "OrderPage";
    }
    
}
