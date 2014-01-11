package arrays;

import utils.PrintUtil;

import java.util.Arrays;

/**
 * Created by yuez on 14-1-11.
 */
public class ComparingArrays {
    int value;

    public ComparingArrays(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        ComparingArrays[] a1 = new ComparingArrays[10];
        ComparingArrays[] a2 = new ComparingArrays[10];
        Arrays.fill(a1, new ComparingArrays(10));
        Arrays.fill(a2, new ComparingArrays(10));
        PrintUtil.print(Arrays.equals(a1, a2));
    }
}
