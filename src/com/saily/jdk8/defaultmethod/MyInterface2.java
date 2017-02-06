/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.defaultmethod;

/**
 * Created by yangfan on 2017/2/5 下午8:34.
 * <p/>
 */
public interface MyInterface2 {

    default void myMethod() {
        System.out.println("myMthod2");
    }
}
