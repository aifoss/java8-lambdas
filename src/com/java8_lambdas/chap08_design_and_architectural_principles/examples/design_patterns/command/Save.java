package com.java8_lambdas.chap08_design_and_architectural_principles.examples.design_patterns.command;

/**
 * Created by sofia on 12/25/16.
 */
public class Save implements Action {

    private final Editor editor;

    public Save(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.save();
    }

}
