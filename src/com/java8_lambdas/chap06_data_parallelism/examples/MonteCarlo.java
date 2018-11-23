package com.java8_lambdas.chap06_data_parallelism.examples;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by sofia on 12/24/16.
 */
public class MonteCarlo {

    private static final int N = 100_000;
    private static final double FRACTION = 1.0 / N;

    public static Map<Integer, Double> serialDiceRolls() {
        return IntStream.range(0, N)
                .mapToObj(twoDiceThrows())
                .collect(Collectors.groupingBy(side -> side, Collectors.summingDouble(n -> FRACTION)));
    }

    public static Map<Integer, Double> parallelDiceRolls() {
        return IntStream.range(0, N)
                .parallel()
                .mapToObj(twoDiceThrows())
                .collect(Collectors.groupingBy(side -> side, Collectors.summingDouble(n -> FRACTION)));
    }

    private static IntFunction<Integer> twoDiceThrows() {
        return i -> {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            int firstThrow = random.nextInt(1, 7);
            int secondThrow = random.nextInt(1, 7);
            return firstThrow + secondThrow;
        };
    }


    public static void main(String... args) {
        Map<Integer, Double> result;
        long start, end;

        start = System.currentTimeMillis();
        result = serialDiceRolls();
        end = System.currentTimeMillis();

        result.entrySet().forEach(System.out::println);

        System.out.println();
        System.out.println((end-start)+" millisecs");
        System.out.println();

        start = System.currentTimeMillis();
        result = parallelDiceRolls();
        end = System.currentTimeMillis();

        result.entrySet().forEach(System.out::println);

        System.out.println();
        System.out.println((end - start) + " millisecs");
        System.out.println();
    }

}
