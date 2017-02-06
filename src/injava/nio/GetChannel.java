/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by YangFan on 2016/9/29 下午4:09.
 * <p/>
 */
public class GetChannel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        try {
            FileChannel fc = new FileOutputStream("data.txt").getChannel();
            fc.write(ByteBuffer.wrap("Some text".getBytes()));
            fc.close();
            fc = new RandomAccessFile("data.txt", "rw").getChannel();
            fc.position(fc.size());
            fc.write(ByteBuffer.wrap("Some more".getBytes()));
            fc.close();
            // read
            fc = new FileInputStream("data.txt").getChannel();
            ByteBuffer buff = ByteBuffer.allocate(BSIZE);
            fc.read(buff);
            buff.flip();

            while (buff.hasRemaining())
                System.out.print((char)buff.get());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
