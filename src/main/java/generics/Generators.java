package generics;

import generics.coffee.Coffee;
import generics.coffee.CoffeeGenerator;
import utils.PrintUtil;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-19
 * Time: 下午8:29
 */
public class Generators {
    public static <T>Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        for(int i=0; i<n; i++)
            coll.add(gen.next());
        return coll;
    }

    public static void main(String[] args) {
        Collection<Coffee> coffees = fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 5);
        for(Coffee c : coffees)
            PrintUtil.print(c);
    }
}
