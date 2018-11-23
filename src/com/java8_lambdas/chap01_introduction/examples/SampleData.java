package com.java8_lambdas.chap01_introduction.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by sofia on 12/24/16.
 */
public class SampleData {

    public static final Artist johnColtrane = new Artist("Jon Coltrane", "US");
    public static final Artist johnLennon = new Artist("John Lennon", "UK");
    public static final Artist paulMcCartney = new Artist("Paul McCartney", "UK");
    public static final Artist georgeHarrison = new Artist("George Harrison", "UK");
    public static final Artist ringoStarr = new Artist("Ringo Starr", "UK");

    public static final List<Artist> membersOfTheBeatles = Arrays.asList(johnLennon, paulMcCartney, georgeHarrison, ringoStarr);

    public static final Artist theBeatles = new Artist("The Beatles", membersOfTheBeatles, "UK");

    public static final Album aLoveSupreme = new Album("A Love Supreme",
            Arrays.asList(new Track("Acknowledgement", 467), new Track("Resolution", 442)),
            Arrays.asList(johnColtrane));
    public static final Album sampleShortAlbum = new Album("Sample Short Album",
            Arrays.asList(new Track("Short Track", 30)),
            Arrays.asList(johnColtrane));
    public static final Album manyTrackAlbum = new Album("Many Track Album",
            Arrays.asList(new Track("Short Track 1", 30), new Track("Short Track 2", 30), new Track("Short Track 3", 30),
                    new Track("Short Track 4", 30), new Track("Short Track 5", 30)),
            Arrays.asList(johnColtrane));
    public static final Album mixedAlbum = new Album("Mixed Album",
            Arrays.asList(new Track("John Coltrane Song", 100), new Track("The Beatles Song", 200)),
            Arrays.asList(johnColtrane, theBeatles));

    public static final Stream<Album> albums = Stream.of(aLoveSupreme);
    public static final List<Album> allAlbumList = Arrays.asList(aLoveSupreme, sampleShortAlbum, manyTrackAlbum, mixedAlbum);

    public static final Stream<Artist> threeArtists = Stream.of(johnColtrane, johnLennon, theBeatles);
    public static final List<Artist> threeArtistList = Arrays.asList(johnColtrane, johnLennon, theBeatles);

}
