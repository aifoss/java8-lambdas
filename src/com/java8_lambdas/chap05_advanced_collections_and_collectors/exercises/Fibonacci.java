package com.java8_lambdas.chap05_advanced_collections_and_collectors.exercises;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sofia on 12/24/16.
 */
public class Fibonacci {

    /*
        3.
        Efficiently calculate a Fibonacci sequence using just the computeIfAbsent method
        on a Map. By “efficiently,” I mean that you don’t repeatedly recalculate the Fibonacci
        sequence of smaller numbers.
     */

    private final Map<Integer, Long> cache;

    public Fibonacci() {
        cache = new HashMap<>();
        cache.put(0, 1L);
        cache.put(1, 1L);
    }

    public long fibonacci(int x) {
        return cache.computeIfAbsent(x, n -> fibonacci(n-1) + fibonacci(n-2));
    }

}
