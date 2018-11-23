package com.java8_lambdas.chap05_advanced_collections_and_collectors.exercises;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by sofia on 12/24/16.
 */
public class WordCount {

    /*
        2.b
        Given a Stream where each element is a word, count the number of times each
        word appears. So, if you were given the following input, you would return a Map
        of [John → 3, Paul → 2, George → 1]:
        Stream<String> names = Stream.of("John", "Paul", "George", "John",
         "Paul", "John");
     */

    public static Map<String, Long> countWordFreq(Stream<String> words) {
        return words.collect(Collectors.groupingBy(word -> word, Collectors.counting()));
    }


    public static void main(String... args) {
        Stream<String> names = Stream.of("John", "Paul", "George", "John", "Paul", "John");
        Map<String, Long> freqMap = countWordFreq(names);
        System.out.println(freqMap);
    }

}
