package com.java8_lambdas.chap09_lambda_enabled_concurrency.exercises;

import com.java8_lambdas.chap01_introduction.examples.Artist;

import java.util.function.Function;

/**
 * Created by sofia on 12/25/16.
 */
public class BlockingArtistAnalyzer {

    private final Function<String, Artist> artistLookupService;

    public BlockingArtistAnalyzer(Function<String, Artist> artistLookupservice) {
        this.artistLookupService = artistLookupservice;
    }

    public boolean isLargerGroup(String artistName, String otherArtistName) {
        return getNumberOfMembers(artistName) > getNumberOfMembers(otherArtistName);
    }

    private long getNumberOfMembers(String artistName) {
        return artistLookupService.apply(artistName)
                .getMembers()
                .count();
    }

}
