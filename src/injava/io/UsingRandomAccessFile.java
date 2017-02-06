/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by YangFan on 2016/9/29 上午10:33.
 * <p/>
 */
public class UsingRandomAccessFile {
    static String file = "rtest.dat";

    static void display() throws IOException {

        try (RandomAccessFile rf = new RandomAccessFile(file, "r")) {
            for (int i = 0; i < 7; i++) {
                System.out.println("Value " + i + ": " + rf.readDouble());
            }

            rf.readUTF();
            rf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        for (int i = 0; i < 7; i++) {
            rf.writeDouble(i * 1.414);
        }

        rf.writeUTF("The end of the file");
        rf.close();
        display();
        rf = new RandomAccessFile(file, "rw");
        // double占8个字节，查找第五个double值的位置
        rf.seek(5 * 8);
        rf.writeDouble(47.0001);
        rf.close();
        display();
    }
}
