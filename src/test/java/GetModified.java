import utils.PrintUtil;
import utils.ProcessFiles;

import java.io.File;
import java.util.Date;

/**
 * Created by yuez on 14-1-18.
 *
 */
public class GetModified {
    public static void main(String[] args) {
        new ProcessFiles(new ProcessFiles.Strategy() {
            @Override
            public void process(File file) {
                Date modified = new Date(file.lastModified());
                if (modified.getTime() > System.currentTimeMillis() - 24 * 3600 * 1000 * 2)
                    PrintUtil.print(file);
            }
        }, ".*\\.java").start(args);
    }
}
