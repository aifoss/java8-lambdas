package com.java8_lambdas.chap05_advanced_collections_and_collectors.examples.more;

import com.java8_lambdas.chap01_introduction.examples.Album;

/**
 * Created by sofia on 12/24/16.
 */
public final class AlbumSale {

    private final Album album;
    private final Customer customer;
    private final long price;

    public AlbumSale(Album album, Customer customer, long price) {
        this.album = album;
        this.customer = customer;
        this.price = price;
    }

    public Album getAlbum() {
        return album;
    }

    public Customer getCustomer() {
        return customer;
    }

    public long getPrice() {
        return price;
    }

}
