package FunctionLayer.Exceptions;

import java.util.logging.Level;

/**
 *
 * @author Michael
 */
public class FogException extends Exception {

    public final Level LEVEL;

    public FogException(String msg) {
        this(msg, Level.OFF);
    }

    public FogException(String msg, Level level) {
        super(msg);
        this.LEVEL = level;
    }

}
