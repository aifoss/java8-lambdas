package com.java8_lambdas.chap06_data_parallelism.exercises;

import java.util.stream.IntStream;

/**
 * Created by sofia on 12/24/16.
 */
public class SumOfSquares {

    /*
        1.
        The code in Example 6-10 sequentially sums the squares of numbers in a Stream.
        Make it run in parallel using streams.
     */

    public static int sequentialSumOfSquares(IntStream range) {
        return range.map(x -> x * x).sum();
    }

    public static int parallelSumOfSquares(IntStream range) {
        return range.parallel().map(x -> x * x).sum();
    }


    public static void main(String... args) {
        sequentialSumOfSquares(null);
        parallelSumOfSquares(null);
    }

}
