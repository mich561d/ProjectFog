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
        // Base
        int length = Integer.parseInt(request.getParameter("carportLength"));
        request.getSession().setAttribute("CarportLength", length);
        int width = Integer.parseInt(request.getParameter("carportWidth"));
        request.getSession().setAttribute("CarportWidth", width);
        int height = Integer.parseInt(request.getParameter("carportHeight"));
        request.getSession().setAttribute("CarportHeight", height);
        // Roof
        int angle = 0;
        String roofOnOrNot = request.getParameter("angledRoof");
        boolean angledRoof = false;
        if ("on".equals(roofOnOrNot)) {
            angledRoof = true;
        }
        request.getSession().setAttribute("AngledRoof", angledRoof);
        if (angledRoof == true) {
            angle = Integer.parseInt(request.getParameter("roofAngle"));
            request.getSession().setAttribute("RoofAngle", angle);
        }
        // Shed
        int shedLength = 0, shedWidth = 0;
        String shedOnOrNot = request.getParameter("shed");
        boolean shed = false;
        if ("on".equals(shedOnOrNot)) {
            shed = true;
        }
        request.getSession().setAttribute("Shed", shed);
        if (angledRoof == true) {
            shedLength = Integer.parseInt(request.getParameter("shedLength"));
            request.getSession().setAttribute("ShedLength", shedLength);
            shedWidth = Integer.parseInt(request.getParameter("shedWidth"));
            request.getSession().setAttribute("ShedWidth", shedWidth);
        }

        LogicFacade.calculateCustomCarport(length, width, height, angle, angledRoof, shed, shedLength, shedWidth);
        request.getSession().setAttribute("ProductPrice", LogicFacade.getPriceFromCarport());
        request.getSession().setAttribute("ProductList", LogicFacade.getProductMapFromCarport());
        request.getSession().setAttribute("DrawingAbove", LogicFacade.getDrawingFromAbove(length, width, angledRoof));
        request.getSession().setAttribute("DrawingAside", LogicFacade.getDrawingFromAside(length, height));
        request.getSession().setAttribute("DrawingFront", LogicFacade.getDrawingFromFront(width, height));
        return "ProductReview";
    }

}
