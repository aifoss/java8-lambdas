package com.java8_lambdas.chap02_lambda_expressions.exercises;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;

/**
 * Created by sofia on 12/24/16.
 */
public class Chapter2 {

    // 2.1 Thread-safe DateFormatter
    public static final ThreadLocal<DateFormatter> formatter = ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy")));

}
