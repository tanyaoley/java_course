package com.tenexperts.summatra.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SimpleSummaterTest {
    private SimpleSummater simple;
    @Before
    public void setUp(){
        simple = new SimpleSummater();
    }

    @Test
    public void testSum() throws ArraySummaterException{
        int[] inputArray = {1,2,3,4};
        int sum = simple.sum(inputArray);
        assertEquals(10, sum);
    }

    @Test
    public void testSumWithZeros() throws ArraySummaterException{
        int[] inputArray = {0,0,0,0};
        int sum = simple.sum(inputArray);
        assertEquals(0, sum);
    }

    @Test
    public void testEmpty(){
        try {
            simple.sum(new int[]{});
        } catch (Exception ex) {
            assertThat(ex.getMessage(), is("Length is 0"));
        }
    }
}
