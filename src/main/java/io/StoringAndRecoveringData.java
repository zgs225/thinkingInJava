package io;

import utils.PrintUtil;

import java.io.*;

/**
 * Created by yuez on 14-1-19.
 */
public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream("data.txt")
        ));
        out.writeDouble(1.3322);
        out.writeUTF("Hello World");
        out.writeInt(23);
        out.writeUTF("NiHao World");
        out.close();
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(new FileInputStream("data.txt"))
        );
        PrintUtil.print(in.readDouble());
        PrintUtil.print(in.readUTF());
        PrintUtil.print(in.readInt());
        PrintUtil.print(in.readUTF());
    }
}
