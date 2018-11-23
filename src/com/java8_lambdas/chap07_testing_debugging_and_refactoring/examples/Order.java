package com.java8_lambdas.chap07_testing_debugging_and_refactoring.examples;

import com.java8_lambdas.chap01_introduction.examples.Album;

import java.util.List;

/**
 * Created by sofia on 12/24/16.
 */
public abstract class Order {

    protected final List<Album> albums;

    public Order(List<Album> albums) {
        this.albums = albums;
    }

    public abstract long countRunningTime();

    public abstract long countMusicians();

    public abstract long countTracks();

}
