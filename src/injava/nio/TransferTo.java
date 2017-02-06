/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by YangFan on 2016/9/29 下午4:50.
 * <p/>
 */
public class TransferTo {
    public static void main(String[] args) {
        try {
            FileChannel in = new FileInputStream("test.txt").getChannel(),
                    out =  new FileOutputStream("data.txt").getChannel();
            in.transferTo(0, in.size(), out);

//            out.transferFrom(in, 0, in.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
