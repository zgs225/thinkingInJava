package typeinfo;

import utils.PrintUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-15
 * Time: 下午9:14
 */
public class ShowMethods {
    private static String usage =
            "usage:\n" +
            "ShowMethods Qualified.class.name\n" +
            "To show all methods in class or:\n" +
            "To search ofr methods involving 'word'";
    private static Pattern p = Pattern.compile("\\w+\\.");
    public static void main(String[] args) {
        if(args.length < 1) {
            PrintUtil.print(usage);
            System.exit(0);
        }
        int lines = 0;
        try {
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor[] constructors = c.getConstructors();
            if(args.length == 1) {
                for(Method method : methods)
                    PrintUtil.print(p.matcher(method.toString()).replaceAll(""));
                for(Constructor ctor : constructors)
                    PrintUtil.print(p.matcher(ctor.toString()).replaceAll(""));
            } else {
                for(Method method : methods)
                    if(method.toString().contains(args[1])) {
                        PrintUtil.print(p.matcher(method.toString()).replaceAll(""));
                        lines ++;
                    }
                for(Constructor ctor : constructors)
                    if(ctor.toString().contains(args[1])) {
                        PrintUtil.print(p.matcher(ctor.toString()).replaceAll(""));
                        lines ++;
                    }
            }
        } catch (ClassNotFoundException e) {
            PrintUtil.print("No such class: " + e);
        }
    }
}
