package com.java8_lambdas.chap03_streams.examples;

import com.java8_lambdas.chap01_introduction.examples.Track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by sofia on 12/24/16.
 */
public class StreamOperations {

    public static void collect_Stream() {
        List<String> list = Stream.of("a", "b", "c")
                .collect(Collectors.toList());

        System.out.println(list);
        System.out.println();
    }

    public static void map() {
        List<String> list = new ArrayList<>();
        for (String s : Arrays.asList("a", "b", "hello")) {
            String u = s.toUpperCase();
            list.add(u);
        }

        System.out.println(list);
        System.out.println();
    }

    public static void map_Stream() {
        List<String> list = Stream.of("a", "b", "hello")
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(list);
        System.out.println();
    }

    public static void filter() {
        List<String> list = new ArrayList<>();
        for (String s : Arrays.asList("a", "1abc", "abc1")) {
            if (Character.isDigit(s.charAt(0))) {
                list.add(s);
            }
        }

        System.out.println(list);
        System.out.println();
    }

    public static void filter_Stream() {
        List<String> list = Stream.of("a", "1abc", "abc1")
                .filter(s -> Character.isDigit(s.charAt(0)))
                .collect(Collectors.toList());

        System.out.println(list);
        System.out.println();
    }

    public static void flatMap_Stream() {
        List<Integer> list = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                .flatMap(lists -> lists.stream())
                .collect(Collectors.toList());

        System.out.println(list);
        System.out.println();
    }

    public static void min_Stream() {
        List<Track> tracks = Arrays.asList(
                new Track("Bakai", 524),
                new Track("Violets for Your Furs", 378),
                new Track("Time Was", 451)
        );

        Track shortestTrack = tracks.stream()
                .min(Comparator.comparing(track -> track.getLength()))
                .get();

        System.out.println(shortestTrack.getLength());
        System.out.println();
    }

    public static void reduce() {
        int acc = 0;
        for (int elem : Arrays.asList(1, 2, 3)) {
            acc = acc + elem;
        }

        System.out.println(acc);
        System.out.println();
    }

    public static void reduce_Stream() {
        int count = Stream.of(1, 2, 3)
                .reduce(0, (acc, elem) -> acc + elem);

        System.out.println(count);
        System.out.println();
    }

    public static void reduce_Stream_Expanded() {
        BinaryOperator<Integer> accumulator = (acc, elem) -> acc + elem;

        int count = accumulator.apply(
                accumulator.apply(
                        accumulator.apply(0, 1),
                        2),
                3);

        System.out.println(count);
        System.out.println();
    }


    public static void main(String... args) {
        collect_Stream();
        map();
        map_Stream();
        filter();
        filter_Stream();
        flatMap_Stream();
        min_Stream();
        reduce();
        reduce_Stream();
        reduce_Stream_Expanded();
    }

}
