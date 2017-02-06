/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8;

import java.util.Optional;

/**
 * Created by yangfan on 2017/2/5 下午6:11.
 * <p/>
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("hello");

        // 这是传统方式的代码书写方式
//        if (optional.isPresent()) {
//            System.out.println(optional.get());
//        }

        // 我们应该用函数式风格来使用Optional
        optional.ifPresent(System.out::println);

        System.out.println("------");
        System.out.println(optional.orElse("world"));


        System.out.println("------");
        System.out.println(optional.orElseGet(() -> "nihao"));
    }
}
