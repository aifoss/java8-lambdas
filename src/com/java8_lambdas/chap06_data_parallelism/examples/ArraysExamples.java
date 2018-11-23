package com.java8_lambdas.chap06_data_parallelism.examples;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by sofia on 12/24/16.
 */
public class ArraysExamples {

    public static double[] initializeImperative(int size) {
        double[] values = new double[size];
        for (int i = 0; i < size; i++) {
            values[i] = i;
        }
        return values;
    }

    public static double[] initializeParallel(int size) {
        double[] values = new double[size];
        Arrays.parallelSetAll(values, i -> i);
        return values;
    }

    public static double[] movingAverage(double[] values, int w) {
        double[] sums = Arrays.copyOf(values, values.length);
        Arrays.parallelPrefix(sums, Double::sum);

        int start = w-1;

        return IntStream.range(start, sums.length)
                .mapToDouble(i -> {
                    double prefix = i == start ? 0 : sums[i-w];
                    return (sums[i] - prefix) / w;
                })
                .toArray();
    }


    public static void main(String... args) {
        double[] values, movingAvgs;
        int size, w;

        size = 6;

        values = initializeImperative(size);
        System.out.println(Arrays.toString(values));

        values = initializeParallel(size);
        System.out.println(Arrays.toString(values));

        w = 3;

        movingAvgs = movingAverage(values, w);
        System.out.println(Arrays.toString(movingAvgs));
    }

}
