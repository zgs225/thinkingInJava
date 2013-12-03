package utils;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-3
 * Time: 下午8:59
 * 封装println
 */
public class PrintUtil {
    public static void print(String s) {
        System.out.println(s);
    }

    public static void print(Collection c) {
        System.out.println(c);
    }

    public static void print(Object o) {
        System.out.println(o);
    }
}
