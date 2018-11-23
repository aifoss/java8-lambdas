package com.java8_lambdas.chap04_libraries.examples;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by sofia on 12/24/16.
 */
public class Optionals {

    @Test
    public void test() {
        Optional<String> a = Optional.of("a");
        assertEquals("a", a.get());

        Optional emptyOptional = Optional.empty();
        Optional alsoEmpty = Optional.ofNullable(null);

        assertFalse(emptyOptional.isPresent());
        assertFalse(alsoEmpty.isPresent());

        assertEquals("b", emptyOptional.orElse("b"));
        assertEquals("c", emptyOptional.orElseGet(() -> "c"));
    }

}
