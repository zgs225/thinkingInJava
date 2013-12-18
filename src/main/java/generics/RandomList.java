package generics;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-18
 * Time: 下午8:56
 */
public class RandomList<T> {
    private ArrayList<T> storage = new ArrayList<T>();
    private Random random = new Random(27);

    public void add(T item) { storage.add(item); }

    public T select() {
        return storage.get(random.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> rls = new RandomList<String>();
        RandomList<Integer> rli = new RandomList<Integer>();
        for(String s : "What is the girl say?".split(" "))
            rls.add(s);
        for(Integer i : new int[] {1, 2, 3, 4, 5})
            rli.add(i);
        for(int i=0; i<10; i++) {
            PrintUtil.print(rls.select());
            PrintUtil.print(rli.select());
        }
    }
}
