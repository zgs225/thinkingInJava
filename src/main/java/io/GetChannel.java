package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by yuez on 14-1-20.
 * Getting channels from streams
 */
public class GetChannel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        FileChannel fc = new FileOutputStream("src/main/resources/text/data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();
        fc = new RandomAccessFile("src/main/resources/text/data.txt", "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();
        fc = new FileInputStream("src/main/resources/text/data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining())
            System.out.print((char) buff.get());
    }
}
