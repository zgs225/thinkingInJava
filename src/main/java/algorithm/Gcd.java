package algorithm;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-4-10
 *         计算最大公约数
 */
public class Gcd {
    public static long gcd(long m, long n) {
        while (n != 0) {
            long rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }

    public static void main(String[] args) {
        System.out.println(gcd(873213, 2454));
    }
}
