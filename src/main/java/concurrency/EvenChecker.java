package concurrency;

import utils.PrintUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-2-10
 */
public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;

    public EvenChecker(int id, IntGenerator generator) {
        this.id = id;
        this.generator = generator;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            if (val % 2 != 0) {
                PrintUtil.print(val + " not even.");
                generator.cancel();
            }
        }
    }

    public static void test(IntGenerator gp, int count) {
        PrintUtil.print("Press Ctrl + c to exit.");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++)
            exec.execute(new EvenChecker(i, gp));
        exec.shutdown();
    }

    public static void test(IntGenerator gp) {
        test(gp, 10);
    }
}
