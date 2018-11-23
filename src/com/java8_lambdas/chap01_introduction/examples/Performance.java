package com.java8_lambdas.chap01_introduction.examples;

import java.util.stream.Stream;

/**
 * Created by sofia on 12/24/16.
 */
public interface Performance {

    String getName();

    Stream<Artist> getMusicians();

    default Stream<Artist> getAllMusicians() {
        return getMusicians().flatMap(artist -> {
            return Stream.concat(Stream.of(artist), artist.getMembers());
        });
    }

}
