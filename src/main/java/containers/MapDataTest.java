package containers;

import generics.Generator;
import utils.MapData;
import utils.Pair;
import utils.PrintUtil;

import java.util.Iterator;

/**
 * Created by yuez on 14-1-11.
 *
 */
public class MapDataTest {
    public static void main(String[] args) {
        PrintUtil.print(MapData.map(new Letters(), 11));
    }
}

class Letters implements Generator<Pair<Integer, String>>, Iterable<Integer> {
    private int size = 9;
    private int number = 1;
    private char letter = 'A';

    @Override
    public Pair<Integer, String> next() {
        return new Pair<Integer, String>(number++, "" + letter++);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return number < size;
            }

            @Override
            public Integer next() {
                return number++;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
