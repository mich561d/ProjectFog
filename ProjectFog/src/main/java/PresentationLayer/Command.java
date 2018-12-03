package PresentationLayer;

import FunctionLayer.Exceptions.FogException;
import FunctionLayer.Exceptions.LoginException;
import FunctionLayer.Exceptions.RegisterException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael
 */
public interface Command {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, RegisterException, LoginException;

}
