package com.java8_lambdas.chap07_testing_debugging_and_refactoring.examples;

import com.java8_lambdas.chap01_introduction.examples.Album;

import java.util.List;

/**
 * Created by sofia on 12/24/16.
 */
public class OrderStreams extends Order {

    public OrderStreams(List<Album> albums) {
        super(albums);
    }

    @Override
    public long countRunningTime() {
        return albums.stream()
                .mapToLong(album -> album.getTracks()
                        .mapToLong(track -> track.getLength())
                        .sum())
                .sum();
    }

    @Override
    public long countMusicians() {
        return albums.stream()
                .mapToLong(album -> album.getMusicians().count())
                .sum();
    }

    @Override
    public long countTracks() {
        return albums.stream()
                .mapToLong(album -> album.getTracks().count())
                .sum();
    }

}
