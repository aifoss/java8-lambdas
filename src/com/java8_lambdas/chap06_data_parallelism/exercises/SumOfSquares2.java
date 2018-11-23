package com.java8_lambdas.chap06_data_parallelism.exercises;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by sofia on 12/24/16.
 */
public class SumOfSquares2 {

    /*
        3.
        The code in Example 6-12 also calculates the sum of the squares of numbers in a
        list. You should try to improve the performance of this code without degrading its
        quality. I’m only looking for you to make a couple of simple changes.
     */

    private List<Integer> arrayListOfNumbers;
    private List<Integer> linkedListOfNumbers;

    public SumOfSquares2() {
        arrayListOfNumbers= new ArrayList<>();
        addNumbers(arrayListOfNumbers);

        linkedListOfNumbers = new LinkedList<>();
        addNumbers(linkedListOfNumbers);
    }

    private void addNumbers(List<Integer> container) {
        IntStream.range(0, 1_000_000)
                .forEach(container::add);
    }

    public int slowSumOfSquares() {
        return linkedListOfNumbers.parallelStream()
                .map(x -> x * x)
                .reduce(0, (acc, x) -> acc + x);
    }

    public int serialSlowSumOfSquares() {
        return linkedListOfNumbers.stream()
                .map(x -> x * x)
                .reduce(0, (acc, x) -> acc + x);
    }

    public int intermediateSumOfSquares() {
        return arrayListOfNumbers.parallelStream()
                .map(x -> x * x)
                .reduce(0, (acc, x) -> acc + x);
    }

    public int serialIntermediateSumOfSquares() {
        return arrayListOfNumbers.stream()
                .map(x -> x * x)
                .reduce(0, (acc, x) -> acc + x);
    }

    public int fastSumOfSquares() {
        return arrayListOfNumbers.parallelStream()
                .mapToInt(x -> x * x)
                .sum();
    }

    public int serialFastSumOfSquares() {
        return arrayListOfNumbers.stream()
                .mapToInt(x -> x * x)
                .sum();
    }


    public static void main(String... args) {
        SumOfSquares2 sumOfSquares2 = new SumOfSquares2();

        int sum;
        long start, end;

        start = System.currentTimeMillis();
        sum = sumOfSquares2.slowSumOfSquares();
        end = System.currentTimeMillis();

        System.out.println("Slow: "+sum+" ("+(end-start)+" milliseconds)");

        start = System.currentTimeMillis();
        sum = sumOfSquares2.serialSlowSumOfSquares();
        end = System.currentTimeMillis();

        System.out.println("Serial Slow: "+sum+" ("+(end-start)+" milliseconds)");

        start = System.currentTimeMillis();
        sum = sumOfSquares2.intermediateSumOfSquares();
        end = System.currentTimeMillis();

        System.out.println("Intermediate: "+sum+" ("+(end-start)+" milliseconds)");

        start = System.currentTimeMillis();
        sum = sumOfSquares2.serialIntermediateSumOfSquares();
        end = System.currentTimeMillis();

        System.out.println("Serial Intermediate: "+sum+" ("+(end-start)+" milliseconds)");

        start = System.currentTimeMillis();
        sum = sumOfSquares2.fastSumOfSquares();
        end = System.currentTimeMillis();

        System.out.println("Fast: "+sum+" ("+(end-start)+" milliseconds)");

        start = System.currentTimeMillis();
        sum = sumOfSquares2.serialFastSumOfSquares();
        end = System.currentTimeMillis();

        System.out.println("Serial Fast: "+sum+" ("+(end-start)+" milliseconds)");
    }

}
