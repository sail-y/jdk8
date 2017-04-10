/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.stream3;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * @author yangfan
 * @date 2017/03/29
 */
public class StreamTest1 {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));



        List<String> threeHighCaloricDishNames = menu.stream().filter(d -> d.getCalories() > 3000).map(Dish::getName).limit(3).collect(toList());

        // 筛选前2个荤菜
        List<Dish> meatList = menu.stream().filter(d -> d.getType() == Dish.Type.MEAT).limit(2).collect(toList());

        List<String> dishNames = menu.stream().map(Dish::getName).collect(toList());

        List<Integer> dishNameLengths = menu.stream().map(Dish::getName).map(String::length).collect(toList());

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> squares = numbers.stream().map(i -> i * i).collect(toList());
        System.out.println(squares);



        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3,4);

        List<int[]> pairs = numbers1.stream().flatMap(i -> numbers2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[]{i, j})).collect(toList());
        System.out.println(pairs);

    }
}
