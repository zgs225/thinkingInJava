package utils;

import java.util.concurrent.ThreadFactory;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-2-9
 *         Use executor create a daemon thread
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
