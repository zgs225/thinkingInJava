package utils;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by yuez on 14-1-16.
 * Pretty printer for containers
 */
public class PrettyPrint {
    public static String pformat(Collection<?> c) {
        if (c.size() == 0) return "[]";
        StringBuilder result = new StringBuilder("[");
        for (Object elem : c) {
            if (c.size() != 1)
                result.append("\n");
            result.append(elem);
        }
        if (c.size() != 1)
            result.append("\n");
        result.append("]");
        return result.toString();
    }

    public static void pprint(Collection<?> c) {
        System.out.println(pformat(c));
    }

    public static void pprint(Object[] c) {
        System.out.println(Arrays.asList(c));
    }
}
