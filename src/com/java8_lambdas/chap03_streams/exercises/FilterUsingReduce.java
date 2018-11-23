package com.java8_lambdas.chap03_streams.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by sofia on 12/24/16.
 */
public class FilterUsingReduce {

    // Advanced Exercises 2
    // Write an implementation of the Stream function filter using only reduce and lambda expressions.
    public static <I> List<I> filter(Stream<I> stream, Predicate<I> predicate) {
        List<I> initial = new ArrayList<>();

        return stream.reduce(initial, (List<I> acc, I x) -> {
            if (predicate.test(x)) {
                List<I> newAcc = new ArrayList<>(acc);
                newAcc.add(x);
                return newAcc;
            } else {
                return acc;
            }
        },
                FilterUsingReduce::combineLists);
    }

    private static <I> List<I> combineLists(List<I> left, List<I> right) {
        List<I> result = new ArrayList<>(left);
        result.addAll(right);
        return result;
    }

}
