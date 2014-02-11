package concurrency;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-2-11
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;

    public synchronized static int nextSerial() {
        return serialNumber++;
    }
}
