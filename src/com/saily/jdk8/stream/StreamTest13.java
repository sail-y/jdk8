/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by yangfan on 2017/2/6 上午11:19.
 * <p/>
 */
public class StreamTest13 {
    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 100, 20);
        Student student2 = new Student("lisi", 90, 20);
        Student student3 = new Student("wangwu", 90, 30);
        Student student4 = new Student("zhangsan", 80, 40);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        // select * from student group by name;
        /*
         * 传统方式：
         * 1. 循环列表
         * 2. 取出学生名字
         * 3. 检查map中是否存在该名字，不存在则直接添加到该map中；存在则将map中的List对象取出来，然后将该Student对象添加到List中
         * 4. 返回map对象
         */

        // 流方式，一行代码
        Map<String, List<Student>> map = students.stream().collect(Collectors.groupingBy(Student::getName));
        System.out.println(map);


        //  select count(*) from student group by name;
        Map<String, Long> map1 = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
        System.out.println(map1);

        // 每个人的平均分
        Map<String, Double> map2 = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));
        System.out.println(map2);


        // 分区是分组的一种特例，就是用条件来分为两组
        Map<Boolean, List<Student>> map3 = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() >= 90));
        System.out.println(map3);

    }
}
