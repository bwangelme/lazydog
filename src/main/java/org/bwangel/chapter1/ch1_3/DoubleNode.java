package org.bwangel.chapter1.ch1_3;

import java.util.Iterator;

/**
 * 这是习题 1.3.31 的解答，实现一个双向链表
 */
public class DoubleNode<Item> implements Iterable<Item> {
    private class Node {
        Item item = null;
        Node prev = null;
        Node next = null;

        private Node(Item item) {
            this.item = item;
            this.next = null;
            this.prev = null;

        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("<");
            sb.append(item);
            sb.append(">");
            return sb.toString();
        }
    }

    private int N = 0;
    private Node head = null;
    private Node tail = null;

    public boolean IsEmpty() {
        return head == null && N == 0;
    }

    public void AddHead(Item item) {
        Node n = new Node(item);
        if (IsEmpty()) {
            head = n;
            tail = head;
            return;
        }

        head.prev = n;
        n.next = head;
        head = n;
        N++;
    }

    public void AddTail(Item item) {
        Node n = new Node(item);
        if (IsEmpty()) {
            tail = n;
            head = tail;
            return;
        }

        tail.next = n;
        n.prev = tail;
        tail = n;
        N++;
    }

    private Node getNodeN(int N) {
        int index = 0;
        Node current = head;

        while (current != null && index < N) {
            current = current.next;
            index++;
        }

        if (current == null) {
            return null;
        }

        if (index != N) {
            return null;
        }

        return current;
    }

    public Item GetN(int N) {
        Node node = getNodeN(N);
        if (node == null) {
            return null;
        }

        return node.item;
    }

    public Item RemoveHead() {
        if (IsEmpty()) {
            return null;
        }

        Node oldHead = head;

        head = head.next;
        head.prev = null;

        oldHead.next = null;
        N--;

        return oldHead.item;
    }

    public int Size() {
        return N;
    }

    public Item RemoveTail() {
        if (IsEmpty()) {
            return null;
        }

        Node oldTail = tail;
        tail = tail.prev;
        tail.next = null;

        oldTail.prev = null;
        N--;

        return oldTail.item;
    }

    public Item RemoveN(int N) {
        Node n = getNodeN(N);

        if (n == null) {
            return null;
        }

        if (n.prev != null) {
            n.prev.next = n.next;
        }

        if (n.next != null) {
            n.next.prev = n.prev;
        }

        this.N--;
        return n.item;
    }

    public void AddAfter(Item item, int N) {
        Node newNode = new Node(item);
        Node node = getNodeN(N);

        if (node == null) {
            throw new DoubleNodeIndexError();
        }

        newNode.prev = node;
        newNode.next = node.next;
        if (node.next != null) {
            node.next.prev = newNode;
        } else {
            // node is tail
            tail = newNode;
        }
        node.next = newNode;
        this.N++;
    }

    public void AddBefore(Item item, int N) {
        Node newNode = new Node(item);
        Node node = getNodeN(N);

        if (node == null) {
            throw new DoubleNodeIndexError();
        }

        newNode.next = node;
        newNode.prev = node.prev;

        if (node.prev != null) {
            node.prev.next = newNode;
        } else {
            // node is head
            head = newNode;
        }
        node.prev = newNode;
        this.N++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseDoubleNodeIterator();
    }

    public class ReverseDoubleNodeIterator implements Iterator<Item> {
        private Node current = tail;


        @Override
        public Item next() {
            if (current == null) {
                return null;
            }

            Item ret = current.item;
            current = current.prev;
            return ret;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
