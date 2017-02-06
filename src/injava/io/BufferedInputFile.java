/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by YangFan on 2016/9/29 上午9:06.
 * <p/>
 */
public class BufferedInputFile {
    public static String read(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while((s = in.readLine()) != null) {
            sb.append(s).append("\n");
        }

        in.close();
        return sb.toString();
    }


    public static List<String> readList(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        List<String> list = new LinkedList<>();
        while((s = in.readLine()) != null) {
            list.add(s + "\n");
        }

        in.close();
        return list;
    }

    public static void main(String[] args) {
        try {
//            System.out.println(read("/Users/xiaomai/code/IdeaProjects/study/jdk8/src/injava/io/BufferedInputFile.java"));
            List<String> list = readList("/Users/xiaomai/code/IdeaProjects/study/jdk8/src/injava/io/BufferedInputFile.java");
            Collections.reverse(list);
            System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
