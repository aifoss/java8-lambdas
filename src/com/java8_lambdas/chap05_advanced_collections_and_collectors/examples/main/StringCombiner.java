package com.java8_lambdas.chap05_advanced_collections_and_collectors.examples.main;

/**
 * Created by sofia on 12/24/16.
 */
public class StringCombiner {

    private final String delim;
    private final String prefix;
    private final String suffix;
    private final StringBuilder builder;

    public StringCombiner(String delim, String prefix, String suffix) {
        this.delim = delim;
        this.prefix = prefix;
        this.suffix = suffix;
        this.builder = new StringBuilder();
    }

    public StringCombiner add(String elem) {
        if (atStart()) {
            builder.append(prefix);
        } else {
            builder.append(delim);
        }
        builder.append(elem);
        return this;
    }

    private boolean atStart() {
        return builder.length() == 0;
    }

    public StringCombiner merge(StringCombiner other) {
//        if (other.builder.length() > 0) {
//            if (atStart()) {
//                builder.append(prefix);
//            } else {
//                builder.append(delim);
//            }
//            builder.append(other.builder, prefix.length(), other.builder.length());
//        }
        builder.append(other.builder);
        return this;
    }

    @Override
    public String toString() {
        if (atStart()) {
            builder.append(prefix);
        }
        builder.append(suffix);
        return builder.toString();
    }

}
