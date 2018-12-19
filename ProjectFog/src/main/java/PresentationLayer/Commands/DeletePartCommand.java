package PresentationLayer.Commands;

import FunctionLayer.Entities.Part;
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
public class DeletePartCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, RegisterException, LoginException, CarportCreationException {
        int partID = Integer.parseInt(request.getParameter("partID"));
        LogicFacade.deletePart(partID);
        ArrayList<Part> parts = LogicFacade.getAllParts();
        request.getSession().setAttribute("AllParts", parts);
        request.getSession().setAttribute("msg", "Der er blevet fjernet et materiale fra databasen!");
        return "PartPage";
    }

}
