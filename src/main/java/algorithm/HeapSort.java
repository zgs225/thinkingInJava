package algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-5-15
 *         堆排序
 */
public class HeapSort {
    /**
     * find an element left child
     *
     * @param i the index of an item in the heap.
     * @return the index of the left child
     */
    private static int leftChild(int i) {
        return i * 2 + 1;
    }

    /**
     * 执行下滤
     *
     * @param a an array of comparable items
     * @param i the position from which to percolate down.
     * @param n the logical size of the binary heap
     */
    private static <AnyType extends Comparable<? super AnyType>>
    void percDown(AnyType[] a, int i, int n) {
        int child;
        AnyType tmp;

        for (tmp = a[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if (child != n - 1 && a[child].compareTo(a[child + 1]) < 0)
                child++;
            if (tmp.compareTo(a[child]) < 0)
                a[i] = a[child];
            else
                break;
        }
        a[i] = tmp;
    }

    /**
     * swap the element at position of m and n
     *
     * @param a an array of comparable items
     * @param m position to swap
     * @param n position to swap
     */
    private static <AnyType extends Comparable<? super AnyType>>
    void swapReferences(AnyType[] a, int m, int n) {
        AnyType tmp = a[m];
        a[m] = a[n];
        a[n] = tmp;
    }

    /**
     * Standard heap sort
     *
     * @param a an array of comparable items
     */
    public static <AnyType extends Comparable<? super AnyType>>
    void process(AnyType[] a) {
        // Build heap
        for (int i = a.length / 2; i >= 0; i--)
            percDown(a, i, a.length);
        for (int i = a.length - 1; i > 0; i--) {
            swapReferences(a, 0, i);
            percDown(a, 0, i);
        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[100000];
        Random rand = new Random();

        for (int i = 0; i < array.length; i++)
            array[i] = rand.nextInt(100000);
        System.out.println(Arrays.toString(array));
        process(array);
        System.out.println(Arrays.toString(array));
    }
}
