package com.java8_lambdas.chap07_testing_debugging_and_refactoring.examples;

import com.java8_lambdas.chap01_introduction.examples.Album;

import java.util.List;
import java.util.function.ToLongFunction;

/**
 * Created by sofia on 12/24/16.
 */
public class OrderDomain extends Order {

    public OrderDomain(List<Album> albums) {
        super(albums);
    }

    @Override
    public long countRunningTime() {
        return countFeature(album -> album.getTracks()
                                        .mapToLong(track -> track.getLength())
                                        .sum());
    }

    @Override
    public long countMusicians() {
        return countFeature(album -> album.getMusicians().count());
    }

    @Override
    public long countTracks() {
        return countFeature(album -> album.getTracks().count());
    }

    public long countFeature(ToLongFunction<Album> function) {
        return albums.stream()
                .mapToLong(function)
                .sum();
    }

}
