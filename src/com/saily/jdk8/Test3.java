/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by yangfan on 2017/1/17 下午2:29.
 * <p/>
 */

public class Test3 {
    public static void main(String[] args) {
//        TheInterface i1 = () -> {
//        };
//        System.out.println(i1.getClass().getInterfaces()[0]);
//
//
//        TheInterface2 i2 = () -> {
//        };
//        System.out.println(i2.getClass().getInterfaces()[0]);
//
//        new Thread(() -> System.out.println("thread")).start();

        List<String> list = Lists.newArrayList("hello", "world", "hello world");
//        list.forEach(item -> System.out.println(item.toUpperCase()));


        List<String> list2 = new ArrayList<>();

        list.stream().map(String::toUpperCase).forEach(System.out::println);

        Function<String, String> function = String::toUpperCase;
        System.out.println(function.apply("hello"));



    }
}


@FunctionalInterface
interface TheInterface {
    void myMethod();
}


@FunctionalInterface
interface TheInterface2 {
    void myMethod2();
}