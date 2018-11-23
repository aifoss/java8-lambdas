package com.java8_lambdas.chap05_advanced_collections_and_collectors.examples.main;

import com.java8_lambdas.chap01_introduction.examples.Album;
import com.java8_lambdas.chap01_introduction.examples.Artist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sofia on 12/24/16.
 */
public class CollectionNiceties {

    abstract static class ArtistService {
        protected Map<String, Artist> artistCache = new HashMap<>();

        public abstract Artist getArtist(String name);

        protected Artist readArtistFromDB(String name) {
            return new Artist(name, "UK");
        }
    }

    static class OldArtistService extends ArtistService {
        @Override
        public Artist getArtist(String name) {
            Artist artist = artistCache.get(name);
            if (artist == null) {
                artist = readArtistFromDB(name);
                artistCache.put(name, artist);
            }
            return artist;
        }
    }

    static class NewArtistService extends ArtistService {
        @Override
        public Artist getArtist(String name) {
            return artistCache.computeIfAbsent(name, this::readArtistFromDB);
        }
    }

    static class Java7Count {

        public Map<Artist, Integer> getAlbumCountsByArtist(Map<Artist, List<Album>> albumsByArtist) {
            Map<Artist, Integer> albumCountsByArtist = new HashMap<>();

            for (Map.Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
                Artist artist = entry.getKey();
                List<Album> albums = entry.getValue();
                albumCountsByArtist.put(artist, albums.size());
            }

            return albumCountsByArtist;
        }
    }

    static class Java8Count {

        public Map<Artist, Integer> getAlbumCountsByArtist(Map<Artist, List<Album>> albumsByArtist) {
            Map<Artist, Integer> albumCountsByArtist = new HashMap<>();
            albumsByArtist.forEach((artist, albums) -> albumCountsByArtist.put(artist, albums.size()));
            return albumCountsByArtist;
        }
    }


    public static void main(String[] args) {
        new OldArtistService().getArtist(null);
        new NewArtistService().getArtist(null);
        new Java7Count().getAlbumCountsByArtist(null);
        new Java8Count().getAlbumCountsByArtist(null);
    }

}
