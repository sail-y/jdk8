/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.nio;

import java.nio.*;

/**
 * Created by YangFan on 2016/9/29 下午5:44.
 * <p/>
 */
public class ViewBuffers {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[]{0, 0, 0, 0, 0, 0, 0, 'a'});
        bb.rewind();
        System.out.print("Byte Buffer ");
        while(bb.hasRemaining()) {
            System.out.print(bb.position() + " -> " + bb.get() + ", ");
        }
        System.out.println();

        bb.rewind();
        CharBuffer cb = bb.asCharBuffer();
        System.out.print("Char Buffer ");
        while(cb.hasRemaining()) {
            System.out.print(cb.position() + " -> " + cb.get() + ", ");
        }

        System.out.println();
        bb.rewind();
        FloatBuffer fb = bb.asFloatBuffer();
        System.out.print("Float Buffer ");
        while(fb.hasRemaining()) {
            System.out.print(fb.position() + " -> " + fb.get() + ", ");
        }



        System.out.println();
        bb.rewind();
        IntBuffer ib = bb.asIntBuffer();
        System.out.print("Int Buffer ");
        while(ib.hasRemaining()) {
            System.out.print(ib.position() + " -> " + ib.get() + ", ");
        }



        System.out.println();
        bb.rewind();
        LongBuffer lb = bb.asLongBuffer();
        System.out.print("Long Buffer ");
        while(lb.hasRemaining()) {
            System.out.print(lb.position() + " -> " + lb.get() + ", ");
        }


        System.out.println();
        bb.rewind();
        ShortBuffer sb = bb.asShortBuffer();
        System.out.print("Short Buffer ");
        while(sb.hasRemaining()) {
            System.out.print(sb.position() + " -> " + sb.get() + ", ");
        }


        System.out.println();
        bb.rewind();
        DoubleBuffer db = bb.asDoubleBuffer();
        System.out.print("Double Buffer ");
        while(db.hasRemaining()) {
            System.out.print(db.position() + " -> " + db.get() + ", ");
        }



    }
}
