package generics;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-29
 * Time: 下午8:58
 */
class HasColor {}

class Colored<T extends HasColor> {
    T item;
    Colored(T item) { this.item = item; }
    T getItem() { return this.item; }
}

public class BasicBounds {
}
