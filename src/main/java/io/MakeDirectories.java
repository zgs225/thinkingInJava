package io;

import utils.PrintUtil;

import java.io.File;

/**
 * Created by yuez on 14-1-18.
 * create and manipulate
 */
public class MakeDirectories {
    private static void usage() {
        System.err.println(
                "Usage: MakeDirectories path1 ... \n" +
                        "Creates each path\n" +
                        "Usage: MakeDirectories -d path1 ... \n" +
                        "Deletes each path\n" +
                        "Usage: MakeDirectories -r path1 path2 \n" +
                        "Renames from path1 to path2"
        );
    }

    private static void fileData(File f) {
        System.out.println(
                "Absolute path: " + f.getAbsolutePath() +
                        "\n Can read: " + f.canRead() +
                        "\n Can write: " + f.canWrite() +
                        "\n getName: " + f.getName() +
                        "\n getParent: " + f.getParent() +
                        "\n getPath: " + f.getPath() +
                        "\n length: " + f.length() +
                        "\n lastModified: " + f.lastModified()
        );
        if (f.isFile())
            PrintUtil.print("It's a file.");
        else if (f.isDirectory())
            PrintUtil.print("It's a directory.");
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            usage();
            return;
        }
        if (args[0].equals("-r")) {
            if (args.length != 3) usage();
            File
                    old = new File(args[1]),
                    rname = new File(args[2]);
            old.renameTo(rname);
            fileData(old);
            fileData(rname);
            return;
        }
        int count = 0;
        boolean del = false;
        if (args[0].equals("-d")) {
            count++;
            del = true;
        }
        count--;
        while (++count < args.length) {
            File f = new File(args[count]);
            if (f.exists()) {
                PrintUtil.print(f + " exists");
                if (del) {
                    PrintUtil.print("deleting..." + f);
                    f.delete();
                }
            } else {
                if (!del) {
                    f.mkdirs();
                    PrintUtil.print("created " + f);
                }
            }
            fileData(f);
        }
    }
}
