package utils;

import java.io.File;
import java.io.IOException;

/**
 * Created by yuez on 14-1-18.
 */
public class ProcessFiles {
    public interface Strategy {
        void process(File file);
    }

    private Strategy strategy;
    private String regex;

    public ProcessFiles(Strategy strategy, String regex) {
        this.strategy = strategy;
        this.regex = regex;
    }

    public void start(String[] args) {
        if (args.length == 0)
            processDirectoryTree(new File("."));
        else
            for (String arg : args) {
                File file = new File(arg);
                if (file.isDirectory())
                    processDirectoryTree(file);
                else {
                    try {
                        strategy.process(new File(arg).getCanonicalFile());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
    }

    public void processDirectoryTree(File root) {
        for (File file : Directory.walk(root.getAbsolutePath(), regex))
            strategy.process(file);
    }

    public static void main(String[] args) {
        new ProcessFiles(new Strategy() {
            @Override
            public void process(File file) {
                PrintUtil.print(file);
            }
        }, ".*\\.java").start(args);
    }
}
