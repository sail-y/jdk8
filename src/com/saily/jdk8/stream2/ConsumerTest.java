/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.stream2;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * @author yangfan
 * @date 2017/03/19
 */
public class ConsumerTest {

    public void test(Consumer<Integer> consumer) {
        consumer.accept(100);
    }

//    public void test(IntConsumer consumer) {
//        consumer.accept(100);
//    }

    public static void main(String[] args) {

        ConsumerTest consumerTest = new ConsumerTest();
        Consumer<Integer> consumer = System.out::println;
        IntConsumer intConsumer = System.out::println;

        System.out.println(consumer instanceof Consumer);
        System.out.println(intConsumer instanceof IntConsumer);

        // 面向对象方式
        consumerTest.test(consumer);
        // 函数式方式
        consumerTest.test(consumer::accept);
        consumerTest.test(intConsumer::accept);

    }
}
