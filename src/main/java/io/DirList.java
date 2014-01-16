package io;

import utils.PrintUtil;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by yuez on 14-1-15.
 * Display a directory listing using regular expressions
 */
public class DirList {
    public static long SIZE = 0;
    public static long FILE_COUNT = 0;
    public static long DIR_COUNT = 0;

    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0)
            list = path.list();
        else
            list = path.list(new DirFilter(args[0]));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        evalSize(path);
        PrintUtil.print("Total files size: " + SIZE);
        PrintUtil.print("Total file counts: " + FILE_COUNT);
        PrintUtil.print("Total directory counts: " + DIR_COUNT);
    }

    public static void evalSize(File f) {
        if (!f.isDirectory()) {
            SIZE += f.length();
            PrintUtil.print(f.getName());
            FILE_COUNT++;
        } else {
            DIR_COUNT++;
            for (File file : f.listFiles())
                evalSize(file);
        }
    }
}

class DirFilter implements FilenameFilter {
    private Pattern pattern;

    DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
