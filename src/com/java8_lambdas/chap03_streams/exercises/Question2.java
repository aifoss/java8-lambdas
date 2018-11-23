package com.java8_lambdas.chap03_streams.exercises;

import com.java8_lambdas.chap01_introduction.examples.Artist;
import com.java8_lambdas.chap01_introduction.examples.SampleData;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by sofia on 12/24/16.
 */
public class Question2 {

    public static int countTotalMembersExternalIteration(List<Artist> artists) {
        int totalMembers = 0;
        for (Artist artist : artists) {
            Stream<Artist> members = artist.getMembers();
            totalMembers += members.count();
        }
        return totalMembers;
    }

    public static int countTotalMembersInternalIteration(List<Artist> artists) {
        return artists.stream()
                .map(artist -> artist.getMembers().count())
                .reduce(0L, Long::sum)
                .intValue();

    }


    public static void main(String... args) {
        List<Artist> artists = SampleData.threeArtistList;
        int count;

        count = countTotalMembersExternalIteration(artists);
        System.out.println(count);
        System.out.println();

        count = countTotalMembersInternalIteration(artists);
        System.out.println(count);
        System.out.println();
    }

}
