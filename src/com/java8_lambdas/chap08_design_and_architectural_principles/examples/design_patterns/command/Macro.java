package com.java8_lambdas.chap08_design_and_architectural_principles.examples.design_patterns.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sofia on 12/25/16.
 */
public class Macro {

    private final List<Action> actions;

    public Macro() {
        actions = new ArrayList<>();
    }

    public void record(Action action) {
        actions.add(action);
    }

    public void run() {
        actions.forEach(Action::perform);
    }

}
