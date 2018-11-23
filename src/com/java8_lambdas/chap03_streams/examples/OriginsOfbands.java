package com.java8_lambdas.chap03_streams.examples;

import com.java8_lambdas.chap01_introduction.examples.Album;
import com.java8_lambdas.chap01_introduction.examples.Artist;
import com.java8_lambdas.chap01_introduction.examples.SampleData;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by sofia on 12/24/16.
 */
public class OriginsOfbands {

    // for a given album, find the nationality of every band playing on that album

    public static Set<String> originsOfBands_Imperative(Album album) {
        Set<String> result = new HashSet<>();
        for (Artist artist : album.getMusicianList()) {
            if (artist.getName().startsWith("The ")) {
                String nationality = artist.getNationality();
                result.add(nationality);
            }
        }
        return result;
    }

    public static Set<String> originsOfBands(Album album) {
        return album.getMusicians()
                .filter(artist -> artist.getName().startsWith("The "))
                .map(artist -> artist.getNationality())
                .collect(Collectors.toSet());
    }


    public static void main(String... args) {
        Set<String> result;

        result = originsOfBands_Imperative(SampleData.mixedAlbum);
        System.out.println(result);
        System.out.println();

        result = originsOfBands(SampleData.mixedAlbum);
        System.out.println(result);
        System.out.println();
    }

}
