package PresentationLayer.Commands;

import FunctionLayer.Entities.Part;
import FunctionLayer.Exceptions.FogException;
import FunctionLayer.LogicFacade;
import PresentationLayer.Command;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael
 */
public class CustomCarportCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        ArrayList<Part> listOfRoofBricks = LogicFacade.getAllRoofBricksAsList();
        request.getSession().setAttribute("RoofBricksList", listOfRoofBricks);
        return "CustomCarport";
    }

}
