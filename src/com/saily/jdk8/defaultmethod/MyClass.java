/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.defaultmethod;

/**
 * Created by yangfan on 2017/2/5 下午8:33.
 * <p/>
 */
public class MyClass implements MyInterface1, MyInterface2 {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.myMethod();
    }

    @Override
    public void myMethod() {
        MyInterface2.super.myMethod();
    }
}
