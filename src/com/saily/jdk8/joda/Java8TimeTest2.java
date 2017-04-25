/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.joda;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.util.Locale;

import static java.time.temporal.ChronoField.DAY_OF_WEEK;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.TemporalAdjusters.*;

/**
 * @author yangfan
 * @date 2017/04/12
 */
public class Java8TimeTest2 {
    public static void main(String[] args) {
        // with是直接修改对应的属性
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        // 2011-03-18
        LocalDate date2 = date1.withYear(2011);
        // 2011-03-25
        LocalDate date3 = date2.withDayOfMonth(25);
        // 2011-09-25
        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 9);

        // plus和minus是相对方式修改属性
        // 2014-03-18
        date1 = LocalDate.of(2014, 3, 18);
        // 2014-03-25
        date2 = date1.plusWeeks(1);
        // 2011-03-25
        date3 = date2.minusYears(3);
        // 2011-09-25
        date4 = date3.plus(6, ChronoUnit.MONTHS);

        // 利用TemporalAdjuster进行复杂处理
        date1 = LocalDate.of(2014, 3, 18);
        // 下一个星期天 2014-03-23
        date2 = date1.with(nextOrSame(DayOfWeek.SUNDAY));
        // 这个月最后一天 2014-03-31
        date3 = date2.with(lastDayOfMonth());
        // 只取工作日
        date3 = date2.with(temporal -> {
            DayOfWeek dow = DayOfWeek.of(temporal.get(DAY_OF_WEEK));
            int dayToAdd = 1;
            if (dow == DayOfWeek.FRIDAY) {
                dayToAdd = 3;
            } else if (dow == DayOfWeek.SATURDAY) {
                dayToAdd = 2;
            }
            return temporal.plus(dayToAdd, DAYS);
        });

        TemporalAdjuster nextWorkingDay = ofDateAdjuster(temporal -> {
            DayOfWeek dow = DayOfWeek.of(temporal.get(DAY_OF_WEEK));
            int dayToAdd = 1;
            if (dow == DayOfWeek.FRIDAY) {
                dayToAdd = 3;
            } else if (dow == DayOfWeek.SATURDAY) {
                dayToAdd = 2;
            }
            return temporal.plus(dayToAdd, DAYS);
        });

        date2.with(nextWorkingDay);

        // 格式化操作

        LocalDate date = LocalDate.of(2014, 3, 18);
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);

        date1 = LocalDate.parse("20140318", DateTimeFormatter.BASIC_ISO_DATE);
        date2 = LocalDate.parse("2014-03-18", DateTimeFormatter.ISO_LOCAL_DATE);

        DateTimeFormatter italianFormatter =
                DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);

        date1 = LocalDate.of(2014, 3, 18);
        // 18. marzo 2014
        String formattedDate = date.format(italianFormatter);
        date2 = LocalDate.parse(formattedDate, italianFormatter);

        italianFormatter = new DateTimeFormatterBuilder().appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.ITALIAN);


    }
}
