/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.spliterator;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * 利用fork/join框架进行求和
 *
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


    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        // 该任务负责求和的部分的大小
        int length = end - start;

        // 如果大小小于或等于阈值，顺序计算结果
        if (length < THRESHHOLD) {
            return computeSequentially();
        }


        // 创建一个子任务来为数组的前一半求和
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
        // 利用另一个ForkJoinPool线程异步执行新创建的子任务
        leftTask.fork();
        // 创建一个任务为数组的后一半求和
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);

        // 同步执行第二个子任务，有可能允许进一步递归划分
        Long rightResult = rightTask.compute();
        // 读取第一个子任务的结果，如果尚未完成就等待
        Long leftResult = leftTask.join();
        // 该任务的结果是两个子任务结果的组合
        return leftResult + rightResult;
    }

    private Long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }

        return sum;
    }


    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1, 1000000).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        Long sum = new ForkJoinPool().invoke(task);
        System.out.println(sum);
    }
}
