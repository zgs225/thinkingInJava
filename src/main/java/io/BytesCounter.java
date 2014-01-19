package io;

import utils.BinaryFile;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by yuez on 14-1-19.
 * Count number of a byte appearance;
 */
public class BytesCounter {
    public static void main(String[] args) throws IOException {
        byte[] data = BinaryFile.read("test.txt");
        HashMap<Byte, Integer> counter = new HashMap<Byte, Integer>();
        for (byte b : data) {
            if (counter.containsKey(b))
                counter.put(b, counter.get(b) + 1);
            else
                counter.put(b, 1);
        }
        System.out.println(counter);
    }
}
