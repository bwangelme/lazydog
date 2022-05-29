package org.bwangel.ds;

import jdk.jshell.spi.ExecutionControl;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
    private class Node {
        Item item = null;
        Node next = null;
    }

    private Node first = null;
    private Node last = null;
    private int N = 0;

    public boolean IsEmpty() {
        return first == null || N == 0;
    }

    public int Size() {
        return N;
    }

    public void Enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;

        if (IsEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public Item Dequeue() {
        if (IsEmpty()) {
            throw new EmptyQueueException();
        }

        Node oldFirst = first;
        Item ret = oldFirst.item;
        first = oldFirst.next;
        oldFirst.next = null;
        N--;

        if (IsEmpty()) {
            last = null;
        }

        return ret;
    }

    private class QueueIterator implements Iterator<Item> {
        private Node node = first;

        public boolean hasNext() {
            return node != null;
        }

        public Item next() {
            if (node == null) {
                return null;
            }

            Item ret = node.item;
            node = node.next;

            return ret;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<Item> iterator() {
        return new QueueIterator();
    }
}
