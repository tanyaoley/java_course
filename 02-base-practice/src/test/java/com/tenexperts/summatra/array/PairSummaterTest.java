package com.tenexperts.summatra.array;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PairSummaterTest {
    private PairSummater pair;
    @Before
    public void setUp(){
        pair = new PairSummater();
    }

    @Test
    public void testMaxSum() throws ArraySummaterException{
        int[] inputArray = {10, 2, -3, 40};
        int sum = pair.sum(inputArray);
        assertEquals(37, sum);
    }

    @Test
    public void testMaxSumZeros() throws ArraySummaterException{
        int[] inputArray = {0,0,0,0};
        int sum = pair.sum(inputArray);
        assertEquals(0, sum);
    }

    @Test
    public void testOddLen(){
        int[] inputArray = {10,2,3};
        try {
            pair.sum(inputArray);
        } catch (Exception ex) {
            assertThat(ex.getMessage(), is("The array length must be even"));
        }
    }

    @Test
    public void testEmpty(){
        try {
            pair.sum(new int[]{});
        } catch (Exception ex) {
            assertThat(ex.getMessage(), is("Length is 0"));
        }
    }

}
