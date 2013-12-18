package generics.coffee;

import generics.Generator;
import utils.PrintUtil;

import java.util.Iterator;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-18
 * Time: 下午9:12
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private Class[] types = { Americano.class, Breve.class, Coffee.class, Latte.class, Mocha.class };
    private static Random random = new Random(23);

    public CoffeeGenerator() {}

    private int size = 0;

    public CoffeeGenerator(int size) { this.size = size; }

    @Override
    public Coffee next() {
        try {
            return (Coffee) types[random.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for(int i=0; i<5; i++)
            PrintUtil.print(gen.next());
        for(Coffee c : new CoffeeGenerator(5))
            PrintUtil.print(c);
    }

    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count --;
            return CoffeeGenerator.this.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
