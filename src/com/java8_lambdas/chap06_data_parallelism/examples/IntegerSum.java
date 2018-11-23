package com.java8_lambdas.chap06_data_parallelism.examples;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by sofia on 12/24/16.
 */
public class IntegerSum {

    private static final int SIZE = Integer.getInteger("sum.size", 1_000_000);

    public int[] array;
    public List<Integer> arrayList;
    public LinkedList<Integer> linkedList;
    public TreeSet<Integer> treeSet;
    public HashSet<Integer> hashSet;

    public IntegerSum() {
        array = IntStream.range(0, SIZE).toArray();
        arrayList = IntStream.range(0, SIZE).mapToObj(i -> i).collect(Collectors.toList());
        linkedList = new LinkedList<>(arrayList);
        treeSet = new TreeSet<>(arrayList);
        hashSet = new HashSet<>(arrayList);
    }

    public int rangeSum() {
        return IntStream.range(0, SIZE).sum();
    }

    public int parallelRangeSum() {
        return IntStream.range(0, SIZE).parallel().sum();
    }

    public int arraySum() {
        return IntStream.of(array).sum();
    }

    public int parallelArraySum() {
        return IntStream.of(array).parallel().sum();
    }

    public int arrayListSum() {
        return arrayList.stream().mapToInt(i -> i).sum();
    }

    public int parallelArrayListSum() {
        return arrayList.parallelStream().mapToInt(i -> i).sum();
    }

    public int linkedListSum() {
        return linkedList.stream().mapToInt(i -> i).sum();
    }

    public int parallelLinkedListSum() {
        return linkedList.stream().mapToInt(i -> i).sum();
    }

    public int treeSetSum() {
        return treeSet.stream().mapToInt(i -> i).sum();
    }

    public int parallelTreeSetSum() {
        return treeSet.parallelStream().mapToInt(i -> i).sum();
    }

    public int hashSetSum() {
        return hashSet.stream().mapToInt(i -> i).sum();
    }

    public int parallelHashSetSum() {
        return hashSet.parallelStream().mapToInt(i -> i).sum();
    }


    public static void main(String... args) {
        IntegerSum integerSum = new IntegerSum();

        int sum;

        long start, end;

        start = System.currentTimeMillis();
        sum = integerSum.rangeSum();
        end = System.currentTimeMillis();

        System.out.println("Range Sum: "+sum);
        System.out.println((end-start)+" millisecs");
        System.out.println();

        start = System.currentTimeMillis();
        sum = integerSum.parallelRangeSum();
        end = System.currentTimeMillis();

        System.out.println("Parallel Range Sum: "+sum);
        System.out.println((end-start)+" millisecs");
        System.out.println();

        start = System.currentTimeMillis();
        sum = integerSum.arraySum();
        end = System.currentTimeMillis();

        System.out.println("Array Sum: "+sum);
        System.out.println((end-start)+" millisecs");
        System.out.println();

        start = System.currentTimeMillis();
        sum = integerSum.parallelArraySum();
        end = System.currentTimeMillis();

        System.out.println("Parallel Array Sum: "+sum);
        System.out.println((end-start)+" millisecs");
        System.out.println();

        start = System.currentTimeMillis();
        sum = integerSum.arrayListSum();
        end = System.currentTimeMillis();

        System.out.println("ArrayList Sum: "+sum);
        System.out.println((end-start)+" millisecs");
        System.out.println();

        start = System.currentTimeMillis();
        sum = integerSum.parallelArrayListSum();
        end = System.currentTimeMillis();

        System.out.println("Parallel ArrayList Sum: "+sum);
        System.out.println((end-start)+" millisecs");
        System.out.println();

        start = System.currentTimeMillis();
        sum = integerSum.linkedListSum();
        end = System.currentTimeMillis();

        System.out.println("LinkedList Sum: "+sum);
        System.out.println((end-start)+" millisecs");
        System.out.println();

        start = System.currentTimeMillis();
        sum = integerSum.parallelLinkedListSum();
        end = System.currentTimeMillis();

        System.out.println("Parallel LinkedList Sum: "+sum);
        System.out.println((end-start)+" millisecs");
        System.out.println();

        start = System.currentTimeMillis();
        sum = integerSum.treeSetSum();
        end = System.currentTimeMillis();

        System.out.println("TreeSet Sum: "+sum);
        System.out.println((end-start)+" millisecs");
        System.out.println();

        start = System.currentTimeMillis();
        sum = integerSum.parallelTreeSetSum();
        end = System.currentTimeMillis();

        System.out.println("Parallel TreeSet Sum: "+sum);
        System.out.println((end-start)+" millisecs");
        System.out.println();

        start = System.currentTimeMillis();
        sum = integerSum.hashSetSum();
        end = System.currentTimeMillis();

        System.out.println("HashSet Sum: "+sum);
        System.out.println((end-start)+" millisecs");
        System.out.println();

        start = System.currentTimeMillis();
        sum = integerSum.parallelHashSetSum();
        end = System.currentTimeMillis();

        System.out.println("Parallel HashSet Sum: "+sum);
        System.out.println((end-start)+" millisecs");
        System.out.println();
    }

}
