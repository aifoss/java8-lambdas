package com.java8_lambdas.chap03_streams.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by sofia on 12/24/16.
 */
public class MapUsingReduce {

    // Advanced Exercises 1
    // Write an implementation of the Stream function map using only reduce and lambda expressions.
    // You can return a List instead of a Stream if you want.
    public static <I, O> List<O> map(Stream<I> stream, Function<I, O> mapper) {
        return stream.reduce(new ArrayList<O>(), (acc, x) -> {
            List<O> newAcc = new ArrayList<>(acc);
            newAcc.add(mapper.apply(x));
            return newAcc;
        }, (List<O> left, List<O> right) -> {
                    List<O> newLeft = new ArrayList<>(left);
                    newLeft.addAll(right);
                    return newLeft;
                }
        );
    }

}
