package com.java8_lambdas.chap06_data_parallelism.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by sofia on 12/24/16.
 */
public class MonteCarloManual {

    private static final int N = 100_000;

    private final Map<Integer, Double> results;
    private final double fraction;
    private final int numThreads;
    private final int workPerThread;
    private final ExecutorService executor;

    public MonteCarloManual() {
        results = new ConcurrentHashMap<>();
        fraction = 1.0 / N;
        numThreads = Runtime.getRuntime().availableProcessors();
        workPerThread = N / numThreads;
        executor = Executors.newFixedThreadPool(numThreads);
    }

    public void simulateDiceRoles() {
        List<Future<?>> futures = submitJobs();
        awaitCompletion(futures);
        printResults();
    }

    private List<Future<?>> submitJobs() {
        List<Future<?>> futures = new ArrayList<>();
        for (int i = 0; i < numThreads; i++) {
            futures.add(executor.submit(makeJob()));
        }
        return futures;
    }

    private Runnable makeJob() {
        return () -> {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            for (int i = 0; i < workPerThread; i++) {
                int entry = twoDiceThrows(random);
                accumulateResult(entry);
            }
        };
    }

    private int twoDiceThrows(ThreadLocalRandom random) {
        int firstThrow = random.nextInt(1, 7);
        int secondThrow = random.nextInt(1, 7);
        return firstThrow + secondThrow;
    }

    private void accumulateResult(int entry) {
        results.compute(entry, (key, prev) ->
            prev == null ? fraction : prev + fraction
        );
    }

    private void awaitCompletion(List<Future<?>> futures) {
        futures.forEach((future) -> {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        executor.shutdown();
    }

    private void printResults() {
        results.entrySet().forEach(System.out::println);
    }


    public static void main(String... args) {
        MonteCarloManual simulator = new MonteCarloManual();
        simulator.simulateDiceRoles();
    }

}
