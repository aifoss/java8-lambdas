package com.java8_lambdas.chap09_lambda_enabled_concurrency.exercises;

import com.java8_lambdas.chap01_introduction.examples.Artist;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by sofia on 12/25/16.
 */
public class CompletableFutureArtistAnalyzer implements ArtistAnalyzer {

    private final Function<String, Artist> artistLookupService;

    public CompletableFutureArtistAnalyzer(Function<String, Artist> artistLookupService) {
        this.artistLookupService = artistLookupService;
    }

    @Override
    public void isLargerGroup(String artistName, String otherArtistName, Consumer<Boolean> handler) {
        CompletableFuture<Long> otherArtistMemberCount = CompletableFuture.supplyAsync(() -> getNumberOfMembers(otherArtistName));
        CompletableFuture<Long> artistMemberCount = CompletableFuture.supplyAsync(() -> getNumberOfMembers(artistName));

        artistMemberCount
                .thenCombine(otherArtistMemberCount, (count, otherCount) -> count > otherCount)
                .thenAccept(handler::accept);
    }

    private long getNumberOfMembers(String artistName) {
        return artistLookupService.apply(artistName)
                .getMembers()
                .count();
    }

}
