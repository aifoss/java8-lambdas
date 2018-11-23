package com.java8_lambdas.chap08_design_and_architectural_principles.examples.SOLID_principle;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sofia on 12/25/16.
 */
public class OpenClosedPrinciple {

    public static void asHigherOrderFunctions() {
        ThreadLocal<DateFormat> localFormatter = ThreadLocal.withInitial(() -> new SimpleDateFormat());
        DateFormat formatter = localFormatter.get();
        System.out.println(formatter.format(new Date()));

        AtomicInteger threadId = new AtomicInteger();
        ThreadLocal<Integer> localId = ThreadLocal.withInitial(() -> threadId.getAndIncrement());
        int idForThisThread = localId.get();
        System.out.println(idForThisThread+": "+Thread.currentThread().getName());
    }


    public static void main(String... args) {
        asHigherOrderFunctions();
    }

}
