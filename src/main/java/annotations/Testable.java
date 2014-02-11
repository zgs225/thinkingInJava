package annotations;

import utils.PrintUtil;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-2-7
 */
public class Testable {
    public void execute() {
        PrintUtil.print("hello world");
    }

    // 注解的使用方法和public, static等关键字的使用并无区别
    @Test
    void testExecute() {
        execute();
    }
}
