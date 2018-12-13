package PresentationLayer.Commands;

import FunctionLayer.Entities.Part;
import FunctionLayer.Exceptions.FogException;
import FunctionLayer.Exceptions.LoginException;
import FunctionLayer.LogicFacade;
import PresentationLayer.Command;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael & Christian
 */
public class CustomCarportCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, LoginException {
        if (request.getSession().getAttribute("EmployeeID") != null) {
            throw new LoginException("Du skal logge ind som en brugere!", Level.INFO);
        }
        if (request.getSession().getAttribute("CustomerID") == null) {
            throw new LoginException("Du skal logge ind før du kan gå videre!", Level.INFO);
        }
        ArrayList<Part> listOfRoofBricks = LogicFacade.getAllRoofBricksAsList();
        request.getSession().setAttribute("RoofBricksList", listOfRoofBricks);
        return "CustomCarport";
    }

}
