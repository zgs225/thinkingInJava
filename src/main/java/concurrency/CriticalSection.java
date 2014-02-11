package concurrency;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-2-11
 */
public class CriticalSection {
    static void testApproaches(PairManager pm1, PairManager pm2) {
        ExecutorService exec = Executors.newCachedThreadPool();
        PairManipultor
                pmt1 = new PairManipultor(pm1),
                pmt2 = new PairManipultor(pm2);
        PairChecker
                pck1 = new PairChecker(pm1),
                pck2 = new PairChecker(pm2);
        exec.execute(pmt1);
        exec.execute(pmt2);
        exec.execute(pck1);
        exec.execute(pck2);
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            PrintUtil.print("Sleeping interrupted");
        }
        System.out.println("pmt1: " + pmt1 + "\npmt2: " + pmt2);
        System.exit(0);
    }

    public static void main(String[] args) {
        PairManager
                pm1 = new PairManager1(),
                pm2 = new PairManager2();
        testApproaches(pm1, pm2);
    }
}

class Pair {
    private int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX() {
        x++;
    }

    public void incrementY() {
        y++;
    }

    public String toString() {
        return "x: " + x + ", y: " + y;
    }

    public class PairValuesNotEqualException extends RuntimeException {
        public PairValuesNotEqualException() {
            super("Pair value not equal: " + Pair.this);
        }
    }

    public void checkStatus() {
        if (x != y)
            throw new PairValuesNotEqualException();
    }
}

abstract class PairManager {
    AtomicInteger countChecker = new AtomicInteger(0);
    protected Pair p = new Pair();
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());

    public synchronized Pair getPair() {
        // 复制一份，以保护原始对象的安全
        return new Pair(p.getX(), p.getY());
    }

    protected void store(Pair p) {
        storage.add(p);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
        }
    }

    public abstract void increment();
}

class PairManager1 extends PairManager {

    @Override
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}

class PairManager2 extends PairManager {

    @Override
    public void increment() {
        Pair temp;
        synchronized (this) {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        }
        store(temp);
    }
}

class PairManipultor implements Runnable {
    private PairManager pm;

    PairManipultor(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true)
            pm.increment();
    }

    public String toString() {
        return "Pair: " + pm.getPair() +
                " checkCounter = " + pm.countChecker.get();
    }
}

class PairChecker implements Runnable {
    private PairManager pm;

    PairChecker(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true) {
            pm.countChecker.getAndIncrement();
            pm.getPair().checkStatus();
        }
    }
}
