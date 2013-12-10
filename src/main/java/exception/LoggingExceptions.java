package exception;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-10
 * Time: 下午8:06
 */
public class LoggingExceptions {
    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught: " + e);
        }
    }
}
