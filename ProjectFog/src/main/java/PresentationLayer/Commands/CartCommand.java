package PresentationLayer.Commands;

import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import PresentationLayer.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Christian & Michael
 */
public class CartCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        if (request.getSession().getAttribute("ProductPrice") == null) {
            int length = Integer.parseInt(request.getSession().getAttribute("CarportLength").toString());
            int width = Integer.parseInt(request.getSession().getAttribute("CarportWidth").toString());
            int height = Integer.parseInt(request.getSession().getAttribute("CarportHeight").toString());
            int angle = Integer.parseInt(request.getSession().getAttribute("RoofAngle").toString());
            request.getSession().setAttribute("ProductPrice", LogicFacade.calculateCustomCarportPrice(length, width, height, angle));
        }
        return "Cart";
    }

}
