package generics;

import utils.PrintUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-29
 * Time: 下午8:25
 */
public class ClassTypeCapture<T> {
    Class<T> kind;
    Map<String, Class<?>> types = new HashMap<String, Class<?>>();

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object obj) {
        return kind.isInstance(obj);
    }

    public void addType(String typeName, Class<?> kind) {
        types.put(typeName, kind);
    }

    public Object createNew(String typeName) {
        Class kind = types.get(typeName);
        if(kind == null) return null;
        Object object = null;
        try {
            object = kind.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> cttl = new ClassTypeCapture<Building>(Building.class);
        PrintUtil.print(cttl.f(new Building()));
        PrintUtil.print(cttl.f(new House()));
    }
}

class Building {}

class House extends Building {}
