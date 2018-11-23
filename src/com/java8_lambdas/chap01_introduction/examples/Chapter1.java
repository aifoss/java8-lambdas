package com.java8_lambdas.chap01_introduction.examples;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sofia on 12/24/16.
 */
public class Chapter1 extends MusicChapter {

    public List<String> getNamesOfArtists_Lambda() {
        return artists.stream()
                .map(artist -> artist.getName())
                .collect(Collectors.toList());
    }

    public List<String> getNamesOfArtists_MethodReference() {
        return artists.stream()
                .map(Artist::getName)
                .collect(Collectors.toList());
    }

    public List<Artist> artistsLivingInLondon() {
        return artists.stream()
                .filter(artist -> "London".equals(artist.getNationality()))
                .collect(Collectors.toList());
    }

}
