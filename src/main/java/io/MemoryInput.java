package io;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by yuez on 14-1-18.
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(new BufferedInputFile().read("/Users/yuez/Development/Java/thinkingInJava/src/main/java/io/BufferedInputFile.java"));
        int c;
        while ((c = in.read()) != -1) {
            System.out.println((char) c);
        }
    }
}
