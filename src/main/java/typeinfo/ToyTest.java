package typeinfo;

import utils.PrintUtil;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-12
 * Time: 下午8:33
 */
public class ToyTest {
    static void printInfo(Class cc) {
        PrintUtil.print("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        PrintUtil.print("Simple name: " + cc.getSimpleName());
        PrintUtil.print("Canonical name: " + cc.getCanonicalName());
    }

    public static void main(String [] args) {
        Class c = null;
        try {
            c = Class.forName("typeinfo.FancyToy");
        } catch (ClassNotFoundException e) {
            PrintUtil.print("Can't load class");
            System.exit(-1);
        }
        printInfo(c);
        for(Class face : c.getInterfaces()) {
            printInfo(face);
        }
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            obj = up.newInstance();
        } catch (InstantiationException e) {
            PrintUtil.print("can't instance");
            System.exit(-1);
        } catch (IllegalAccessException e) {
            PrintUtil.print("can't access");
            System.exit(-1);
        }
        printInfo(obj.getClass());
    }
}

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
    Toy() {}
    Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy() {
        super(1);
    }
}
