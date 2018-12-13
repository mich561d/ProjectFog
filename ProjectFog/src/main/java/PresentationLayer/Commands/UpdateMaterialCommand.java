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
public class UpdateMaterialCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, RegisterException, LoginException, CarportCreationException {
        int id = Integer.parseInt(request.getParameter("partID"));
        String type = request.getParameter("type");
        String material = request.getParameter("material");
        String size = request.getParameter("size");
        String description = request.getParameter("description");
        String s_price = request.getParameter("price").replace(",", "."); // To secure correct formatting
        double price = Double.parseDouble(s_price);
        String brand = request.getParameter("brand");
        LogicFacade.updatePart(id, type, material, size, description, price, brand);
        ArrayList<Part> parts = LogicFacade.getAllParts();
        request.getSession().setAttribute("AllParts", parts);
        request.getSession().setAttribute("msg", "Der er blevet ændret et materiale fra databasen!");
        return "PartPage";
    }

}
