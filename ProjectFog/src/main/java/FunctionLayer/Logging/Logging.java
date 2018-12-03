/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer.Logging;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author adamlass
 */
public class Logging {

    private static final Logger LOGGER = Logger.getLogger(Logger.class.getName());

    public void write(Level level, String message) throws IOException {
        addHandlers();
        LOGGER.log(level, message);

        Handler[] handlers = LOGGER.getHandlers();
        for (Handler handler : handlers) {
            handler.close();
        }
    }

    public void addHandlers() throws IOException {

        String path = LogConfig.DEVLOGFILEPATH;

        if (new File(LogConfig.LOGFILEPATH).exists()) {
            path = LogConfig.LOGFILEPATH;
        }
        FileHandler handler = new FileHandler(path, true);

        handler.setFormatter(new SimpleFormatter());
        LOGGER.addHandler(handler);
    }

}
