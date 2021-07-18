package com.tenexperts.summatra.array;

/**
 * Class for calculation max sum in pairs
 */
public class PairSummater implements IArraySummater {
    /**
     * Returns max pair sum
     *
     * @param numbers - int array with numbers
     * @return maxSum - max pair sum
     * @throws ArraySummaterException - throws when the error occurs
     */
    public int sum(final int[] numbers) throws ArraySummaterException {
        if (numbers.length == 1) {
            throw new ArraySummaterException("Length is 0");
        }
        if (numbers.length % 2 != 0) {
            throw new ArraySummaterException("The array length must be even");
        }

        int maxSum = 0;
        for (int i = 0; i < numbers.length - 1; i += 2) {
            int currentSum = numbers[i] + numbers[i + 1];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
    }
}
