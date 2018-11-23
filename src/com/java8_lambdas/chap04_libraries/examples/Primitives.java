package com.java8_lambdas.chap04_libraries.examples;

import com.java8_lambdas.chap01_introduction.examples.Album;
import com.java8_lambdas.chap01_introduction.examples.SampleData;

import java.util.IntSummaryStatistics;

/**
 * Created by sofia on 12/24/16.
 */
public class Primitives {

    public static void printTrackLengthStatistics(Album album) {
        IntSummaryStatistics trackLengthStatistics = album.getTracks()
                .mapToInt(track -> track.getLength())
                .summaryStatistics();

        System.out.printf("Max: %d, Min: %d, Ave: %f, Sum: %d",
                trackLengthStatistics.getMax(),
                trackLengthStatistics.getMin(),
                trackLengthStatistics.getAverage(),
                trackLengthStatistics.getSum());
    }


    public static void main(String... args) {
        Album album = SampleData.aLoveSupreme;
        printTrackLengthStatistics(album);
    }

}
