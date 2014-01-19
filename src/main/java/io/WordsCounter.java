package io;

import utils.PrintUtil;
import utils.TextFile;

import java.util.HashMap;

/**
 * Created by yuez on 14-1-19.
 * Count number of a word appearance
 */
public class WordsCounter {
    public static void main(String[] args) {
        TextFile text = new TextFile("test.txt", "\\W+");
        HashMap<String, Integer> counter = new HashMap<String, Integer>();
        for (String item : text) {
            if (counter.containsKey(item))
                counter.put(item, counter.get(item) + 1);
            else
                counter.put(item, 1);
        }
        PrintUtil.print(counter);
    }
}
