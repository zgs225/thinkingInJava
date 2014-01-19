package io;

import utils.PrintUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * Created by yuez on 14-1-19.
 */
public class FileOutputShortcut {
    static String file = "FileOutputShortcut.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(BufferedInputFile.read("src/main/java/io/FileOutputShortcut.java"))
        );
        PrintWriter out = new PrintWriter(file);
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null)
            out.println(lineCount++ + ": " + s);
        out.close();
        PrintUtil.print(BufferedInputFile.read(file));
    }
}
