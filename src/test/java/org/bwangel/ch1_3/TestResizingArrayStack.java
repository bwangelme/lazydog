package org.bwangel.ch1_3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestResizingArrayStack {
    @Test
    public void test_stack() {
        ResizingArrayStack<Integer> s = new ResizingArrayStack<>();

        s.push(1);
        s.push(3);
        s.push(4);
        s.push(2);

        assertEquals(s.size(), 4);
        assertEquals(s.pop(), Integer.valueOf(2));

        /*
         期望的输出是 4, 3, 1
         */
        for (Integer i : s) {
            System.out.println(i);
        }
        s.pop();
        s.pop();
        s.pop();

        assertTrue(s.isEmpty());
    }
}
