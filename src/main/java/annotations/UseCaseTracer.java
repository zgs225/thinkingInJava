package annotations;

import utils.PrintUtil;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-2-7
 */
public class UseCaseTracer {
    public static void trackUseCase(List<Integer> ids, Class<?> clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            UseCase uc = method.getAnnotation(UseCase.class);
            if (uc != null) {
                PrintUtil.print("Find UseCase " + uc.id() + " " + uc.description());
                ids.remove(new Integer(uc.id()));
            }
        }
        for (int id : ids)
            PrintUtil.print("Warning: missing use case-" + id);
    }

    public static void main(String[] args) {
        List<Integer> ids = new ArrayList<Integer>();
        Collections.addAll(ids, 1, 2, 3, 4, 5);
        trackUseCase(ids, PasswordUtils.class);
    }
}
