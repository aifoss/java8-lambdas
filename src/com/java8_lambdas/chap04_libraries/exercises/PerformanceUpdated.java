package com.java8_lambdas.chap04_libraries.exercises;

import com.java8_lambdas.chap01_introduction.examples.Artist;

import java.util.stream.Stream;

/**
 * Created by sofia on 12/24/16.
 */
public interface PerformanceUpdated {

    String getName();

    Stream<Artist> getMusicians();

    // 1. return a Stream of the artists performing and, in the case of groups, any musicians who are members of those groups
    default Stream<Artist> getAllMusicians() {
        return getMusicians()
                .flatMap(artist -> Stream.concat(Stream.of(artist), artist.getMembers()));
    }

}
