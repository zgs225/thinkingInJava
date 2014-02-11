package concurrency;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-2-9
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(); // 通常情况下，Cached Thread Pool都是首选
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++)
            results.add(exec.submit(new TaskWithResult(i)));
        for (Future<String> future : results)
            try {
                PrintUtil.print(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                exec.shutdown();
            }
    }
}

class TaskWithResult implements Callable<String> {
    private int id;

    TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "Task with result #" + id;
    }
}
