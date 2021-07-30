package com.revature.interfaces;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Driver {

    public static void main(String[] args) {

        List<Integer> stringList = new ArrayList<>();
        stringList.add(0);
        stringList.add(1);
        stringList.add(2);
        stringList.add(3);
        stringList.add(4);
        stringList.add(5);

        printListContents(stringList);
    }


    // generic method
    public static void printListContents(List<Integer> list) {

        // imperative logic
        for (Integer i : list) {
            if (i % 2 == 0) {

            }
        }


        // Pre Java 8 logic using an anonymous class
        list.stream()
            .filter(new Predicate<Integer>() {
                @Override
                public boolean test(Integer integer) {
                    return integer % 2 == 0;
                }
            });

        // Java 8+ with lambdas!
        // exceptions thrown within a lambda must be handled in that lambda, they cannot be caught outside of it!!!
        System.out.println(list);
        List<String> newList = list.stream()
                                    .filter(i -> i % 2 == 0) // filter is an intermediate operation; returns a Stream
                                    .map(i -> "test" + i) // map is another intermediate operation
                                    .collect(Collectors.toList()); // collect is a terminal operation; it does not return a Stream

        System.out.println(list); // the original stream source stays unaffected

        newList.forEach(System.out::println); // this is a method reference; shortened lambda

    }

}
