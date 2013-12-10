package exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-10
 * Time: 下午8:06
 */
public class LoggingException extends Exception {
    private static Logger logger = Logger.getLogger(LoggingException.class.getName());

    public LoggingException() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
