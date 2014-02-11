package concurrency;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-2-10
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
