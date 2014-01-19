package utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by yuez on 14-1-19.
 * Utility for reading files in binary form;
 */
public class BinaryFile {
    public static byte[] read(File bFile) {
        BufferedInputStream bf = null;
        try {
            bf = new BufferedInputStream(
                    new FileInputStream(bFile)
            );
            try {
                byte[] data = new byte[bf.available()];
                bf.read(data);
                return data;
            } finally {
                bf.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static byte[] read(String bFile) throws IOException {
        return read(new File(bFile));
    }
}
