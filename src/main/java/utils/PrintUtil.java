package utils;

import java.util.Collection;
import java.util.Map;

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

    public static void print(Boolean b) {
        System.out.println(b);
    }

    public static void print(Double d) {
        System.out.println(d);
    }

    public static void print(int i) {
        System.out.println(i);
    }

    public static void print() {
        System.out.println();
    }

    public static void print(Character c) {
        System.out.println(c);
    }

    public static void print(Map map) {
        System.out.println(map);
    }
}
