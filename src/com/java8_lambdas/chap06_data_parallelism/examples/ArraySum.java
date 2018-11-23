package com.java8_lambdas.chap06_data_parallelism.examples;

import com.java8_lambdas.chap01_introduction.examples.Album;
import com.java8_lambdas.chap01_introduction.examples.SampleData;
import com.java8_lambdas.chap01_introduction.examples.Track;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by sofia on 12/24/16.
 */

public class ArraySum {

    public static List<Album> initAlbums(int size) {
        int n = Integer.getInteger("arraysum.size", size);
        return IntStream.range(0, n)
                .mapToObj(i -> SampleData.aLoveSupreme.copy())
                .collect(Collectors.toList());
    }

    public static int serialArraySum(List<Album> albums) {
        return albums.stream()
                .flatMap(Album::getTracks)
                .mapToInt(Track::getLength)
                .sum();
    }

    public static int parallelArraySum(List<Album> albums) {
        return albums.parallelStream()
                .flatMap(Album::getTracks)
                .mapToInt(Track::getLength)
                .sum();
    }


    public static void main(String... args) {
        int sum;
        long start, end;

        for (int i = 0; i < 6; i++) {
            int n = (int)Math.pow(10, i);

            System.out.println("n = "+n);
            System.out.println();

            List<Album> albums = initAlbums(n);

            start = System.nanoTime();
            sum = serialArraySum(albums);
            end = System.nanoTime();

            System.out.println("sum = " + sum);
            System.out.println((end - start) + " msecs");
            System.out.println();

            start = System.nanoTime();
            sum = parallelArraySum(albums);
            end = System.nanoTime();

            System.out.println("sum = " + sum);
            System.out.println((end - start) + " msecs");
            System.out.println();
        }
    }

}
