package algorithm;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-4-9
 *         求解最大子序列问题
 *         采用分治法解决这个问题
 *         计算最大左序列，最大右序列和最大左右序列之和
 *         并返回他们之间的最大值
 */
public class MaxSubSum {
    public static int maxSubSum(int[] a) {
        return maxSubSumRec(a, 0, a.length - 1);
    }

    private static int maxSubSumRec(int[] a, int left, int right) {
        if (left == right) { // 讨论只有一个数组元素的情况
            if (a[left] > 0)
                return a[left];
            else return 0;
        }

        int center = (left + right) / 2;
        int maxLeftSum = maxSubSumRec(a, left, center);
        int maxRightSum = maxSubSumRec(a, center + 1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += a[i];
            if (leftBorderSum > maxLeftBorderSum)
                maxLeftBorderSum = leftBorderSum;
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += a[i];
            if (rightBorderSum > maxRightBorderSum)
                maxRightBorderSum = rightBorderSum;
        }
        return max3(maxLeftSum, maxRightSum, maxRightBorderSum + maxLeftBorderSum);
    }

    private static int max3(int a, int b, int c) {
        if (a >= b && a >= c)
            return a;
        else if (b >= a && b >= c)
            return b;
        else if (c >= b && c >= a)
            return c;
        return a;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 4, -1, 5, 6, -3, 10, -2, 78, 35};
        System.out.println(maxSubSum(a));
    }
}
