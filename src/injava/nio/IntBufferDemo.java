/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * Created by YangFan on 2016/9/29 下午5:39.
 * <p/>
 */
public class IntBufferDemo {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        IntBuffer ib = bb.asIntBuffer();
        ib.put(new int[]{11, 42, 49, 51, 1, 2, 3});
        System.out.println(ib.get(3));

        ib.put(3, 1881);
        ib.flip();
        while (ib.hasRemaining()) {
            int i = ib.get();
            System.out.println(i);
        }




    }
}
