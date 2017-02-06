/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8.methodreference;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yangfan on 2017/2/5 下午7:54.
 * <p/>
 */
public class MethodReferenceTest {
    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 10);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 50);
        Student student4 = new Student("zhaoliu", 40);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        // 这是常规的lambda表达式写法
        students.sort((o1, o2) -> Student.compareStudentByScore(o1, o2));
        students.forEach(student -> System.out.println(student.getScore()));

        System.out.println("-----------");

        // 下面展示方法引用的写法，这就是上面的代码的语法糖，更简洁
        students.sort(Student::compareStudentByName);
        students.forEach(student -> System.out.println(student.getName()));

        StudentComparator studentComparator = new StudentComparator();
        students.sort((o1, o2) -> studentComparator.compareStudentByScore(o1, o2));
        students.sort(studentComparator::compareStudentByScore);


        students.sort((o1, o2) -> o1.compareByScore(o2));
        students.sort(Student::compareByScore);
    }
}
