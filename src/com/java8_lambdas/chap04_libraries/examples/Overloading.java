package com.java8_lambdas.chap04_libraries.examples;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * Created by sofia on 12/24/16.
 */
public class Overloading {

    interface Overloader<T> {
        void overload1(T input);
    }

    public static void overload1(Object o) {
        System.out.println("Object");
    }

    public static void overload1(String s) {
        System.out.println("String");
    }


    interface IntegerBiFunction extends BinaryOperator<Integer> {
    }

    public static void overload2(BinaryOperator<Integer> lambda) {
        System.out.println("BinaryOperator");
    }

    public static void overload2(IntegerBiFunction lambda) {
        System.out.println("IntegerBiFunction");
    }


    interface IntPredicate {
        boolean test(int val);
    }

    public static void overload3(Predicate<Integer> predicate) {
        System.out.println("Predicate");
    }

    public static void overload3(IntPredicate predicate) {
        System.out.println("IntPredicate");
    }


    public static void main(String... args) {
        overload1(new Object());
        overload1("abc");

        overload2((x, y) -> x + y);

        Predicate<Integer> predicate = x -> x > 3;
        overload3(predicate);
        IntPredicate intPredicate = x -> x > 3;
        overload3(intPredicate);
    }

}
