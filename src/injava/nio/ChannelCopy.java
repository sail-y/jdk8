/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by YangFan on 2016/9/29 下午4:31.
 * <p/>
 */
public class ChannelCopy {
    private final static int BSIZE = 1024;
    public static void main(String[] args) {
        try {
            FileChannel in = new FileInputStream("test.txt").getChannel(),
                    out =  new FileOutputStream("data.txt").getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
            while(in.read(buffer) != -1) {
                buffer.flip();// prepare for writing
                out.write(buffer);
                buffer.clear(); //prepare for reading
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
