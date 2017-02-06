/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yangfan on 2017/2/6 上午10:45.
 * <p/>
 */
public class StreamTest11 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello welcome", "world hello", "hello world hello", "hello welcome");
        // 找出所有单词并且去重
        list.stream().flatMap(item -> Arrays.stream(item.split(" "))).distinct().forEach(System.out::println);
    }
}
