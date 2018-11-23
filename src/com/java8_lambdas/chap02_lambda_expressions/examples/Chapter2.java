package com.java8_lambdas.chap02_lambda_expressions.examples;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * Created by sofia on 12/24/16.
 */
public class Chapter2 {

    public static void buttonClick() {
        JButton button = new JButton();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
            }
        });
    }

    public static void buttonClick_Lambda() {
        JButton button = new JButton();

        button.addActionListener(event -> System.out.println("Button clicked"));
    }

    public static void lambdaExpressions() {
        Runnable noArguments = () -> System.out.println("Hello World");

        ActionListener oneArgument = event -> System.out.println("Button clicked");

        Runnable multiStatement = () -> {
            System.out.print("Hello");
            System.out.println(" World");
        };

        BinaryOperator<Long> add = (x, y) -> x + y;

        BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;
    }

    public static void captureVariableValue() {
        final String name = getUserName();

        JButton button = new JButton();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hi "+name);
            }
        });
    }

    public static void captureVariableValue_Lambda() {
        String name = getUserName();

        JButton button = new JButton();

        button.addActionListener(event -> System.out.println("Hi "+name));
    }

    public static void captureVariableValue_Lambda_CompileError() {
        String name = getUserName();
        name = formatUserName(name);

        JButton button = new JButton();

//        button.addActionListener(event -> System.out.println("Hi "+name));
    }

    public static void typeInference() {
        final String[] array = { "Hello", "World" };

        Map<String, Integer> oldWordCounts = new HashMap<String, Integer>();
        Map<String, Integer> diamondWordCounts = new HashMap<>();

        useHashmap(new HashMap<>());
    }

    public static void typeInference_Lambda() {
        Predicate<Integer> atLeast5 = x -> x >= 5;

        BinaryOperator<Long> addLongs = (x, y) -> x + y;
    }


    private static String getUserName() {
        return "Richard";
    }

    private static String formatUserName(String name) {
        return name.toLowerCase();
    }

    private static void useHashmap(Map<String, String> values) {

    }

}
