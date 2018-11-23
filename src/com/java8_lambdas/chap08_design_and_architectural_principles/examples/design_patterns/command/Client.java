package com.java8_lambdas.chap08_design_and_architectural_principles.examples.design_patterns.command;

/**
 * Created by sofia on 12/25/16.
 */
public class Client {

    public static void main(String... args) {
        Macro macro = new Macro();

        // old
//        macro.record(new Open(editor));
//        macro.record(new Save(editor));
//        macro.record(new Close(editor));

        // lambda
//        macro.record(() -> editor.open());
//        macro.record(() -> editor.save());
//        macro.record(() -> editor.close());

        // method reference
//        macro.record(editor::open);
//        macro.record(editor::save);
//        macro.record(editor::close);

        macro.run();
    }

}
