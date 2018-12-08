package PresentationLayer;

import PresentationLayer.Commands.*;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Michael & Christian
 */
public abstract class CommandController {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("CustomCarport", new CustomCarportCommand());
        commands.put("ProductReview", new ProductReviewCommand());
        commands.put("Cart", new CartCommand());
        commands.put("Index", new IndexCommand());
        commands.put("Login", new LoginCommand());
        commands.put("Logout", new LogoutCommand());
        commands.put("Register", new RegisterCommand());
        commands.put("CreateCustomer", new CreateCustomerCommand());
        commands.put("CustomerPage", new CustomerPageCommand());
        commands.put("CustomerOrders", new CustomerOrdersCommand());
        commands.put("UpdateCustomerInformation", new UpdateCustomerInformationCommand());
        commands.put("UpdateCustomerEmail", new UpdateCustomerEmailCommand());
        commands.put("UpdateCustomerPassword", new UpdateCustomerPasswordCommand());
    }

    static Command from(HttpServletRequest request) {
        String commandName = request.getParameter("command");
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand());
    }

}
