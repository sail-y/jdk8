/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by yangfan on 2017/2/5 下午9:33.
 * <p/>
 */
public class StreamTest4 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello", "world", "hello world");

//        String[] strArray = stream.toArray(i -> new String[i]);
//        Arrays.asList(strArray).forEach(System.out::println);

//        String[] strArray = stream.toArray(String[]::new);
//        Arrays.asList(strArray).forEach(System.out::println);

//        List<String> list = stream.collect(Collectors.toList());
//        list.forEach(System.out::println);

        // 第一个参数是要返回的容器，第二个参数是对每一个结果进行处理，第三个参数是把所有处理过的结果组装进要返回的list
//        List<String> list = stream.collect(() -> new ArrayList(), (theList, item) -> theList.add(item), (theList1, theList2) -> theList1.addAll(theList2));
//        List<String> list = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
//        list.forEach(System.out::println);

        // 另一个重载的collect方法
//        List<String> list = stream.collect(Collectors.toCollection(ArrayList::new));
//        list.forEach(System.out::println);


        // 转换为Set
//        Set<String> set = stream.collect(Collectors.toCollection(TreeSet::new));
//        set.forEach(System.out::println);

        // 拼接字符串
        String str = stream.collect(Collectors.joining());
        System.out.println(str);
    }
}
