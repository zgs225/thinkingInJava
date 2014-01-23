package io;

import utils.PrintUtil;

import java.io.*;

/**
 * Created by yuez on 14-1-20.
 * Redirecting standard input, output and error put
 */
public class Redirecting {
    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(
                new FileInputStream(new File("src/main/java/io/Redirecting.java"))
        );
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("Redirecting.out")));
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = reader.readLine()) != null)
            PrintUtil.print(s);
        out.close();
        System.setOut(console);
        System.setErr(console);
    }
}
