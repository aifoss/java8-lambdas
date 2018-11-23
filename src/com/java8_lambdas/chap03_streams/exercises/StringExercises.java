package com.java8_lambdas.chap03_streams.exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Created by sofia on 12/24/16.
 */
public class StringExercises {

    // 6. count the number of lowercase letters in a string
    public static int countLowercaseLetters(String s) {
        return (int) s.chars()
                .filter(Character::isLowerCase)
                .count();
    }

    // 7. find the string with the largest number of lowercase letters from a list of strings.
    public static Optional<String> getStringWithMostLowercaseLetters(List<String> strings) {
        return strings.stream()
                .max(Comparator.comparing(StringExercises::countLowercaseLetters));
    }


    public static void main(String... args) {
        String s = "ABC";
        String t = "abc";
        String v = "abcABCabc";

        List<String> strings = Arrays.asList(s, t, v);

        for (String str : strings) {
            System.out.println(countLowercaseLetters(str));
        }
        System.out.println();

        Optional<String> most = getStringWithMostLowercaseLetters(strings);

        System.out.println(most.isPresent());
        System.out.println(most.get());
    }

}
