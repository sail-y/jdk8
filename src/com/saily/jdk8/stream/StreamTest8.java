/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.stream;

import java.util.stream.IntStream;

/**
 * Created by yangfan on 2017/2/6 上午9:23.
 * <p/>
 */
public class StreamTest8 {
    public static void main(String[] args) {
        // 这段代码虽然输出了正确的结果，但是程序不会终止，因为distinct一直在为无限流不停的去重
        IntStream.iterate(0, i -> (i + 1 ) % 2).distinct().limit(6).forEach(System.out::println);
        // 下面才是正确的方式
        IntStream.iterate(0, i -> (i + 1 ) % 2).limit(6).distinct().forEach(System.out::println);

    }
}
