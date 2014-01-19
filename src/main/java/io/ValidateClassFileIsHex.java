package io;

import utils.BinaryFile;
import utils.PrintUtil;
import utils.ProcessFiles;

import java.io.File;

/**
 * Created by yuez on 14-1-19.
 * Validating class files is Hex file;
 */
public class ValidateClassFileIsHex {
    public static void main(String[] args) {
        new ProcessFiles(new ProcessFiles.Strategy() {
            @Override
            public void process(File file) {
                byte[] data = BinaryFile.read(file);
                if (data.length > 7) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < 8; i++)
                        sb.append(String.valueOf(data[i]).toUpperCase());
                    PrintUtil.print("Class file " + file.getName() + " is start with Hex string: " + sb.toString().equals("CAFEBABE"));
                }
            }
        }, ".*\\.class").start(args);
    }
}
