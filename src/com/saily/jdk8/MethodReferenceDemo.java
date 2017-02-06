/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yangfan on 2017/2/5 下午7:04.
 * <p/>
 */
public class MethodReferenceDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world");


        list.forEach(System.out::println);
    }
}
