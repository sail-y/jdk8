/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yangfan on 2017/2/6 上午10:30.
 * <p/>
 */
public class StreamTest10 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world");
        // 打印长度为5的第一个单词
//        list.stream().mapToInt(String::length).filter(length -> length == 5).findFirst().ifPresent(System.out::println);

        // 下面只会输入出hello和5，因为流针对每一个元素的统一应用所有操作，所以直接找到了第一个hello
        list.stream().mapToInt(item -> {
            int length = item.length();
            System.out.println(item);
            return length;
        }).filter(length -> length == 5).findFirst().ifPresent(System.out::println);

    }
}
