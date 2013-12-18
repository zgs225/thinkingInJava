package generics;

import utils.PrintUtil;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-18
 * Time: 下午9:56
 */
public class GenericMethods {
    public <T> void f(T x, T y, String z) {
        PrintUtil.print(x.getClass().getName() + " " + y.getClass().getName() + " " + z.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("", 1, "1");
    }
}
