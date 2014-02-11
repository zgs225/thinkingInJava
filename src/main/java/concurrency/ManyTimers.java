package concurrency;

import utils.PrintUtil;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-2-11
 */
public class ManyTimers implements Runnable {
    private static volatile int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    PrintUtil.print("I'm timer #" + count++);
                }
            }, i * 100);
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++)
            exec.execute(new ManyTimers());
        exec.shutdown();
        PrintUtil.print("There are many timer tasks will be executed.");
    }
}
