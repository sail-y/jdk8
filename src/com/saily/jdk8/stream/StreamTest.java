/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by yangfan on 2017/2/5 下午9:06.
 * <p/>
 */
public class StreamTest {
    public static void main(String[] args) {
        Stream stream = Stream.of("hello", "world", "hello world");

        String[] strArray = new String[]{"hello", "world", "hello world"};
        Stream stream1 = Stream.of(strArray);
        Stream stream2 = Arrays.stream(strArray);

        List<String> list = Arrays.asList(strArray);
        Stream stream3 = list.stream();
    }
}
