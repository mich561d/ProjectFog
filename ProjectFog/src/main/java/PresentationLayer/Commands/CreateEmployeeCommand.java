package PresentationLayer.Commands;

import FunctionLayer.Enums.EmployeeRole;
import FunctionLayer.Exceptions.CarportCreationException;
import FunctionLayer.Exceptions.FogException;
import FunctionLayer.Exceptions.LoginException;
import FunctionLayer.Exceptions.RegisterException;
import FunctionLayer.LogicFacade;
import PresentationLayer.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael
 */
public class CreateEmployeeCommand  implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws FogException, RegisterException, LoginException, CarportCreationException {
        // Get data
        // User
        String email = request.getParameter("email");
        String pass1 = request.getParameter("password1");
        String pass2 = request.getParameter("password2");
        // Employee
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone");
        String workPhone = request.getParameter("workPhone");
        EmployeeRole role = EmployeeRole.valueOf(request.getParameter("role"));
        // Create employee
        LogicFacade.doEmailExist(email);
        LogicFacade.checkPasswords(pass1, pass2);
        int userID = LogicFacade.createUser(email, pass1);
        LogicFacade.createEmployee(firstName, lastName, phone, workPhone, role, userID);
        // Go on
        request.getSession().setAttribute("msg", "Den nye medarbejder er blevet oprettet i systemet korrekt!");
        return "EmployeePage";
    }
}
