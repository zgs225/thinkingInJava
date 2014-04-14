package algorithm;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-4-10
 *         计算最大子序列问题，消耗的运行时间为线性的
 */
public class MaxSubSumLinear {
    public static int maxSubSum(int[] a) {
        int maxSum = 0, thisSum = 0;

        for (int anA : a) {
            thisSum += anA;
            if (thisSum > maxSum)
                maxSum = thisSum;
            else if (thisSum < 0)
                thisSum = 0;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 4, -1, 5, 6, -3, 10, -2, 78, 35};
        System.out.println(maxSubSum(a));
    }
}
