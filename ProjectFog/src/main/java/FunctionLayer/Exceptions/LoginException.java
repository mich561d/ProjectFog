package FunctionLayer.Exceptions;

import java.util.logging.Level;

/**
 *
 * @author Michael
 */
public class LoginException extends Exception {

    public final Level LEVEL;

    public LoginException(String msg) {
        this(msg, Level.OFF);
    }

    public LoginException(String msg, Level level) {
        super(msg);
        this.LEVEL = level;
    }
}
