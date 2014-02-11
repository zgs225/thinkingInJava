package concurrency;

import utils.PrintUtil;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-2-9
 */
public class DaemonDontRunFinally implements Runnable {
    @Override
    public void run() {
        try {
            PrintUtil.print("I'm a daemon.");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            PrintUtil.print("Thread shutdown.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new DaemonDontRunFinally());
        t.setDaemon(true);
        t.start();
        TimeUnit.MILLISECONDS.sleep(10);
    }
}
