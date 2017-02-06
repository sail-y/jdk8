/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by yangfan on 2017/2/6 上午9:17.
 * <p/>
 */
public class StreamTest7 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world");

        // map是一个中间操作，是惰性的，在没有遇到终止操作的时候，中间操作是不会执行的
        Stream<String> test = list.stream().map(item -> {
            String result = item.substring(0, 1).toUpperCase() + item.substring(1);
            System.out.println("test");
            return result;
        });

        // 这句代码才会输入map方法中的test
        test.forEach(System.out::println);


    }
}
