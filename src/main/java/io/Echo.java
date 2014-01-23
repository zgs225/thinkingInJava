package io;

import utils.PrintUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yuez on 14-1-20.
 * Read from standard input;
 */
public class Echo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = reader.readLine()) != null && s.length() != 0) {
            PrintUtil.print(s);
        }
    }
}
