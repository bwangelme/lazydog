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

        String val = s.Pop();
        assertEquals(val, "to");

        s.Push("be");

        val = s.Pop();
        assertEquals(val, "be");

        val = s.Pop();
        assertEquals(val, "not");

        s.Push("that");

        val = s.Pop();
        assertEquals(val, "that");
        val = s.Pop();
        assertEquals(val, "or");
        val = s.Pop();
        assertEquals(val, "be");

        s.Push("is");
        assertEquals(2, s.Size());
    }

    @Test
    public void test_empty_stack_exception() {
        Stack<String> s = new Stack<>();

        assertTrue(s.IsEmpty());

        try {
            s.Pop();
        } catch (EmptyStackException e) {
            return;
        }

        fail("I should get EmptyStackException");
    }

    @Test
    public void test_stack_iter() {
        Stack<String> s = new Stack<>();

        s.Push("to");
        s.Push("be");
        s.Push("or");
        s.Push("not");
        s.Push("to");

        // 期待的输出
        // to not or be to
        for (String item : s) {
            System.out.println(item);
        }
    }
}
