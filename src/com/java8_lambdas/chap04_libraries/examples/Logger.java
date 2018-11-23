package com.java8_lambdas.chap04_libraries.examples;

import java.util.function.Supplier;

/**
 * Created by sofia on 12/24/16.
 */
public class Logger {

    private boolean debug = true;

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public boolean isDebugEnabled() {
        return debug;
    }

    public void debug(String message) {
        if (isDebugEnabled()) {
            System.out.println(message);
        }
    }

    public void debugOptimized() {
        Logger logger = new Logger();
        if (logger.isDebugEnabled()) {
            logger.debug("Look at this: " + expensiveOperation());
        }
    }

    public void debug(Supplier<String> message) {
        if (isDebugEnabled()) {
            debug(message.get());
        }
    }

    public void debugLambda() {
        Logger logger = new Logger();
        logger.debug(() -> "Look at this: "+expensiveOperation());
    }

    private String expensiveOperation() {
        return "";
    }

}
