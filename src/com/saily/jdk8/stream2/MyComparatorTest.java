/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.stream2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yangfan on 2017/2/26 上午11:24.
 * <p/>
 */
public class MyComparatorTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("nihao", "hello", "world", "welcome");

        // 字符串长度升序
//        list.sort((item1, item2) -> item1.length() - item2.length());


//        list.sort(Comparator.comparingInt(String::length));
        //这行代码会报错
//        list.sort(Comparator.comparingInt(o -> o.length()).reversed());
//        list.sort(Comparator.comparingInt(o -> o.length());
        // 这行代码正常，字符串长度降序
//        list.sort(Comparator.comparingInt(String::length).reversed());

        list.sort(Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER));

        System.out.println(list);
    }
}
