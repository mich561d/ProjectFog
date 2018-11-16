package PresentationLayer.Commands;

import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import PresentationLayer.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Christian
 */
public class CartCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        if (request.getSession().getAttribute("ProductPrice") == null) {
            int length = Integer.parseInt(request.getParameter("carportLength"));
            int width = Integer.parseInt(request.getParameter("carportWidth"));
            int height = Integer.parseInt(request.getParameter("carportHeight"));

            request.getSession().setAttribute("ProductPrice", LogicFacade.CalculateCustomCarportPrice(length, width, height));
        }
        return "Cart";
    }

}
