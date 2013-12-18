package generics;

import utils.PrintUtil;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-18
 * Time: 下午9:40
 */
public class IterableFibonacci implements Generator<Integer>, Iterable<Integer> {
    private int count = 0;

    public IterableFibonacci() {}

    public IterableFibonacci(int count) {
        this.count = count;
    }

    @Override
    public Integer next() {
        count ++;
        return fib(count);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int n = count;
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n --;
                return IterableFibonacci.this.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private int fib(int n) {
        if(n < 2) return 1;
        return fib(n-2) + fib(n-1);
    }

    public static void main(String[] args) {
        for(int i : new IterableFibonacci(10))
            PrintUtil.print(i);
    }
}
