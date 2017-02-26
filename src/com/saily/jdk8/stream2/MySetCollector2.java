/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.stream2;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.UNORDERED;

/**
 * Created by yangfan on 2017/2/26 下午2:53.
 * <p/>
 */
public class MySetCollector2<T> implements Collector<T, Set<T>, Map<T, T>> {

    /**
     * 产生结果容器
     */
    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoked!");
        return () -> {
            System.out.println("new set");
            return new HashSet();
        };
    }

    /**
     * 累加器
     */
    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoked!");
        return (set, item) -> {
            System.out.println("accumulator: " + set + Thread.currentThread().getName());
            set.add(item);
        };
    }

    /**
     * 用于并行流，将多个部分的执行结果合并起来
     */
    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoked!");
        return (set1, set2) -> {
            System.out.println("set1: " + set1);
            System.out.println("set1: " + set2);
            set1.addAll(set2);
            return set1;
        };
    }

    /**
     * 合并后返回最终的结果类型
     */
    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        System.out.println("finisher invoked");
        return set -> {
            Map<T, T> map = new HashMap<>();
            set.forEach(item -> map.put(item, item));
            return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoked");

        // 这里就不能再写IDENTITY_FINISH了，因为A和R的类型不一样，如果写了会报一个强制转换的异常。
        return Collections.unmodifiableSet(EnumSet.of(UNORDERED, CONCURRENT));
    }

    public static void main(String[] args) {


        List<String> list = Arrays.asList("hello", "world", "welcome", "hello", "a", "b", "c", "d", "e", "f", "g");

        Map<String, String> map = list.parallelStream().collect(new MySetCollector2<>());

        System.out.println(map);

    }
}
