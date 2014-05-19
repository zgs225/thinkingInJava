package algorithm;

import utils.PrettyPrint;

import java.util.Random;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-5-19
 *         归并排序, 这是一种典型的分治算法
 *         也是对递归调用非常好运用方式
 */
public class MergeSort {
    /**
     * 归并排序驱动
     *
     * @param a an array of comparable items
     */
    public static <AnyType extends Comparable<? super AnyType>>
    void sort(AnyType[] a) {
        // 数组无法进行类型安全的转换
        AnyType[] tmpArray = (AnyType[]) new Comparable[a.length];
        mergeSort(a, tmpArray, 0, a.length - 1);
    }

    /**
     * 归并排序算法分的部分，也是运用递归的一部分
     *
     * @param a        an array of comparable items
     * @param tmpArray an tmp array for store items
     * @param left     left boundary
     * @param right    right boundary
     */
    private static <AnyType extends Comparable<? super AnyType>>
    void mergeSort(AnyType[] a, AnyType[] tmpArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmpArray, left, center);
            mergeSort(a, tmpArray, center + 1, right);
            merge(a, tmpArray, left, center + 1, right);
        }
    }

    /**
     * 归并排序算法治的部分，一个数组的前后两个部分
     * 排序，并且合并成一个新的数组
     */
    private static <AnyType extends Comparable<? super AnyType>>
    void merge(AnyType[] a, AnyType[] tmpArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int elementsNumber = rightEnd - leftPos + 1;
        int tmpPos = leftPos;

        // Main loop
        while (leftPos <= leftEnd && rightPos <= rightEnd)
            if (a[leftPos].compareTo(a[rightPos]) <= 0)
                tmpArray[tmpPos++] = a[leftPos++];
            else
                tmpArray[tmpPos++] = a[rightPos++];

        // Copy rest of left half
        while (leftPos <= leftEnd)
            tmpArray[tmpPos++] = a[leftPos++];

        // Copy rest of right half
        while (rightPos <= rightEnd)
            tmpArray[tmpPos++] = a[rightPos++];

        // Copy tmp array back
        for (int i = 0; i < elementsNumber; i++, rightEnd--)
            a[rightEnd] = tmpArray[rightEnd];
    }

    public static void main(String[] args) {
        int length = 200000; // 20w
        Integer[] a = new Integer[length];
        Random rand = new Random();
        for (int i = 0; i < length; i++)
            a[i] = rand.nextInt(length);
        sort(a);
        PrettyPrint.pprint(a);
    }
}
