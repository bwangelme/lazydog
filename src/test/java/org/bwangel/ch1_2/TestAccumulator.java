package org.bwangel.ch1_2;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TestAccumulator {
    @Test
    public void test_mean() {
        Accumulator a = new Accumulator();
        for (Integer i : Arrays.asList(1, 3, 5)) {
            a.AddNumber(i);
        }

        assertEquals(a.Mean(), new Double(3));
    }

    @Test
    public void test_var() {
        Accumulator a = new Accumulator();
        for (Integer i : Arrays.asList(9, 2, 5, 4, 12, 7)) {
            a.AddNumber(i);
        }

        assertEquals(a.Var(), new Double(13.1));
    }
}
