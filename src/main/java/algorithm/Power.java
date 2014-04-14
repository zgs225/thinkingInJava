package algorithm;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-4-10
 *         计算幂指数
 */
public class Power {
    public static long power(long m, int n) {
        if (n == 0)
            return 1;
        else if (even(n))
            return power(m * m, n / 2);
        else
            return power(m, n - 1) * m;
    }

    private static boolean even(long m) {
        return m % 2 == 0;
    }

    private static boolean odd(long m) {
        return !even(m);
    }

    public static void main(String[] args) {
        System.out.println(power(52, 14));
    }
}
