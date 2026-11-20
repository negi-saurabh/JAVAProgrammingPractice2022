package com.saurabh.practice.lambdas.practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class lambda {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,3);
        list = Arrays.asList(4,5,6,7);
        System.out.println("In main thread"+list.size());

        Stream.iterate(100, e -> e+1).forEach(System.out::println);

    }
}
