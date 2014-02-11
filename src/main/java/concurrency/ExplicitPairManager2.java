package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-2-11
 *         Not thread-safe
 */
public class ExplicitPairManager2 extends PairManager {
    private Lock lock = new ReentrantLock();

    @Override
    public void increment() {
        Pair temp;
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        } finally {
            lock.unlock();
        }
        store(temp);
    }

    public static void main(String[] args) {
        PairManager
                pm = new PairManager2(),
                epm = new ExplicitPairManager2();
        CriticalSection.testApproaches(pm, epm);
    }
}
