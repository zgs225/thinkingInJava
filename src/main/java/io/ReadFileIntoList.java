package io;

import utils.PrettyPrint;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by yuez on 14-1-18.
 */
public class ReadFileIntoList {
    public static LinkedList<String> read(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        LinkedList<String> result = new LinkedList<String>();
        String s;
        while ((s = in.readLine()) != null)
            result.add(s);
        return result;
    }

    public static void main(String[] args) throws IOException {
        LinkedList<String> source = read("/Users/yuez/Development/Java/thinkingInJava/src/main/java/io/BufferedInputFile.java");
        if (args.length == 0)
            PrettyPrint.pprint(source);
        else {
            LinkedList<String> result = new LinkedList<String>();
            String filter = args[0];
            for (String s : source)
                if (s.contains(filter))
                    result.add(s);
            PrettyPrint.pprint(result);
        }
    }
}
