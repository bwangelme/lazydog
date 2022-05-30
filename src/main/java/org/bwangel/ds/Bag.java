package org.bwangel.ds;

import java.util.Iterator;

/**
 * 背包数据结构
 * @param <Item>
 */
public class Bag<Item> implements Iterable<Item> {
    private class Node {
        Item item = null;
        Node next = null;

        public Node(Item item) {
            this.item = item;
            this.next = null;
        }
    }

    private int N = 0;
    private Node first = null;

    public int Size() {
        return N;
    }

    public void Add(Item item) {
        Node node = new Node(item);
        node.next = first;
        first = node;
        N++;
    }

    public Iterator<Item> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (current == null) {
                return null;
            }
            Item ret = current.item;
            current = current.next;
            return ret;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
