/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yangfan
 * @date 2017/04/11
 */
public class ShopTest {

    static List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"));

    // 创建一个线程池，线程池中线程的数目为100和商店数目二者中较小的一个值
    private static final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            // 使用守护线程---这种方式不会阻止程序关掉
            t.setDaemon(true);
            return t;
        }
    });


    private static List<String> findPrices_1(String product) {
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getName() + " price is " + shop.getPrice(product), executor)).collect(Collectors.toList());
        return priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    private static List<String> findPrices_2(String product) {

        return shops.stream()
                // 取得每个shop对象中商品的原始价格
                .map(shop -> shop.getPrice(product))
                // 在Quote对象中队shop返回的字符串进行转换
                .map(Quote::parse)
                // 联系Discount服务，为每个Quote申请折扣
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());
    }

    private static List<String> findPrices(String product) {

        List<CompletableFuture<String>> priceFutures = shops.stream()
                // 以异步方式取得每个shop中指定产品的原始价格
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executor))
                // Quote对象存在时，对其返回值进行转换
                .map(future -> future.thenApply(Quote::parse))
                // 使用另一个异步任务构造期望的Future，申请折扣
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)))
                .collect(Collectors.toList());
        return priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }


    // 这里演示获取最先返回的数据
    public static Stream<CompletableFuture<String>> findPricesStream(String product) {
        return shops.stream().map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(
                        () -> Discount.applyDiscount(quote), executor)));
    }

    public static void main(String[] args) {

        long start = System.nanoTime();
//        System.out.println(findPrices("myPhone27S"));
        CompletableFuture[] futures = findPricesStream("myPhone27S")
                .map(f -> f.thenAccept(s -> System.out.println(s + " (done in " +
                        ((System.nanoTime() - start) / 1_000_000) + " msecs)")))
                .toArray(CompletableFuture[]::new);
//        CompletableFuture.allOf(futures).join();
        CompletableFuture.anyOf(futures).join();
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");


    }

}
