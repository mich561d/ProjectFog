package PresentationLayer.Commands;

import FunctionLayer.Exceptions.FogException;
import PresentationLayer.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael & Christian
 */
public class UnknownCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        throw new FogException("404 - Siden du ledte efter kunne ikke findes!");
    }
}
