package com.java8_lambdas.chap04_libraries.examples;

/**
 * Created by sofia on 12/24/16.
 */
public class MultipleInheritance {

    public interface Rockable {
        String rock();
    }

    public interface Jukebox {
        default String rock() {
            return "... all over the world";
        }
    }

    public interface Carriage {
        default String rock() {
            return "... from side to side";
        }
    }

    public static class MusicalCarriage implements Carriage, Jukebox {
        @Override
        public String rock() {
            return Carriage.super.rock();
        }
    }

}
