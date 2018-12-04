package PresentationLayer.Commands;

import FunctionLayer.Exceptions.FogException;
import PresentationLayer.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael
 */
public class CustomCarportCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        return "CustomCarport";
    }

}
