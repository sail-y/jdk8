/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.stream2;

/**
 * @author yangfan
 * @date 2017/04/04
 */
public class LambdaTest {
    Runnable r1 = () -> System.out.println(this);

    Runnable r2 = new Runnable() {
        @Override
        public void run() {
            System.out.println(this);
        }
    };

    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();
        Thread t1=  new Thread(lambdaTest.r1);
        t1.start();

        System.out.println("---------------");


        Thread t2 = new Thread(lambdaTest.r2);
        t2.start();
    }
}
