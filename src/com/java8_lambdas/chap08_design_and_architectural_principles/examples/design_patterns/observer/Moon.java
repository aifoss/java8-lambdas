package com.java8_lambdas.chap08_design_and_architectural_principles.examples.design_patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sofia on 12/25/16.
 */
public class Moon {

    private final List<LandingObserver> observers = new ArrayList<>();

    public void land(String name) {
        for (LandingObserver observer : observers) {
            observer.observeLanding(name);
        }
    }

    public void startSpying(LandingObserver observer) {
        observers.add(observer);
    }

    public static void classBasedExample() {
        Moon moon = new Moon();

        moon.startSpying(new Nasa());
        moon.startSpying(new Aliens());

        moon.land("An asteroid");
        moon.land("Apollo 11");
    }

    public static void lambdaBasedExample() {
        Moon moon = new Moon();

        moon.startSpying(name -> {
            if (name.contains("Apollo")) {
                System.out.println("We made it!");
            }
        });

        moon.startSpying(name -> {
            if (name.contains("Apollo")) {
                System.out.println("They're distracted, let's invade Earth!");
            }
        });

        moon.land("An asteroid");
        moon.land("Apollo 11");
    }


    public static void main(String... args) {
        classBasedExample();
        lambdaBasedExample();
    }

}
