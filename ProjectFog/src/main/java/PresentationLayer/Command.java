package PresentationLayer;

import FunctionLayer.Exceptions.FogException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael
 */
public interface Command {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws FogException;

}
