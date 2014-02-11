import java.util.Timer;
import java.util.TimerTask;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-2-4
 *         A test for timer class
 */
public class TestTimer {
    public static void main(String[] args) {
        long delay = 1000;
        long period = 5000;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello timer");
            }
        }, delay, period);
    }
}
