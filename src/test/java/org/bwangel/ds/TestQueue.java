package org.bwangel.ds;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestQueue {
    @Test
    public void test_queue_iter() {
        Queue<String> q = new Queue<>();

        q.Enqueue("to");
        q.Enqueue("be");
        q.Enqueue("or");
        q.Enqueue("not");
        q.Enqueue("to");

        // 期待的输出如下
        // to
        // be
        // or
        // not
        // to
        for (String s : q) {
            System.out.println(s);
        }

        assertEquals(5, q.Size());
    }


    @Test
    public void test_queue() {
        Queue<String> q = new Queue<>();

        q.Enqueue("to");
        q.Enqueue("be");
        q.Enqueue("or");
        q.Enqueue("not");
        q.Enqueue("to");

        assertEquals(q.Dequeue(), "to");

        q.Enqueue("be");

        assertEquals(q.Dequeue(), "be");
        assertEquals(q.Dequeue(), "or");

        q.Enqueue("that");

        assertEquals(q.Dequeue(), "not");
        assertEquals(q.Dequeue(), "to");
        assertEquals(q.Dequeue(), "be");

        q.Enqueue("is");

        assertEquals(q.Size(), 2);
    }

    @Test
    public void test_dequeue_exception() {
        Queue<String> q = new Queue<>();

        assertTrue(q.IsEmpty());

        try {
            q.Dequeue();
        } catch (EmptyQueueException e) {
            return;
        }

        fail("I should get EmptyQueueException");
    }

}
