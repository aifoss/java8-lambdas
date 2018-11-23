package com.java8_lambdas.chap07_testing_debugging_and_refactoring.examples;

import com.java8_lambdas.chap01_introduction.examples.Album;
import com.java8_lambdas.chap01_introduction.examples.Track;

import java.util.List;

/**
 * Created by sofia on 12/24/16.
 */
public class OrderImperative extends Order {

    public OrderImperative(List<Album> albums) {
        super(albums);
    }

    @Override
    public long countRunningTime() {
        long count = 0;
        for (Album album : albums) {
            for (Track track : album.getTrackList()) {
                count += track.getLength();
            }
        }
        return count;
    }

    @Override
    public long countMusicians() {
        long count = 0;
        for (Album album : albums) {
            count += album.getMusicianList().size();
        }
        return count;
    }

    @Override
    public long countTracks() {
        long count = 0;
        for (Album album : albums) {
            count += album.getTrackList().size();
        }
        return count;
    }

}
