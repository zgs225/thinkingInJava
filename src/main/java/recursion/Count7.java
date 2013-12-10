package recursion;

import utils.PrintUtil;

/**
 * User: yuez
 * Date: 13-12-9
 * Time: 下午8:18
 * Given a non-negative int n, return the count of the occurrences
 * of 7 as a digit.
 */
public class Count7 {
    public static void main(String[] args) {
        PrintUtil.print(Count7.count7(717));
    }

    public static int count7(int n) {
        if(n / 10 == 0 && n % 10 != 7) return 0;
        else if(n / 10 == 0 && n % 10 == 7) return 1;
        return count7(n / 10) + count7(n % 10);
    }
}
