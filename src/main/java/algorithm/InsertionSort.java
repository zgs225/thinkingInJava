package algorithm;

import generics.Generator;
import utils.CollectionData;
import utils.PrettyPrint;

import java.util.Random;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-5-13
 *         一些插入排序的实现
 */
public class InsertionSort {
    /**
     * 一种希尔排序，使用希尔默认的增量数列
     *
     * @param a an array of comparable
     */
    public static <AnyType extends Comparable<? super AnyType>> void shellsort(AnyType[] a) {
        int j;

        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < a.length; i++) {
                AnyType tmp = a[i];
                for (j = i; j >= gap && tmp.compareTo(a[j - gap]) < 0; j -= gap)
                    a[j] = a[j - gap];
                a[j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        CollectionData<Integer> theList = new CollectionData<Integer>(new Generator<Integer>() {
            Random rand = new Random();

            @Override
            public Integer next() {
                return rand.nextInt(100000);
            }
        }, 20000);
        Integer[] array = theList.toArray(new Integer[20000]);
        PrettyPrint.pprint(array);
        System.out.println("=================");
        shellsort(array);
        PrettyPrint.pprint(theList.toArray());
    }
}
