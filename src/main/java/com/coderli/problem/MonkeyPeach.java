package com.coderli.problem;

import java.util.Set;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MonkeyPeach {

    public static void main(String[] args) {
        //Java 8
        IntStream.iterate(1, i -> i + 1).limit(9).forEach(System.out::println);
        //Java 9
        IntStream.iterate(1, i -> i < 10, i -> i + 1).forEach(System.out::println);
        //Java9 taskWhile  123
        IntStream.iterate(1, i -> i < 10, i -> i + 1).takeWhile(i -> i < 4).forEach(System.out::print);
        //Java9 dropWhile 5-9
        IntStream.iterate(1, i -> i < 10, i -> i + 1).dropWhile(i -> i < 4).forEach(System.out::print);

    }

}
