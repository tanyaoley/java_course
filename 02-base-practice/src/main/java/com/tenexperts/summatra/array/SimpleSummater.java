package com.tenexperts.summatra.array;

/**
 * Class for calculation the sum of each element in the array.
 */
public class SimpleSummater implements IArraySummater {
    /**
     * Returns the sum of each element in the array.
     *
     * @param numbers - int array with numbers
     * @return sum - sum of each element in the array
     * @throws ArraySummaterException - throws when the error occurs
     */
    public int sum(final int[] numbers) throws ArraySummaterException {
        if (numbers.length == 1) {
            throw new ArraySummaterException("Length is 0");
        }
        int sum = 0;
        for (int elem :numbers) {
            sum += elem;
        }
        return sum;
    }
}
