package PresentationLayer.Commands;

import static FunctionLayer.Calculation.Rules.*;
import FunctionLayer.Exceptions.CarportCreationException;
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
public class ProductReviewCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, CarportCreationException {
        // Base
        int length = Integer.parseInt(request.getParameter("carportLength"));
        request.getSession().setAttribute("CarportLength", length);
        int width = Integer.parseInt(request.getParameter("carportWidth"));
        request.getSession().setAttribute("CarportWidth", width);
        int height = Integer.parseInt(request.getParameter("carportHeight"));
        request.getSession().setAttribute("CarportHeight", height);
        // Roof
        String roofOnOrNot = request.getParameter("angledRoof");
        boolean angledRoof = false;
        if ("on".equals(roofOnOrNot)) {
            angledRoof = true;
        }
        int angle = 0;
        String roofing = "tagpap";
        request.getSession().setAttribute("AngledRoof", angledRoof);
        if (angledRoof) {
            angle = Integer.parseInt(request.getParameter("roofAngle"));
            request.getSession().setAttribute("RoofAngle", angle);
            roofing = request.getParameter("roofing");
            request.getSession().setAttribute("Roofing", roofing);
        }
        // Shed
        int shedLength = 0, shedWidth = 0;
        String shedOnOrNot = request.getParameter("shed");
        boolean shed = false;
        if ("on".equals(shedOnOrNot)) {
            shed = true;
        }
        request.getSession().setAttribute("Shed", shed);
        if (shed) {
            shedLength = Integer.parseInt(request.getParameter("shedLength"));
            request.getSession().setAttribute("ShedLength", shedLength);
            shedWidth = Integer.parseInt(request.getParameter("shedWidth"));
            request.getSession().setAttribute("ShedWidth", shedWidth);

            if (shedLength > length - POLE_DOUBLE_OFFSET || shedWidth > width - POLE_DOUBLE_OFFSET) {
                throw new CarportCreationException("Dit valgte skur er længere end de valgte carport mål!", Level.INFO);
            }
            if (shedLength < DOOR_WIDTH && shedWidth < DOOR_WIDTH) {
                throw new CarportCreationException("Dit valgte skur er for lille til at der kan placeres en dør!", Level.INFO);
            }
        }

        LogicFacade.calculateCustomCarport(length, width, height, angle, angledRoof, shed, shedLength, shedWidth, roofing);
        request.getSession().setAttribute("ProductPrice", LogicFacade.getPriceFromCarport());
        request.getSession().setAttribute("ProductList", LogicFacade.getProductMapFromCarport());
        request.getSession().setAttribute("DrawingAbove", LogicFacade.getDrawingFromAbove(length, width, angledRoof));
        request.getSession().setAttribute("DrawingAside", LogicFacade.getDrawingFromAside(length, height));
        request.getSession().setAttribute("DrawingFront", LogicFacade.getDrawingFromFront(width, height));
        return "ProductReview";
    }

}
