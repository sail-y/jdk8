/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8;

import java.util.*;

/**
 * Created by yangfan on 2017/1/22 上午10:59.
 * <p/>
 */
public class StringComparator {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");
        Collections.sort(names, (o1, o2) -> o2.compareTo(o1));

        System.out.println(names);

    }
}
