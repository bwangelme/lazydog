package org.bwangel.ch1;

import org.bwangel.ch1.App;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test_sum() {
        assertEquals(Integer.valueOf(10), App.sum(3, 7));
    }

    @Test
    public void test_IsPrime() {
        assertTrue(App.IsPrime(3));
        assertFalse(App.IsPrime(4));
        assertTrue(App.IsPrime(37));
        assertTrue(App.IsPrime(47));
        assertTrue(App.IsPrime(67));
        assertTrue(App.IsPrime(97));
        assertTrue(App.IsPrime(89));
        assertTrue(App.IsPrime(103));
        assertTrue(App.IsPrime(107));
    }

    @Test
    public void test_Sqrt() {
        assertEquals(Double.valueOf(4), App.Sqrt(16.0));
        assertEquals(Double.valueOf(3.0), App.Sqrt(9.0));
        assertEquals(Double.valueOf(9.0), App.Sqrt(81.0));
    }
}
