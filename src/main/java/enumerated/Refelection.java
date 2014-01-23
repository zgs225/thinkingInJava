package enumerated;

import utils.PrintUtil;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by yuez on 14-1-23.
 * Analyzing enums using reflection
 */
enum Explore {
    HERE, THERE
}

public class Refelection {
    public static Set<String> analyze(Class<?> enumType) {
        PrintUtil.print("----- Analyzing " + enumType + " -----");
        PrintUtil.print("Interfaces: ");
        for (Type t : enumType.getGenericInterfaces())
            PrintUtil.print(t);
        PrintUtil.print("Base: " + enumType.getSuperclass());
        PrintUtil.print("Methods: ");
        Set<String> methods = new TreeSet<String>();
        for (Method m : enumType.getMethods())
            methods.add(m.getName());
        System.out.println(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        PrintUtil.print("Explore.containsAll(Enum)? " + exploreMethods.containsAll(enumMethods));
        exploreMethods.removeAll(enumMethods);
    }
}
