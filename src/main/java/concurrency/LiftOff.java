package concurrency;

import utils.PrintUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-2-8
 */
public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "Lift off!") + ")";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            PrintUtil.print(status());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                PrintUtil.print("Interrupted");
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            service.execute(new LiftOff());
        service.shutdown();
    }
}
