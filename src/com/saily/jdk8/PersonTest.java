/*
 * Copyright (c) 2017 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.saily.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * Created by yangfan on 2017/1/22 下午6:38.
 * <p/>
 */
public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person("zhangsan", 20);
        Person person2 = new Person("lisi", 30);
        Person person3 = new Person("wangwu", 40);

        List<Person> people = Arrays.asList(person1, person2, person3);


        PersonTest test = new PersonTest();
//        List<Person> personResult = test.getPeopleByUsername("zhangsan", people);
//        personResult.forEach(person -> System.out.println(person.getUsername()));

//        List<Person> personResult = test.getPeopleByAge(20, people);
//        personResult.forEach(person -> System.out.println(person.getAge()));

        List<Person> personResult = test.getPeopleByAge2(20, people, (ageOfPerson, personList) -> personList.stream().filter(person -> person.getAge() > ageOfPerson).collect(Collectors.toList()));
        personResult.forEach(person -> System.out.println(person.getAge()));



    }

    public List<Person> getPeopleByUsername(String username, List<Person> people) {

        return people.stream().filter(person -> person.getUsername().equals(username)).collect(Collectors.toList());
    }

    public List<Person> getPeopleByAge(int age, List<Person> people) {
        BiFunction<Integer, List<Person>, List<Person>> biFunction = (ageOfPerson, personList) -> personList.stream().filter(person -> person.getAge() > ageOfPerson).collect(Collectors.toList());

        return biFunction.apply(age, people);
    }

    public List<Person> getPeopleByAge2(int age, List<Person> people, BiFunction<Integer, List<Person>, List<Person>> biFunction) {

        return biFunction.apply(age, people);
    }
}
