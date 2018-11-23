package com.java8_lambdas.chap05_advanced_collections_and_collectors.examples.more;

import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by sofia on 12/24/16.
 */
public class CollectorExpansion {

    public static final Collector<AlbumSale, ?, AlbumSalesReport> reportingAlbumSales() {
        return Collectors.reducing(new AlbumSalesReport(), sale -> new AlbumSalesReport(sale), (left, right) -> left.merge(right));
    }

}
