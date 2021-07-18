package com.tenexperts.summatra.array;

/**
 * Interface for arrays summater
 */
public interface IArraySummater {
    /**
     * Returns sum for array
     *
     * @param numbers - int array with numbers
     * @return int - result of sum
     * @throws ArraySummaterException - throws when the error occurs
     */
    int sum(int[] numbers) throws ArraySummaterException;
}
