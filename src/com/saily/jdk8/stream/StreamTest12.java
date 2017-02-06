/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yangfan on 2017/2/6 上午11:07.
 * <p/>
 */
public class StreamTest12 {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("Hi", "Hello", "你好");
        List<String> list2 = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");


        List<String> result = list1.stream().flatMap(item -> list2.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());
        result.forEach(System.out::println);

    }
}
