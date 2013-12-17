package typeinfo;

import utils.PrintUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-17
 * Time: 下午10:06
 */
public class HiddenMethods {
    public void c() {
        PrintUtil.print("HiddenMethods c()");
    }

    protected void d() {
        PrintUtil.print("HiddenMethods d()");
    }

    private void e() {
        PrintUtil.print("HiddenMethods e()");
    }
}

class test {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        HiddenMethods hm = new HiddenMethods();
        Method method = HiddenMethods.class.getDeclaredMethod("e");
        method.setAccessible(true);
        method.invoke(hm);
    }
}
