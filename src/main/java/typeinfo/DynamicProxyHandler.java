package typeinfo;

import utils.PrintUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-15
 * Time: 下午9:45
 */
public class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PrintUtil.print("**** proxy: " + proxy.getClass() + ", method: " + method + ", args: " + Arrays.toString(args));
        if(args != null)
            for(Object arg : args)
                PrintUtil.print(" " + arg);
        return method.invoke(proxied, args);
    }
}

class RealObject implements Interface {

    @Override
    public void doSomething() {
        PrintUtil.print("do something");
    }

    @Override
    public void somethingElse(String arg) {
        PrintUtil.print("somethingElse " + arg);
    }
}

class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consumer(realObject);
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicProxyHandler(realObject));
        consumer(proxy);
    }
}

