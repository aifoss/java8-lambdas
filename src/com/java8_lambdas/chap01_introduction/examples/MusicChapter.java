package com.java8_lambdas.chap01_introduction.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sofia on 12/24/16.
 */
public abstract class MusicChapter {

    protected final List<Artist> artists;
    protected final List<Album> albums;

    public MusicChapter() {
        artists = new ArrayList<>();
        albums = new ArrayList<>();
        loadData("");
    }

    private void loadData(String file) {

    }

}
