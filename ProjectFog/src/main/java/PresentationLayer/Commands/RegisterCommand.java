package PresentationLayer.Commands;

import FunctionLayer.Exceptions.FogException;
import FunctionLayer.Exceptions.RegisterException;
import FunctionLayer.LogicFacade;
import PresentationLayer.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael & Christian
 */
public class RegisterCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, RegisterException {
        String email = request.getParameter("email");
        String pass1 = request.getParameter("password1");
        String pass2 = request.getParameter("password2");
        LogicFacade.doEmailExist(email);          // Exception = Stop - No Exception = Go On!
        LogicFacade.checkPasswords(pass1, pass2);
        request.getSession().setAttribute("RegisterEmail", email);
        request.getSession().setAttribute("RegisterPassword", pass1);
        return "UserCreationSchema";
    }

}
