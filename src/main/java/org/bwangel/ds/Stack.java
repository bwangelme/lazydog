package org.bwangel.ds;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * 用链表实现的栈
 */
public class Stack<Item> implements Iterable<Item> {
    private class Node {
        Item item = null;
        Node next = null;
    }

    private int N;
    private Node first;
    // 进行 push / pop 操作的次数
    private int opCount;

    public boolean IsEmpty() {
        return first == null;
    }

    public int Size() {
        return N;
    }

    public void Push(Item item) {
        Node oldFirst = first;
        first = new Node();

        first.item = item;
        first.next = oldFirst;
        N++;
        opCount++;
    }

    private class StackIterator implements Iterator<Item> {
        private Node current = first;
        private int opCnt = opCount;

        public boolean hasNext() {
            if (opCnt != opCount) {
                throw new ConcurrentModificationException();
            }
            return current != null;
        }

        public Item next() {
            if (opCnt != opCount) {
                throw new ConcurrentModificationException();
            }

            if (current == null) {
                return null;
            }

            Item ret = current.item;
            current = current.next;

            return ret;

        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    public Item Pop() {
        if (this.IsEmpty()) {
            throw new EmptyStackException();
        }

        Node oldFirst = first;
        first = first.next;

        Item val = oldFirst.item;
        oldFirst.next = null;


        N--;
        opCount++;
        return val;
    }

}
