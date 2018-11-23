package com.java8_lambdas.chap08_design_and_architectural_principles.examples.design_patterns.strategy;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by sofia on 12/25/16.
 */
public interface CompressionStrategy {

    OutputStream compress(OutputStream data) throws IOException;

}
