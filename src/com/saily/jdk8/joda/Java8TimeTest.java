/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.joda;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.MonthDay;

/**
 * @author yangfan
 * @date 2017/04/08
 */
public class Java8TimeTest {
    public static void main(String[] args) {
        // 获取当前时间
        LocalDate localDate = LocalDate.now();

        System.out.println(localDate);

        System.out.println(localDate.getYear() + ", " + localDate.getMonthValue() + ", " + localDate.getDayOfMonth());

        System.out.println("------------");

        // 生成日期
        LocalDate localDate2 = LocalDate.of(2017, 4, 8);
        System.out.println(localDate2);

        System.out.println("------------");


        // 只关注月份和日期
        LocalDate localDate3 = LocalDate.of(2010, 3, 25);
        MonthDay monthDay = MonthDay.of(localDate3.getMonth(), localDate3.getDayOfMonth());
        MonthDay monthDay2 = MonthDay.from(LocalDate.of(2011, 3, 25));

        System.out.println(monthDay.equals(monthDay2));

        System.out.println("------------");

        // 时分秒
        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalTime time2 = time.plusHours(3).plusMinutes(20);
        System.out.println(time2);

        System.out.println("------------");

    }
}
