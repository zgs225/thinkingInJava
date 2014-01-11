package utils;

import generics.Generator;

import java.util.ArrayList;

/**
 * Created by yuez on 14-1-11.
 * A collection filled with data using a generator object
 */
public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen, int quantity) {
        for(int i=0; i< quantity; i++)
            add(gen.next());
    }

    public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
        return  new CollectionData<T>(gen, quantity);
    }
}
