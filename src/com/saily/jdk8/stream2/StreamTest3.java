/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.stream2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yangfan
 * @date 2017/03/12
 */
public class StreamTest3 {



    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "welcome");


        Stream<String> stream = list.stream();

        System.out.println("1111111");


        Stream<String> stream2 = stream.map(item -> item + "_abc");

        System.out.println("2222222");

        stream2.forEach(System.out::println);



    }
}
