package com.java8_lambdas.chap09_lambda_enabled_concurrency.exercises;

import java.util.function.Consumer;

/**
 * Created by sofia on 12/25/16.
 */
@FunctionalInterface
public interface ArtistAnalyzer {

    void isLargerGroup(String artistName, String otherArtistName, Consumer<Boolean> handler);

}
