package com.java8_lambdas.chap08_design_and_architectural_principles.examples.SOLID_principle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by sofia on 12/25/16.
 */
public class DependencyInversionPrinciple {

    public static class HeadingLookupException extends RuntimeException {
        public HeadingLookupException(IOException e) {
        }
    }

    @FunctionalInterface
    public interface HeadingFinder {
        List<String> findHeadings(Reader reader);
    }

    public static class NoDIP implements HeadingFinder {
        @Override
        public List<String> findHeadings(Reader input) {
            try (BufferedReader reader  = new BufferedReader(input)) {
                return reader.lines()
                        .filter(line -> line.endsWith(":"))
                        .map(line -> line.substring(0, line.length()-1))
                        .collect(Collectors.toList());
            } catch (IOException e) {
                throw new HeadingLookupException(e);
            }
        }
    }

    public static class ExtractedDIP implements HeadingFinder {
        @Override
        public List<String> findHeadings(Reader input) {
            return withLinesOf(input,
                    lines -> lines.filter(line -> line.endsWith(":"))
                                    .map(line -> line.substring(0, line.length()-1))
                                    .collect(Collectors.toList()),
                    HeadingLookupException::new);
        }

        private <T> T withLinesOf(Reader input,
                                  Function<Stream<String>, T> handler,
                                  Function<IOException, RuntimeException> errorHandler) {
            try (BufferedReader reader = new BufferedReader(input)) {
                return handler.apply(reader.lines());
            } catch (IOException e) {
                throw errorHandler.apply(e);
            }
        }
    }


    public static void main(String... args) {
        new NoDIP().findHeadings(null);
        new ExtractedDIP().findHeadings(null);
    }

}
