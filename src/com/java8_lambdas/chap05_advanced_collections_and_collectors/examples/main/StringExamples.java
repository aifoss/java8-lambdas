package com.java8_lambdas.chap05_advanced_collections_and_collectors.examples.main;

import com.java8_lambdas.chap01_introduction.examples.Artist;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by sofia on 12/24/16.
 */
public class StringExamples {

    public static Map<String, Long> countWords(Stream<String> words) {
        return words.collect(Collectors.groupingBy(word -> word, Collectors.counting()));
    }

    private static final Pattern SPACES = Pattern.compile("\\w+");

    public static Map<String, Long> countWordsIn(Path path) throws IOException {
        Stream<String> words = Files.readAllLines(path, Charset.defaultCharset())
                .stream()
                .flatMap(line -> SPACES.splitAsStream(line));

        return countWords(words);
    }

    public static Map<String, Long> countWordsInUsingRef(Path path) throws IOException {
        Stream<String> words = Files.readAllLines(path, Charset.defaultCharset())
                .stream()
                .flatMap(SPACES::splitAsStream);

        return countWords(words);
    }

    public static String formatArtistsImperative(List<Artist> artists) {
        StringBuilder sb = new StringBuilder("[");

        for (Artist artist : artists) {
            if (sb.length() > 1) {
                sb.append(", ");
            }
            String name = artist.getName();
            sb.append(name);
        }
        sb.append("]");

        return sb.toString();
    }

    public static String formatArtistsRefactored1(List<Artist> artists) {
        StringBuilder sb = new StringBuilder("[");

        artists.stream()
                .map(Artist::getName)
                .forEach(name -> {
                    if (sb.length() > 1) {
                        sb.append(", ");
                    }
                    sb.append(name);
                });

        sb.append("]");

        return sb.toString();
    }

    public static String formatArtistsRefactored2(List<Artist> artists) {
        StringBuilder reduced = artists.stream()
                .map(Artist::getName)
                .reduce(new StringBuilder(), (builder, name) -> {
                    if (builder.length() > 1) {
                        builder.append(", ");
                    }
                    builder.append(name);
                    return builder;
                },
                        (left, right) -> left.append(right));

        reduced.insert(0, "[");
        reduced.append("]");

        return reduced.toString();
    }

    public static String formatArtistsRefactored3(List<Artist> artists) {
        StringCombiner combined = artists.stream()
                .map(Artist::getName)
                .reduce(new StringCombiner(", ", "[", "]"),
                        StringCombiner::add,
                        StringCombiner::merge);

        return combined.toString();
    }

    public static String formatArtistsRefactored4(List<Artist> artists) {
        return artists.stream()
                .map(Artist::getName)
                .reduce(new StringCombiner(", ", "[", "]"),
                        StringCombiner::add,
                        StringCombiner::merge)
                .toString();
    }

    public static String formatArtistsReducing(List<Artist> artists) {
        return artists.stream()
                .map(Artist::getName)
                .collect(Collectors.reducing(
                        new StringCombiner(", ", "[", "]"),
                        name -> new StringCombiner(", ", "[", "]").add(name),
                        StringCombiner::merge))
                .toString();
    }

    public static String formatArtists(List<Artist> artists) {
        return artists.stream()
                .map(Artist::getName)
                .collect(new StringCollector(", ", "[", "]"));
    }


    public static void main(String... args) throws IOException {
        countWords(null);
        countWordsIn(null);
        countWordsInUsingRef(null);

        formatArtistsImperative(null);
        formatArtistsRefactored1(null);
        formatArtistsRefactored2(null);
        formatArtistsRefactored3(null);
        formatArtistsRefactored4(null);
        formatArtistsReducing(null);
        formatArtists(null);
    }

}
