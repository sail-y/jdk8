/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.stream;

import java.util.stream.IntStream;

/**
 * Created by yangfan on 2017/2/5 下午9:10.
 * <p/>
 */
public class StreamTest2 {
    public static void main(String[] args) {
        IntStream.of(new int[]{5, 6, 7}).forEach(System.out::println);
        System.out.println("--------");
        // 不包含8
        IntStream.range(3, 8).forEach(System.out::println);
        System.out.println("--------");
        // 包含8
        IntStream.rangeClosed(3, 8).forEach(System.out::println);
    }
}
