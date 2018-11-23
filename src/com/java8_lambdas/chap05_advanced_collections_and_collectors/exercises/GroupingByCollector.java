package com.java8_lambdas.chap05_advanced_collections_and_collectors.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Created by sofia on 12/24/16.
 */
public class GroupingByCollector<T, K> implements Collector<T, Map<K, List<T>>, Map<K, List<T>>> {

    /*
        2.c
        Implement Collectors.groupingBy as a custom collector. You don’t need to
        provide a downstream collector, so just implementing the simplest variant is
        fine. If you look at the JDK source code, you’re cheating! Hint: you might want
        to start with public class GroupingBy<T, K> implements Collector<T,
        Map<K, List<T>>, Map<K, List<T>>>. This is an advanced exercise, so you
        might want to attempt it last.
     */

    private static final Set<Characteristics> characteristics = new HashSet<>();
    static {
        characteristics.add(Characteristics.IDENTITY_FINISH);
    }

    private final Function<? super T, ? extends K> classifier;

    public GroupingByCollector(Function<? super T, ? extends K> classifier) {
        this.classifier = classifier;
    }

    @Override
    public Supplier<Map<K, List<T>>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<K, List<T>>, T> accumulator() {
        return (map, elem) -> {
            K key = classifier.apply(elem);
            List<T> elems = map.computeIfAbsent(key, k -> new ArrayList<>());
            elems.add(elem);
        };
    }

    @Override
    public BinaryOperator<Map<K, List<T>>> combiner() {
        return (left, right) -> {
            right.forEach((key, value) -> {
                left.merge(key, value, (leftValue, rightValue) -> {
                    leftValue.addAll(rightValue);
                    return leftValue;
                });
            });
            return left;
        };
    }

    @Override
    public Function<Map<K, List<T>>, Map<K, List<T>>> finisher() {
        return map -> map;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return characteristics;
    }


    public static void main(String... args) {
        GroupingByCollector collector = new GroupingByCollector(null);
    }

}
