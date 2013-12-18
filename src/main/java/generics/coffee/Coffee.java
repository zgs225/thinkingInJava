package generics.coffee;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-18
 * Time: 下午9:05
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter ++;
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
