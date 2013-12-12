package typeinfo;

import utils.PrintUtil;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-12
 * Time: 下午8:59
 */
public class PrintSuperClass {
    static String name = "";

    public static void print(Class z) {
        if(z.getSuperclass() == null) {
            PrintUtil.print(z.getCanonicalName());
            return ;
        }
        PrintUtil.print(z.getCanonicalName());
        print(z.getSuperclass());
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class c = Class.forName("java.util.ArrayList");
        print(c);
    }
}
