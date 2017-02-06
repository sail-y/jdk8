/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.nio;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.IntBuffer;

/**
 * Created by YangFan on 2016/9/29 下午5:39.
 * <p/>
 */
public class DoubleBufferDemo {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        DoubleBuffer doubleBuffer = bb.asDoubleBuffer();
        doubleBuffer.put(new double[]{11, 42, 49, 51, 1, 2, 3});
        System.out.println(doubleBuffer.get(3));

        doubleBuffer.put(3, 1881);
        doubleBuffer.flip();
        while (doubleBuffer.hasRemaining()) {
            double i = doubleBuffer.get();
            System.out.println(i);
        }




    }
}
