/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.stream2;

/**
 * Created by yangfan on 2017/3/3 下午2:46.
 * <p/>
 *
 * @author xiaomai
 * @date 2017/03/03
 */
public class MyAutoCloseableTest implements AutoCloseable {

    public void  doSomething() {
        System.out.println("doSomething invoked!");
    }


    @Override
    public void close() throws Exception {
        System.out.println("close invoked!");
    }

    public static void main(String[] args) throws Exception {
        try (MyAutoCloseableTest myAutoCloseableTest = new MyAutoCloseableTest()){
            myAutoCloseableTest.doSomething();
        }
    }
}
