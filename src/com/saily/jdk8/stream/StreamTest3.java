/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yangfan on 2017/2/5 下午9:13.
 * <p/>
 */
public class StreamTest3 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println(list.stream().map(i -> 2 * i).reduce(0, Integer::sum));
    }
}
