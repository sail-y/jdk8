/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8;

import java.util.function.Supplier;

/**
 * Created by yangfan on 2017/2/5 下午4:22.
 * <p/>
 */
public class StudentTest {
    public static void main(String[] args) {
        // 这种方式可以替代没有参数的工厂方法
        Supplier<Student> supplier = () -> new Student();
        System.out.println(supplier.get().getName());

        System.out.println("---------");

        // new的方法引用
        Supplier<Student> supplier2 = Student::new;
        System.out.println(supplier2.get().getName());


    }
}
