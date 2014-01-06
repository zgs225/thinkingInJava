import utils.PrintUtil;

import java.util.Arrays;

/**
 * Created by yuez on 14-1-6.
 * System.arraycopy() example
 */
public class CopyingArrays {
    public static void main(String[] args) {
        int[] i = new int[7];
        int[] j = new int[10];
        Arrays.fill(i, 47);
        Arrays.fill(j, 99);
        System.arraycopy(i, 0, j, 0, i.length);
        PrintUtil.print("j = " + Arrays.toString(j));

        // System.arraycopy don't support autoboxing
    }
}
