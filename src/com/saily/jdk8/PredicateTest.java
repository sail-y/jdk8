/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8;

import java.util.function.Predicate;

/**
 * Created by yangfan on 2017/1/25 下午5:55.
 * <p/>
 */
public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> predicate = p -> p.length() > 5;


        System.out.println(predicate.test("hello"));
    }
}
