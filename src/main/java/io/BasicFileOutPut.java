package io;

import java.io.*;

/**
 * Created by yuez on 14-1-19.
 */
public class BasicFileOutPut {
    static String file = "BasicFileOutput.out";

    public static void main(String[] args) throws IOException {
        LineNumberReader in = new LineNumberReader(new StringReader(BufferedInputFile.read("src/main/java/io/BasicFileOutPut.java")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        String s;
        while ((s = in.readLine()) != null)
            out.println(in.getLineNumber() + ": " + s);
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
