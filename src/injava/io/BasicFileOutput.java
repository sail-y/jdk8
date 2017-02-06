/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.io;

import java.io.*;

/**
 * Created by YangFan on 2016/9/29 上午9:46.
 * <p/>
 */
public class BasicFileOutput {
    static String file = "BasicFileOutput.out";
    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("/Users/xiaomai/code/IdeaProjects/study/jdk8/src/injava/io/BasicFileOutput.java")));
//        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        PrintWriter out = new PrintWriter(file);
        LineNumberReader in = new LineNumberReader(new StringReader(BufferedInputFile.read("/Users/xiaomai/code/IdeaProjects/study/jdk8/src/injava/io/BasicFileOutput.java")));

        int lineCount = 1;
        String s;
        while((s = in.readLine()) != null)
            out.println(in.getLineNumber() + ": " + s);
        out.close();
        System.out.println(BufferedInputFile.read(file));

    }
}
