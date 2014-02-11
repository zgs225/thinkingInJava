package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-2-7
 *         注解的声明很像一个空借口的定义
 */
@Target(ElementType.METHOD)  // 定义了这个注解的使用范围，是在方法上还是在域上等等
@Retention(RetentionPolicy.RUNTIME)  //  定义了注解使用级别，有SOURCE, CLASS 和 RUNTIME
public @interface Test {
}
