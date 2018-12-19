package PresentationLayer.Commands;

import PresentationLayer.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael & Christian
 */
public class LogoutCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("CustomerID", null);
        request.getSession().setAttribute("EmployeeID", null);
        return "index";
    }

}
