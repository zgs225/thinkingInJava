package exception;

import utils.PrintUtil;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-10
 * Time: 下午7:59
 */
public class SimpleExceptionDemo {
    public static void main(String[] args) {
        try {
            throw new NullPointerException("你就是个空货");
        } catch(NullPointerException e) {
            e.printStackTrace();
        } finally {
            PrintUtil.print("Hello, exception, I'm going");
        }
    }
}
