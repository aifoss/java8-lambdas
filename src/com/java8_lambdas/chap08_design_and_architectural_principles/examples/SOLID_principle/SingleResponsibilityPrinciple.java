package com.java8_lambdas.chap08_design_and_architectural_principles.examples.SOLID_principle;

import java.util.stream.IntStream;

/**
 * Created by sofia on 12/25/16.
 */
public class SingleResponsibilityPrinciple {

    public interface PrimeCounter {
        long countPrimes(int n);
    }

    public static class ImperativeSingleMethodPrimeCounter implements PrimeCounter {
        @Override
        public long countPrimes(int n) {
            long count = 0;
            for (int i = 1; i < n; i++) {
                boolean isPrime = true;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                    }
                }
                if (isPrime) {
                    count++;
                }
            }
            return count;
        }
    }

    public static class ImperativeRefactoredPrimeCounter implements PrimeCounter {
        @Override
        public long countPrimes(int n) {
            long count = 0;
            for (int i = 1; i < n; i++) {
                if (isPrime(i)) {
                    count++;
                }
            }
            return count;
        }

        private boolean isPrime(int n) {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static class FunctionalPrimeCounter implements PrimeCounter {
        @Override
        public long countPrimes(int n) {
            return IntStream.range(1, n)
                    .filter(this::isPrime)
                    .count();
        }

        private boolean isPrime(int n) {
            return IntStream.range(2, n)
                    .allMatch(i -> (n % i) != 0);
        }
    }

    public static class ParallelFunctionalPrimeCounter implements PrimeCounter {
        @Override
        public long countPrimes(int n) {
            return IntStream.range(1, n)
                    .parallel()
                    .filter(this::isPrime)
                    .count();
        }

        private boolean isPrime(int n) {
            return IntStream.range(2, n)
                    .allMatch(i -> (n % i) != 0);
        }
    }


    public static void main(String... args) {
        int n = 100;
        long r;

        r = new ImperativeSingleMethodPrimeCounter().countPrimes(n);
        System.out.println(r);

        r = new ImperativeRefactoredPrimeCounter().countPrimes(n);
        System.out.println(r);

        r = new FunctionalPrimeCounter().countPrimes(n);
        System.out.println(r);

        r = new ParallelFunctionalPrimeCounter().countPrimes(n);
        System.out.println(r);
    }

}
