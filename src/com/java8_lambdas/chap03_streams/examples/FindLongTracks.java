package com.java8_lambdas.chap03_streams.examples;

import com.java8_lambdas.chap01_introduction.examples.Album;
import com.java8_lambdas.chap01_introduction.examples.SampleData;
import com.java8_lambdas.chap01_introduction.examples.Track;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by sofia on 12/24/16.
 */
public class FindLongTracks {

    @FunctionalInterface
    public interface LongTrackFinder {
        Set<String> findLongTracks(List<Album> albums);
    }


    public static class ImperativeLongTrackFinder implements LongTrackFinder {
        @Override
        public Set<String> findLongTracks(List<Album> albums) {
            Set<String> result = new HashSet<>();

            for (Album album : albums) {
                for (Track track : album.getTrackList()) {
                    if (track.getLength() > 60) {
                        String name = track.getName();
                        result.add(name);
                    }
                }
            }

            return result;
        }
    }

    public static class FunctionalLongTrackFinder1 implements LongTrackFinder {
        @Override
        public Set<String> findLongTracks(List<Album> albums) {
            Set<String> result = new HashSet<>();

            albums.stream()
                    .forEach(album -> {
                        album.getTracks()
                                .forEach(track -> {
                                    if (track.getLength() > 60) {
                                        String name = track.getName();
                                        result.add(name);
                                    }
                                });
                    });

            return result;
        }
    }

    public static class FunctionalLongTrackFinder2 implements LongTrackFinder {
        @Override
        public Set<String> findLongTracks(List<Album> albums) {
            Set<String> result = new HashSet<>();

            albums.stream()
                    .forEach(album -> {
                        album.getTracks()
                                .filter(track -> track.getLength() > 60)
                                .map(track -> track.getName())
                                .forEach(name -> result.add(name));
                    });

            return result;
        }
    }

    public static class FunctionalLongTrackFinder3 implements LongTrackFinder {
        @Override
        public Set<String> findLongTracks(List<Album> albums) {
            Set<String> result = new HashSet<>();

            albums.stream()
                    .flatMap(album -> album.getTracks())
                    .filter(track -> track.getLength() > 60)
                    .map(track -> track.getName())
                    .forEach(name -> result.add(name));

            return result;
        }
    }

    public static class FunctionalLongTrackFinder4 implements LongTrackFinder {
        @Override
        public Set<String> findLongTracks(List<Album> albums) {
            return albums.stream()
                    .flatMap(album -> album.getTracks())
                    .filter(track -> track.getLength() > 60)
                    .map(track -> track.getName())
                    .collect(Collectors.toSet());
        }
    }


    public static void main(String... args) {
        List<Album> albums = SampleData.allAlbumList;
        Set<String> result;

        result = new ImperativeLongTrackFinder().findLongTracks(albums);
        System.out.println(result);
        System.out.println();

        result = new FunctionalLongTrackFinder1().findLongTracks(albums);
        System.out.println(result);
        System.out.println();

        result = new FunctionalLongTrackFinder2().findLongTracks(albums);
        System.out.println(result);
        System.out.println();

        result = new FunctionalLongTrackFinder3().findLongTracks(albums);
        System.out.println(result);
        System.out.println();

        result = new FunctionalLongTrackFinder4().findLongTracks(albums);
        System.out.println(result);
        System.out.println();
    }

}
