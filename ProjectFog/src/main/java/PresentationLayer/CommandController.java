package PresentationLayer;

import PresentationLayer.Commands.CustomCarportCommand;
import PresentationLayer.Commands.UnknownCommand;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Michael
 */
public abstract class CommandController {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("Calculator", new CustomCarportCommand());
    }

    static Command from(HttpServletRequest request) {
        String commandName = request.getParameter("command");
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand());
    }

}
