package PresentationLayer.Commands;

import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import PresentationLayer.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael
 */
public class ProductReviewCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        int length = Integer.parseInt(request.getParameter("carportLength"));
        request.getSession().setAttribute("CarportLength", length);
        int width = Integer.parseInt(request.getParameter("carportWidth"));
        request.getSession().setAttribute("CarportWidth", width);
        int height = Integer.parseInt(request.getParameter("carportHeight"));
        request.getSession().setAttribute("CarportHeight", height);
        int angle = 0;
        String onOrNot = request.getParameter("angledRoof");
        boolean angledRoof = false;
        if ("on".equals(onOrNot)) {
            angledRoof = true;
        }
        request.getSession().setAttribute("AngledRoof", angledRoof);
        if (angledRoof == true) {
            angle = Integer.parseInt(request.getParameter("roofAngle"));
            request.getSession().setAttribute("RoofAngle", angle);
        }
        LogicFacade.calculateCustomCarport(length, width, height, angle, angledRoof);
        request.getSession().setAttribute("ProductPrice", LogicFacade.getPriceFromCarport());
        request.getSession().setAttribute("ProductList", LogicFacade.getProductsFromCarport());
        request.getSession().setAttribute("DrawingAbove", LogicFacade.getDrawingFromAbove(length, width));
        request.getSession().setAttribute("DrawingAside", LogicFacade.getDrawingFromAside(length, height));
        request.getSession().setAttribute("DrawingFront", LogicFacade.getDrawingFromFront(width, height));
        return "ProductReview";
    }

}
