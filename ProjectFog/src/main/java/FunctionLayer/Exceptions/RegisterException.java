package FunctionLayer.Exceptions;

import java.util.logging.Level;

/**
 *
 * @author Michael & Christian
 */
public class RegisterException extends Exception {

    public final Level LEVEL;

    public RegisterException(String msg) {
        this(msg, Level.OFF);
    }

    public RegisterException(String msg, Level level) {
        super(msg);
        this.LEVEL = level;
    }

}
