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
public class ProductReviewCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        // Get meassurements
        int length = Integer.parseInt(request.getParameter("carportLength"));
        request.getSession().setAttribute("CarportLength", length);
        int width = Integer.parseInt(request.getParameter("carportWidth"));
        request.getSession().setAttribute("CarportWidth", width);
        int height = Integer.parseInt(request.getParameter("carportHeight"));
        request.getSession().setAttribute("CarportHeight", height);
        // Calc Price
        request.getSession().setAttribute("ProductPrice", LogicFacade.calculateCustomCarportPrice(length, width, height));
        // Get productlist
        request.getSession().setAttribute("ProductList", LogicFacade.getProductListFromCalculatedCustomCarport(length, width, height));
        // Make drawing
        System.out.println(LogicFacade.getDrawingFromAbove(length, width));
        request.getSession().setAttribute("Drawing", LogicFacade.getDrawingFromAbove(length, width));
        return "ProductReview";
    }
    
}
