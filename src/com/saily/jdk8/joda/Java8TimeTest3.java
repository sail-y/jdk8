/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.joda;

import java.time.*;
import java.time.chrono.MinguoDate;

/**
 * @author yangfan
 * @date 2017/04/12
 */
public class Java8TimeTest3 {
    public static void main(String[] args) {
        ZoneId romeZone = ZoneId.of("Europe/Rome");
        LocalDate date = LocalDate.of(2014, Month.MARCH, 18);
        ZonedDateTime zdt1 = date.atStartOfDay(romeZone);

        LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        ZonedDateTime zdt2 = dateTime.atZone(romeZone);

        Instant instant = Instant.now();
        ZonedDateTime zdt3 = instant.atZone(romeZone);

//        Instant instantFromDateTime = dateTime.toInstant(romeZone);
        LocalDateTime timeFromInstant = LocalDateTime.ofInstant(instant, romeZone);

        // 时区偏差
        ZoneOffset newYourkOffset = ZoneOffset.of("-05:00");
        OffsetDateTime dateTimeInNewYork = OffsetDateTime.of(dateTime, newYourkOffset);

        MinguoDate minguoDate = MinguoDate.now();
        System.out.println(minguoDate);




    }
}
