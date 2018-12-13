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
        commands.put("Payment", new PaymentCommand());
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
        commands.put("EmployeePage", new EmployeePageCommand());
        commands.put("CreateEmployee", new CreateEmployeeCommand());
        commands.put("OrderPage", new OrderPageCommand());
        commands.put("SendOrder", new SendOrderCommand());
        commands.put("PartPage", new PartPageCommand());
        commands.put("CreatePart", new CreatePartCommand());
        commands.put("UploadMaterial", new UploadMaterialCommand());
        commands.put("DeletePart", new DeletePartCommand());
        commands.put("UpdatePart", new UpdatePartCommand());
        commands.put("UpdateMaterial", new UpdateMaterialCommand());
    }

    static Command from(HttpServletRequest request) {
        String commandName = request.getParameter("command");
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand());
    }

}
