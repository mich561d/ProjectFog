/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer.Exceptions;

import java.util.logging.Level;

/**
 *
 * @author Michael & Christian
 */
public class CarportCreationException extends Exception {

    public final Level LEVEL;

    public CarportCreationException(String msg) {
        this(msg, Level.OFF);
    }

    public CarportCreationException(String msg, Level level) {
        super(msg);
        this.LEVEL = level;
    }
}
