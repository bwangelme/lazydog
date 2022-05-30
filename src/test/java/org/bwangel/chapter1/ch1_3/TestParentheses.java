package org.bwangel.chapter1.ch1_3;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestParentheses {
    @Test
    public void test_match() {
        assertTrue(Parentheses.match("([{<>}])(){}"));
        assertFalse(Parentheses.match("([{<>}][)](){}"));
    }
}
