package exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-10
 * Time: 下午8:19
 */
public class LoggingException2 extends Exception {
    private static Logger logger = Logger.getLogger(LoggingException2.class.getName());
    public LoggingException2() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    public static void main(String[] args) {
        try {
            throw new LoggingException2();
        } catch (LoggingException2 loggingException2) {
            System.err.println(loggingException2);
        }
    }
}
