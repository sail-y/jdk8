/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.joda;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * @author yangfan
 * @date 2017/04/12
 */
public class Java8TimeTest1 {

    public static void main(String[] args) {
        // 2014-03-18
        LocalDate date = LocalDate.of(2014, 3, 18);
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dow = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        // 闰年
        boolean leap = date.isLeapYear();
        System.out.println(leap);

        LocalDate today = LocalDate.now();

        // TemporalField方式获取
        year = date.get(ChronoField.YEAR);

        // 时间
        // 13:45:20
        LocalTime time = LocalTime.of(13, 45, 20);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();


        // 从字符串转换
        date = LocalDate.parse("2014-03-18");
        time = LocalTime.parse("13:45:20");

        // LocalDateTime
        // 2014-03-18T13:45:20
        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(13, 45, 20);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);

        // 机器嗦理解的时间类Instant
        Instant.ofEpochSecond(0);
        // 2秒后加上一千秒
        Instant.ofEpochSecond(2, 1_000);
        Instant.now().toEpochMilli();

        // 所有类都实现了Temporal接口，  Temporal接口定义了如何读取和操纵为时间建模的对象的值

        // Duration类主要用于以秒和纳秒恒衡量的时间的长短
        Duration d1 = Duration.between(time, time.plusHours(1));
        System.out.println(d1.getSeconds());
        // Period则以年、月或日的方式对多个时间单位建模
        Period tenDays = Period.between(LocalDate.of(2014, 3, 8), LocalDate.of(2014, 3, 18));
        System.out.println(tenDays.getDays());
        // Duration和Period还有一些工厂类
        Duration threeMinutes = Duration.ofMinutes(3);
        threeMinutes = Duration.of(3, ChronoUnit.MINUTES);

        Period nineDays = Period.ofDays(9);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
        System.out.println(dt1.plus(twoYearsSixMonthsOneDay));


        // 取今天的0点
        LocalDateTime localDateTime = LocalDate.now().atTime(0, 0, 0);
        long beginOfDay = localDateTime.toEpochSecond(ZoneOffset.of("+08:00"));

        System.out.println(localDateTime);
        System.out.println(beginOfDay);


    }
}
