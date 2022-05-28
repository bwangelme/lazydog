package org.bwangel.ds;

import java.util.EmptyStackException;

/**
 * 用链表实现的栈
 */
public class Stack<Item> {
    private class Node {
        Item item = null;
        Node next = null;
    }

    private int N;
    private Node first;

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
    }

    public Item pop() {
        if (this.IsEmpty()) {
            throw new EmptyStackException();
        }

        Item val = first.item;
        first = first.next;

        N--;
        return val;
    }

}
