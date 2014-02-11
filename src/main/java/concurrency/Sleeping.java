package concurrency;

import utils.PrintUtil;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-2-9
 */
public class Sleeping implements Runnable {
    private int id;
    Random random = new Random();

    public Sleeping(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        final long SLEEP_TIME = random.nextInt(10);
        PrintUtil.print("#" + id + " thread sleeping " + SLEEP_TIME + " seconds.");
        try {
            TimeUnit.SECONDS.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            PrintUtil.print("Interrupted");
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++)
            exec.execute(new Sleeping(i));
        exec.shutdown();
    }
}
