package com.java8_lambdas.chap08_design_and_architectural_principles.examples.design_patterns.observer;

/**
 * Created by sofia on 12/25/16.
 */
public class Nasa implements LandingObserver {

    @Override
    public void observeLanding(String name) {
        if (name.contains("Apollo")) {
            System.out.println("We made it!");
        }
    }

}
