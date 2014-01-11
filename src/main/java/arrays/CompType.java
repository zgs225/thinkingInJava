package arrays;

import generics.Generator;
import utils.PrintUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Created by yuez on 14-1-11.
 */
public class CompType implements Comparable<CompType> {
    int i;
    int j;
    private static int count = 1;

    public CompType(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        String result = "[i = " + i + ", j = " + j + "]";
        if (count++ % 3 == 0)
            result += "\n";
        return result;
    }

    @Override
    public int compareTo(CompType compType) {
        return (i < compType.i ? -1 : (i == compType.i ? 0 : 1));
    }

    public static Random r = new Random();

    public static Generator<CompType> generator() {
        return new Generator<CompType>() {
            @Override
            public CompType next() {
                return new CompType(r.nextInt(100), r.nextInt(100));
            }
        };
    }

    public static void main(String[] args) {
        CompType[] a = new CompType[12];
        for (int i = 0; i < 12; i++)
            a[i] = generator().next();

        PrintUtil.print("Before sorting: ");
        PrintUtil.print(Arrays.toString(a));
        Arrays.sort(a, Collections.reverseOrder());
        PrintUtil.print("After sorting: ");
        PrintUtil.print(Arrays.toString(a));
    }
}
