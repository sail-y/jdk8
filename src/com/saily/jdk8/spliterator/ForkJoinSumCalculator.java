/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.spliterator;

import java.util.concurrent.RecursiveTask;

/**
 * 利用fork/join框架进行求和
 * @author yangfan
 * @date 2017/03/31
 */
// 继承RecursiveTask来创建可以用于fork/join框架的任务
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    // 要求和的数组
    private final long[] numbers;
    // 子任务处理的数组的起始位置和终止位置
    private final int start;
    private final int end;

    public static final long THRESHHOLD = 10_100;

    public ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        return null;
    }
}
