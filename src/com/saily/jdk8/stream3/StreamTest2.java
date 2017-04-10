/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.stream3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author yangfan
 * @date 2017/03/30
 */
public class StreamTest2 {
    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


        transactions.stream().filter(transaction -> transaction.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).forEach(System.out::println);
        System.out.println("-----");
        transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().forEach(System.out::println);
        System.out.println("-----");
        transactions.stream().map(Transaction::getTrader).filter(trader -> "Cambridge".equals(trader.getCity())).distinct()
                .sorted(Comparator.comparing(Trader::getName)).forEach(System.out::println);
        System.out.println("-----");
        transactions.stream().map(Transaction::getTrader).map(Trader::getName).distinct().sorted().forEach(System.out::println);
        System.out.println("-----");

        transactions.stream().map(Transaction::getTrader).filter(trader -> "Milan".equals(trader.getCity())).findAny().ifPresent(System.out::println);
        System.out.println("-----");

        int sum = transactions.stream().filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity())).mapToInt(Transaction::getValue).sum();
        System.out.println(sum);

        System.out.println("-----");

        transactions.stream().mapToInt(Transaction::getValue).max().ifPresent(System.out::println);

        System.out.println("-----");

        transactions.stream().mapToInt(Transaction::getValue).min().ifPresent(System.out::println);


        System.out.println("-----");

        IntStream evenNumbers = IntStream.rangeClosed(1, 100).filter(i -> i % 2 == 0);
        System.out.println(evenNumbers.count());



    }
}
