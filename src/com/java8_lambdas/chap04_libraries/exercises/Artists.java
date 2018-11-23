package com.java8_lambdas.chap04_libraries.exercises;

import com.java8_lambdas.chap01_introduction.examples.Artist;

import java.util.List;
import java.util.Optional;

/**
 * Created by sofia on 12/24/16.
 */
public class Artists {

    private List<Artist> artists;

    public Artists(List<Artist> artists) {
        this.artists = artists;
    }

    public Artist getArtist(int index) {
        if (index < 0 || index >= artists.size()) {
            indexException(index);
        }
        return artists.get(index);
    }

    private void indexException(int index) {
        throw new IllegalArgumentException(index+" doesn't correspond to an artist");
    }

    public String getArtistName(int index) {
        try {
            Artist artist = getArtist(index);
            return artist.getName();
        } catch (IllegalArgumentException e) {
            return "Unknown";
        }
    }

    public Optional<Artist> getArtistRefactored(int index) {
        if (index < 0 || index >= artists.size()) {
            return Optional.empty();
        }
        return Optional.of(artists.get(index));
    }

    public String getArtistNameRefactored(int index) {
        Optional<Artist> artist = getArtistRefactored(index);
        return artist.map(Artist::getName)
                .orElse("Unknown");
    }

}
