/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by YangFan on 2016/9/29 上午9:41.
 * <p/>
 */
public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read("/Users/xiaomai/code/IdeaProjects/study/jdk8/src/injava/io/BufferedInputFile.java").getBytes()));
        while(in.available() != 0)
            System.out.print((char)in.readByte());



    }
}
