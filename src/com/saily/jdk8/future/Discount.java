/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.future;

import static com.saily.jdk8.future.Shop.delay;

/**
 * @author yangfan
 * @date 2017/04/11
 */
public class Discount {
    public enum Code {
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    public static String applyDiscount(Quote quote) {
        return quote.getShopName() + " price is " + apply(quote.getPrice(), quote.getDiscountCode());
    }

    public static double apply(double price, Code code) {
        delay();
        return price * (100 - code.percentage) / 100;
    }
}
