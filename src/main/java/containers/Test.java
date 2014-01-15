package containers;

/**
 * Created by yuez on 14-1-14.
 * Framework for performing timed test of containers
 */
public abstract class Test<C> {
    String name;

    public Test(String name) {
        this.name = name;
    }

    abstract int test(C container, TestParam tp);
}
