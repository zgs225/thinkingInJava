package annotations.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-2-7
 *         使用apt工具处理这个注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)  // 因为apt只分析源码所以通常情况下只需要使用SOURCE
public @interface ExtractInterface {
    public String value();
}
