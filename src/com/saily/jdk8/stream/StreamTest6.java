/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.stream;

import java.util.IntSummaryStatistics;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * Created by yangfan on 2017/2/5 下午10:21.
 * <p/>
 */
public class StreamTest6 {
    public static void main(String[] args) {
//        Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
//        stream.findFirst().ifPresent(System.out::println);


        // iterate会产生一个无限流，所以要配合limit使用
        Stream<Integer> stream = Stream.iterate(1, item -> item + 2).limit(6);
//        stream.forEach(System.out::println);


        //找出该流中大于2的元素，然后将每个月元素乘以2，然后过滤掉流中的前两个元素，然后再取流中的前两个元素，最后求出流中元素的总和。
        // 1,3,5,7,9,11 结果是32
//        Integer integer = stream.filter(item -> item > 2).mapToInt(item -> item * 2)
//                .skip(2).limit(2).sum();
//        System.out.println(integer);



//        IntSummaryStatistics intSummaryStatistics = stream.filter(item -> item > 2).mapToInt(item -> item * 2)
//                .skip(2).limit(2).summaryStatistics();

//        System.out.println(intSummaryStatistics.getCount());
//        System.out.println(intSummaryStatistics.getMax());
//        System.out.println(intSummaryStatistics.getMin());


//        System.out.println(stream);
//        System.out.println(stream.filter(item -> item > 2));
        // 这句代码会抛异常: stream has already been operated upon or closed
//        System.out.println(stream.distinct());

        // 正确的调用方式如下
        System.out.println(stream);
        Stream<Integer> stream2 = stream.filter(item -> item > 2);
        System.out.println(stream2);
        Stream<Integer> stream3 = stream2.distinct();
        System.out.println(stream3);

    }
}
