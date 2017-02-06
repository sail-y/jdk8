/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8;

/**
 * Created by YangFan on 2016/12/20 上午10:28.
 * <p/>
 */

@FunctionalInterface
interface MyInterface {
    void test();

    // 这个不算抽象方法，因为MyInterface的实现类必然是Object的子类，他会直接继承Object类的实现，实现类依然只需要实现test()方法。
    String toString();
}

public class Test {
    public void myTest(MyInterface myInterface) {
        myInterface.test();
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.myTest(() -> {
            // 这里就是MyInterface.test()方法的实现
            System.out.println("mytest");
        });
    }

}
