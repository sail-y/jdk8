/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by yangfan on 2017/2/6 上午10:21.
 * <p/>
 */
public class StreamTest9 {
    public static void main(String[] args) {
        // 准备500w个uuid来用不同的流进行排序
        List<String> list = new ArrayList<>(5000000);

        for (int i = 0; i < 5000000; i++) {
            list.add(UUID.randomUUID().toString());
        }
        System.out.println("开始排序");

        long startTime = System.nanoTime();

        list.stream().sorted().count();
        long endTime = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("排序耗时：" + millis);


        startTime = System.nanoTime();

        list.parallelStream().sorted().count();
        endTime = System.nanoTime();

        millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("排序耗时：" + millis);

        /**
         * 开始排序
         * 排序耗时：6500
         * 排序耗时：3394
         */
    }
}
