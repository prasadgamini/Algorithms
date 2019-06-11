package edu.algo.math;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilTest {

    @Test
    public void testComputeGCD() {
        assertEquals(10, Util.computeGCD(10,20));
    }

    @Test
    public void testComputeGCD2() {
        assertEquals(20, Util.computeGCD(20,20));
    }


    @Test
    public void testComputeGCD3() {
        assertEquals(50, Util.computeGCD(100,250));
    }

    @Test
    public void testComputeGCD4() {
        assertEquals(14, Util.computeGCD(98,56));
    }
}