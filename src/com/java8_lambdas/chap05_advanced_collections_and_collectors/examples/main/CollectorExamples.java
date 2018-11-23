package com.java8_lambdas.chap05_advanced_collections_and_collectors.examples.main;

import com.java8_lambdas.chap01_introduction.examples.Album;
import com.java8_lambdas.chap01_introduction.examples.Artist;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by sofia on 12/24/16.
 */
public class CollectorExamples {

    public static TreeSet<Integer> toTreesetCollection() {
        Stream<Integer> stream = Stream.of(1, 2, 3);
        return stream.collect(Collectors.toCollection(TreeSet::new));
    }

    public static Optional<Artist> getBiggestGroup(Stream<Artist> artists) {
        Function<Artist, Long> getCount = artist -> artist.getMembers().count();
        return artists.collect(Collectors.maxBy(Comparator.comparing(getCount)));
    }

    public static Map<Boolean, List<Artist>> partitionBandsAndSolo(Stream<Artist> artists) {
        return artists.collect(Collectors.partitioningBy(artist -> artist.isSolo()));
    }

    public static Map<Boolean, List<Artist>> partitionBandsAndSoloUsingRef(Stream<Artist> artists) {
        return artists.collect(Collectors.partitioningBy(Artist::isSolo));
    }

    public static Map<Artist, List<Album>> groupAlbumsByArtist(Stream<Album> albums) {
        return albums.collect(Collectors.groupingBy(album -> album.getMainMusician()));
    }

    public static Map<Artist, List<Album>> groupAlbumsByArtistUsingRef(Stream<Album> albums) {
        return albums.collect(Collectors.groupingBy(Album::getMainMusician));
    }

    public static Map<Artist, Long> getNumberOfAlbumsByArtistDumb(Stream<Album> albums) {
        Map<Artist, List<Album>> albumsByArtist = albums.collect(Collectors.groupingBy(album -> album.getMainMusician()));
        Map<Artist, Long> numberOfAlbums = new HashMap<>();
        for (Map.Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
            numberOfAlbums.put(entry.getKey(), (long)entry.getValue().size());
        }
        return numberOfAlbums;
    }

    public static Map<Artist, Long> getNumberOfAlbumsByArtist(Stream<Album> albums) {
        return albums.collect(Collectors.groupingBy(album -> album.getMainMusician(), Collectors.counting()));
    }

    public static Map<Artist, List<String>> groupAlbumNamesByArtistDumb(Stream<Album> albums) {
        Map<Artist, List<Album>> albumsByArtist = albums.collect(Collectors.groupingBy(album -> album.getMainMusician()));
        Map<Artist, List<String>> albumNames = new HashMap<>();
        for (Map.Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
            albumNames.put(entry.getKey(), entry.getValue().stream().map(Album::getName).collect(Collectors.toList()));
        }
        return albumNames;
    }

    public static Map<Artist, List<String>> groupAlbumNamesByArtist(Stream<Album> albums) {
        return albums.collect(Collectors.groupingBy(Album::getMainMusician,
                Collectors.mapping(Album::getName, Collectors.toList())));
    }

    public static double getAverageNumberOfTracks(List<Album> albums) {
        return albums.stream().collect(Collectors.averagingInt(album -> album.getTrackList().size()));
    }


    public static void main(String... args) {
        toTreesetCollection();
        getBiggestGroup(null);
        partitionBandsAndSolo(null);
        partitionBandsAndSoloUsingRef(null);
        groupAlbumsByArtist(null);
        groupAlbumsByArtistUsingRef(null);
        getNumberOfAlbumsByArtistDumb(null);
        getNumberOfAlbumsByArtist(null);
        groupAlbumNamesByArtistDumb(null);
        groupAlbumNamesByArtist(null);
        getAverageNumberOfTracks(null);
    }

}
