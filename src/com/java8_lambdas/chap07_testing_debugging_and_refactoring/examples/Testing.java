package com.java8_lambdas.chap07_testing_debugging_and_refactoring.examples;

import com.java8_lambdas.chap01_introduction.examples.Album;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sofia on 12/24/16.
 */
public class Testing {

    public static List<String> allToUpperCase(List<String> words) {
        return words.stream()
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
    }

    public static List<String> firstLetterToUpperCaseLambda(List<String> words) {
        return words.stream()
                .map(s -> {
                    char firstChar = Character.toUpperCase(s.charAt(0));
                    return firstChar + s.substring(1);
                })
                .collect(Collectors.toList());
    }

    public static List<String> firstLetterToUpperCase(List<String> words) {
        return words.stream()
                .map(Testing::firstToUpperCase)
                .collect(Collectors.toList());
    }

    public static String firstToUpperCase(String s) {
        char firstChar = Character.toUpperCase(s.charAt(0));
        return firstChar + s.substring(1);
    }


    @Test
    public void testAllToUpperCase() {
        List<String> input = Arrays.asList("a", "b", "hello");
        List<String> result = Testing.allToUpperCase(input);
        Assert.assertEquals(Arrays.asList("A", "B", "HELLO"), result);
    }

    @Test
    public void testFirstLetterToUpperCaseLambda() {
        List<String> input = Arrays.asList("a", "b", "hello");
        List<String> result = Testing.firstLetterToUpperCaseLambda(input);
        Assert.assertEquals(Arrays.asList("A", "B", "Hello"), result);
    }

    @Test
    public void testFirstLetterToUpperCase() {
        List<String> input = Arrays.asList("a", "b", "hello");
        List<String> result = Testing.firstLetterToUpperCase(input);
        Assert.assertEquals(Arrays.asList("A", "B", "Hello"), result);
    }

    @Test
    public void testFirstToUpperCase() {
        String input = "hello";
        String result = Testing.firstToUpperCase(input);
        Assert.assertEquals("Hello", result);
    }

    @Test
    public void testCountFeature() {
        OrderDomain order = new OrderDomain(Arrays.asList(
                new Album("Exile on Main St.", new ArrayList<>(), new ArrayList<>()),
                new Album("Beggars Banquet", new ArrayList<>(), new ArrayList<>()),
                new Album("Aftermath", new ArrayList<>(), new ArrayList<>()),
                new Album("Let It Bleed", new ArrayList<>(), new ArrayList<>())
        ));

        Assert.assertEquals(8, order.countFeature(album -> 2));
    }

}
