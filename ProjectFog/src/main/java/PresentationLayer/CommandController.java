package PresentationLayer;

import java.util.HashMap;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Michael
 */
public abstract class CommandController {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        //commands.put("name", new class());
    }

    static Command from(HttpServletRequest request) {
        String commandName = request.getParameter("command");
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand());
    }

}
