package com.tenexperts.summatra;

import com.tenexperts.summatra.array.ArraySummaterException;
import com.tenexperts.summatra.array.SimpleSummater;

/**
 * Main class
 */
public final class Main {

    private Main(){
    }
    /**
     * Entry point
     *
     * @param args - entry point arguments
     * @throws ArraySummaterException - throws when the error occurs
     */
    public static void main(final String[] args) throws ArraySummaterException {
        SimpleSummater summater = new SimpleSummater();
        int[] inputArray = new int[] {1, 2, 0, -1};
        System.out.println(summater.sum(inputArray));
    }
}
