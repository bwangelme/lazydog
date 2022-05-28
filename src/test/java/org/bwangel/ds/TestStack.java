package org.bwangel.ds;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStack {
    @Test
    public void test_stack() {
        Stack<String> s = new Stack<>();

        s.Push("to");
        s.Push("be");
        s.Push("or");
        s.Push("not");
        s.Push("to");

        String val = s.pop();
        assertEquals(val, "to");

        s.Push("be");

        val = s.pop();
        assertEquals(val, "be");

        val = s.pop();
        assertEquals(val, "not");

        s.Push("that");

        val = s.pop();
        assertEquals(val, "that");
        val = s.pop();
        assertEquals(val, "or");
        val = s.pop();
        assertEquals(val, "be");

        s.Push("is");
        assertEquals(2, s.Size());
    }
}
