package io;

import utils.PrintUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by yuez on 14-1-18.
 */
public class BufferedInputFile {
    public static String read(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null)
            sb.append(s).append("\n");
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            PrintUtil.print(read("BufferedInputFile.java"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
