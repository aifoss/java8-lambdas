package com.java8_lambdas.chap03_streams.examples;

import java.util.stream.Stream;

/**
 * Created by sofia on 12/24/16.
 */
public class GeneratingStreams {

    public static void generate() {
        Stream.generate(() -> "hello world")
                .limit(3)
                .forEach(System.out::println);
    }

    public static void iterate() {
        Stream.iterate(0, x -> x + 1)
                .limit(5)
                .forEach(System.out::println);
    }


    public static void main(String... args) {
        generate();
        System.out.println();

        iterate();
        System.out.println();
    }

}
