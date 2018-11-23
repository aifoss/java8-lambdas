package com.java8_lambdas.chap03_streams.examples;

import com.java8_lambdas.chap01_introduction.examples.Artist;
import com.java8_lambdas.chap01_introduction.examples.SampleData;

import java.util.Iterator;
import java.util.List;

/**
 * Created by sofia on 12/24/16.
 */
public class Iteration {

    public static int externalCountArtistsFromUK(List<Artist> artists) {
        int count = 0;
        for (Artist artist : artists) {
            if (artist.isFrom("UK")) {
                count++;
            }
        }
        return count;
    }

    public static int externalCountArtistsFromUKExpanded(List<Artist> artists) {
        int count = 0;
        Iterator<Artist> iterator = artists.iterator();
        while (iterator.hasNext()) {
            Artist artist = iterator.next();
            if (artist.isFrom("UK")) {
                count++;
            }
        }
        return count;
    }

    public static long internalCountArtistsFromUK(List<Artist> artists) {
        long count = artists.stream()
                .filter(artist -> artist.isFrom("UK"))
                .count();
        return count;
    }

    public static long internalCountArtistsFromUKPrinted(List<Artist> artists) {
        long count = artists.stream()
                .filter(artist -> {
                    System.out.println(artist.getName());
                    return artist.isFrom("UK");
                })
                .count();
        return count;
    }

    public static void filterArtistsFromUK(List<Artist> artists) {
        artists.stream()
                .filter(artist -> artist.isFrom("UK"));
    }

    public static void filterArtistsFromUKPrinted(List<Artist> artists) {
        artists.stream()
                .filter(artist -> {
                    System.out.println(artist.getName()); // does not get printed due to lazy evaluation
                    return artist.isFrom("UK");
                });
    }


    public static void main(String[] args) {
        List<Artist> artists = SampleData.threeArtistList;

        long count;

        count = externalCountArtistsFromUK(artists);
        System.out.println(count);
        System.out.println();

        count = externalCountArtistsFromUKExpanded(artists);
        System.out.println(count);
        System.out.println();

        count = internalCountArtistsFromUK(artists);
        System.out.println(count);
        System.out.println();

        count = internalCountArtistsFromUKPrinted(artists);
        System.out.println(count);
        System.out.println();

        filterArtistsFromUK(artists);
        System.out.println();

        filterArtistsFromUKPrinted(artists);
        System.out.println();
    }

}
