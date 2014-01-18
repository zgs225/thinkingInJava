import utils.Directory;
import utils.PrettyPrint;
import utils.PrintUtil;

import java.io.File;

/**
 * Created by yuez on 14-1-16.
 */
public class DirectoryDemo {
    public static void main(String[] args) {
        PrettyPrint.pprint(Directory.walk(".").dirs);

        for (File item : Directory.local(".", "T.*"))
            PrintUtil.print(item);

        PrintUtil.print("========================");
        for (File item : Directory.walk(".", "T.*\\.java"))
            PrintUtil.print(item);
    }
}
