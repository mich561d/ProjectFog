package PresentationLayer.Commands;

import FunctionLayer.FogException;
import PresentationLayer.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael
 */
public class IndexCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        return "index";
    }
    
}
