package com.java8_lambdas.chap05_advanced_collections_and_collectors.exercises;

import com.java8_lambdas.chap01_introduction.examples.Artist;
import com.java8_lambdas.chap01_introduction.examples.SampleData;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sofia on 12/24/16.
 */
public class LongestName {

    /*
        2.a
        Find the artist with the longest name. You should implement this using a Col
        lector and the reduce higher-order function from Chapter 3. Then compare
        the differences in your implementation: which was easier to write and which
        was easier to read? The following example should return "Stuart Sutcliffe":
        Stream<String> names = Stream.of("John Lennon", "Paul McCartney",
         "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe");
     */

    private static Comparator<Artist> byNameLength = Comparator.comparing(artist -> artist.getName().length());

    public static Artist artistWithLongestNameByReduce(List<Artist> artists) {
        return artists.stream()
                .reduce((acc, artist) -> {
                    return (byNameLength.compare(acc, artist) >= 0) ? acc : artist;
                })
                .orElseThrow(RuntimeException::new);
    }

    public static Artist artistWithLongestNameByCollect(List<Artist> artists) {
        return artists.stream()
                .collect(Collectors.maxBy(byNameLength))
                .orElseThrow(RuntimeException::new);
    }


    public static void main(String... args) {
        List<Artist> artists = SampleData.membersOfTheBeatles;
        Artist artist;

        artist = artistWithLongestNameByReduce(artists);
        System.out.println(artist);

        artist = artistWithLongestNameByCollect(artists);
        System.out.println(artist);
    }

}
