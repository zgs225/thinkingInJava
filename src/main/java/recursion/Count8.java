package recursion;

/**
 * User: yuez
 * Date: 13-12-9
 * Time: 下午8:51
 * Given a non-negative int n, compute recursively the count of occurrences
 * of 8 as a digit, except that an 8 with another 8 immediately to its left
 * counts double.
 */
public class Count8 {
    public static void main(String[] args) {

    }

    public static int count8(int n) {
        if(n / 10 != 0 && n % 10 == 8 && n % 100 / 10 == 8) return 2;
        if(n / 10 == 0 && n % 10 == 8) return 1;
        if(n / 10 == 0 && n % 10 != 8) return 0;
        return count8(n / 10) + count8(n % 10);
    }
}
