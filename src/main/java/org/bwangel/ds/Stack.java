package org.bwangel.ds;

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

    public Item Pop() {
        if (this.IsEmpty()) {
            throw new EmptyStackException();
        }

        Node oldFirst = first;
        first = first.next;

        Item val = oldFirst.item;
        oldFirst.next = null;


        N--;
        return val;
    }

}
