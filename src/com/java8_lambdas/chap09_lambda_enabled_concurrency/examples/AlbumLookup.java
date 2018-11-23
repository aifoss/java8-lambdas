package com.java8_lambdas.chap09_lambda_enabled_concurrency.examples;

import com.java8_lambdas.chap01_introduction.examples.Album;

/**
 * Created by sofia on 12/25/16.
 */
@FunctionalInterface
public interface AlbumLookup {

    Album lookupByName(String albumName);

}
