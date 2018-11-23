package com.java8_lambdas.chap06_data_parallelism.exercises;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sofia on 12/24/16.
 */
public class MultiplyThrough {

    /*
        2.
        The code in Example 6-11 multiplies every number in a list together and multiplies
        the result by 5. This works fine sequentially, but has a bug when running in parallel.
        Make the code run in parallel using streams and fix the bug.
     */

    public static int buggyMultiplyThrough(List<Integer> numbers) {
        return numbers.stream().reduce(5, (acc, x) -> x * acc);
    }

    public static int multiplyThrough(List<Integer> numbers) {
        return 5 * numbers.parallelStream().reduce(1, (acc, x) -> x * acc);
    }


    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        int product;

        product = buggyMultiplyThrough(numbers);
        System.out.println(product);

        product = multiplyThrough(numbers);
        System.out.println(product);
    }

}
