package concurrency;

import utils.DaemonThreadFactory;
import utils.PrintUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-2-9
 */
public class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            PrintUtil.print("Interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++)
            exec.execute(new SimpleDaemons()); // 这里不需要调用exec.shutdown()吗？
        PrintUtil.print("All daemons started");
        TimeUnit.MILLISECONDS.sleep(2000);
    }
}
