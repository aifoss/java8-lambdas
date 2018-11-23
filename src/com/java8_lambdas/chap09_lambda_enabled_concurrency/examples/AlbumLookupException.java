package com.java8_lambdas.chap09_lambda_enabled_concurrency.examples;

/**
 * Created by sofia on 12/25/16.
 */
public class AlbumLookupException extends RuntimeException {

    public AlbumLookupException(Throwable cause) {
        super(cause);
    }

    public AlbumLookupException(String message) {
        super(message);
    }

}
