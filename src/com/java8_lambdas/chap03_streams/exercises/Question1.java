package com.java8_lambdas.chap03_streams.exercises;

import com.java8_lambdas.chap01_introduction.examples.Album;
import com.java8_lambdas.chap01_introduction.examples.Artist;
import com.java8_lambdas.chap01_introduction.examples.SampleData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by sofia on 12/24/16.
 */
public class Question1 {

    // 1.a function that adds up numbers, i.e., int addUp(Stream<Integer> numbers)
    public static int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (a, b) -> a + b);
    }

    // 1.b function that takes in artists and returns a list of strings with their names and places of origin
    public static List<String> getArtistNamesAndOrigins(List<Artist> artists) {
        return artists.stream()
                .flatMap(artist -> Stream.of(artist.getName(), artist.getNationality()))
                .collect(Collectors.toList());
    }

    // 1.c function that takes in albums and returns a list of albums with at most three tracks
    public static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> albums) {
        return albums.stream()
                .filter(album -> album.getTrackList().size() <= 3)
                .collect(Collectors.toList());
    }




    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        int sum = addUp(numbers.stream());

        System.out.println(sum+" = 10");
        System.out.println();

        List<Artist> artists = SampleData.threeArtistList;
        List<String> artistNamesAndOrigins = getArtistNamesAndOrigins(artists);

        System.out.println(artistNamesAndOrigins);
        System.out.println();

        List<Album> albums = SampleData.allAlbumList;
        List<Album> albumsWithAtMostThreeTracks = getAlbumsWithAtMostThreeTracks(albums);

        System.out.println(albumsWithAtMostThreeTracks);
        System.out.println();
    }

}
