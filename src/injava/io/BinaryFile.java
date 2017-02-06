/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.io;

import java.io.*;

/**
 * Created by YangFan on 2016/9/29 上午11:58.
 * <p/>
 */
public class BinaryFile {

    public static byte[] read(File file) throws IOException {
        byte[] data;
        try (BufferedInputStream bf = new BufferedInputStream(new FileInputStream(file))) {
            data = new byte[bf.available()];
            bf.read(data);
        }
        return data;
    }

    public static byte[] read(String fileName) throws IOException {
        return read(new File(fileName));
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new String(read("test2.txt")));
    }
}
