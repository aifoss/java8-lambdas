package com.java8_lambdas.chap07_testing_debugging_and_refactoring.examples;

import com.java8_lambdas.chap01_introduction.examples.Album;
import com.java8_lambdas.chap01_introduction.examples.Artist;
import com.java8_lambdas.chap01_introduction.examples.SampleData;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by sofia on 12/24/16.
 */
public class TestLogging {

    public static Set<String> reportNationalityImperative(Album album) {
        Set<String> result = new HashSet<>();
        for (Artist artist : album.getMusicianList()) {
            if (artist.getName().startsWith("The ")) {
                String nationality = artist.getNationality();
                System.out.println("Found nationality: "+nationality);
                result.add(nationality);
            }
        }
        return result;
    }

    public static Set<String> reportNationality(Album album) {
        return album.getMusicians()
                .filter(artist -> artist.getName().startsWith("The "))
                .map(artist -> artist.getNationality())
                .peek(nationality -> System.out.println("Found nationality: "+nationality))
                .collect(Collectors.toSet());
    }


    public static void main(String... args) {
        Album album = SampleData.mixedAlbum;

        reportNationalityImperative(album);

        System.out.println();

        reportNationality(album);
    }

}
