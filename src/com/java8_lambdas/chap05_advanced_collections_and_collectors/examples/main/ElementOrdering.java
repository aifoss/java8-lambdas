package com.java8_lambdas.chap05_advanced_collections_and_collectors.examples.main;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by sofia on 12/24/16.
 */
public class ElementOrdering {

    @Test
    public void testOrderedStream() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> sameOrder = numbers.stream().collect(Collectors.toList());

        Assert.assertEquals(numbers, sameOrder);
    }

    @Test
    public void testEncounterOrder() {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(4, 3, 2, 1));
        List<Integer> ordered = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        Assert.assertEquals(Arrays.asList(1, 2, 3, 4), ordered);
    }

    @Test
    public void testOrdering() {
        List<Integer> ordered = Arrays.asList(1, 2, 3, 4);
        List<Integer> stillOrdered = ordered.stream()
                .map(x -> x + 1)
                .collect(Collectors.toList());

        Assert.assertEquals(Arrays.asList(2, 3, 4, 5), stillOrdered);

        Set<Integer> unordered = new HashSet<>(ordered);
        List<Integer> stillUnordered = unordered.stream()
                .map(x -> x + 1)
                .collect(Collectors.toList());

        Assert.assertTrue(stillUnordered.contains(2));
        Assert.assertTrue(stillUnordered.contains(3));
        Assert.assertTrue(stillUnordered.contains(4));
        Assert.assertTrue(stillUnordered.contains(5));
    }

}
