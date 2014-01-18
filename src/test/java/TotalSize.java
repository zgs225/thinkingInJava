import utils.Directory;
import utils.PrintUtil;

import java.io.File;

/**
 * Created by yuez on 14-1-18.
 * Calculate files size
 */
public class TotalSize {
    long size = 0l;

    public void culculate(File file, String regex) {
        if (!file.isDirectory())
            size += file.length();
        else
            for (File f : Directory.walk(file, regex))
                culculate(f, regex);
    }

    public static void main(String[] args) {
        TotalSize totalSize = new TotalSize();
        totalSize.culculate(new File("."), ".*\\.java");
        PrintUtil.print(totalSize.size);
    }
}
