package org.bwangel.ch1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        if (a.length == N) resize(a.length * 2);
        a[N++] = item;
    }

    public Item pop() {
        /* 缩容
         * 这里缩容选择 1/4 的原因是，缩容后栈的容量为原来的 1/2，这样对栈 pop/push 都不容易很快导致重新扩容/缩容
         *
         * 缩容时机|缩容大小|缩容后栈的容量|可能的坏处
         * ---|---|---|---
         * 1/2|1/2|100%| push 元素会导致再次扩容
         * 1/3|1/2|66.7%| 缩容后的栈偏满，push 容易出发扩容
         * 1/4|1/2|50%| 无
         * 1/5|1/2|40%| 缩容条件较小，不容易触发，这样容易让栈很大，浪费空间
         */
        if (N == a.length / 4) {
            resize(a.length / 2);
        }
        Item res = a[--N];
        a[N] = null;
        return res;
    }

    private void resize(int newSize) {
        Item[] temp = (Item[]) new Object[newSize];
        System.arraycopy(a, 0, temp, 0, N);

        a = temp;
    }

    class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            if (i < 1) {
                throw new NoSuchElementException();
            }
            return a[--i];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }
}
