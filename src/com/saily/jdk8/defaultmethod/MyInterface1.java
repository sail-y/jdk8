/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.defaultmethod;

/**
 * Created by yangfan on 2017/2/5 下午8:33.
 * <p/>
 */
public interface MyInterface1 {

    default void myMethod() {
        System.out.println("myMethod");
    }
}
