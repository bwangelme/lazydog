package org.bwangel.chapter1.ch1_3;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

public class TestDoubleNode {
    @Test
    public void test_add() {
        DoubleNode<String> l = new DoubleNode<>();

        l.AddTail("烟");
        l.AddTail("孤");
        l.AddTail("漠");
        l.AddTail("大");
        l.AddHead("直");

        for (String s : l) {
            System.out.println(s);
        }

        assertEquals(l.GetN(1), "烟");
        assertEquals(l.GetN(4), "大");
        assertNull(l.GetN(-1));
        assertNull(l.GetN(5));
        assertNull(l.GetN(6));
    }

    @Test
    public void test_remove_head() {
        DoubleNode<String> l = new DoubleNode<>();

        l.AddTail("小黑");
        l.AddTail("小花");
        assertEquals(l.Size(), 2);


        assertEquals(l.RemoveHead(), "小黑");

        assertEquals(l.GetN(0), "小花");
        assertEquals(l.Size(), 1);
    }

    @Test
    public void test_remove_tail() {
        DoubleNode<String> l = new DoubleNode<>();

        l.AddHead("小花");
        l.AddHead("小黑");
        assertEquals(l.Size(), 2);


        assertEquals(l.RemoveTail(), "小花");

        assertEquals(l.GetN(0), "小黑");
        assertEquals(l.Size(), 1);
    }

    @Test
    public void test_add_head_node() {
        DoubleNode<String> l = new DoubleNode<>();

        l.AddHead("已");
        l.AddBefore("甲", 0);
        assertEquals(l.GetN(0), "甲");
    }

    @Test
    public void test_remove_n() {
        DoubleNode<String> l = new DoubleNode<>();
        String[] data = new String[]{
                "子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"
        };
        for (String s : data) {
            l.AddTail(s);
        }

        assertEquals(l.RemoveN(4), "辰");
        assertEquals(l.GetN(4), "巳");

        assertNull(l.RemoveN(11));

        assertEquals(l.RemoveN(10), "亥");
        assertEquals(l.GetN(9), "戌");
    }

    @Test
    public void test_add_before_after() {
        DoubleNode<String> l = new DoubleNode<>();

        // add node in head
        l.AddHead("已");
        l.AddBefore("甲", 0);
        assertEquals(l.GetN(1), "已");

        // add node in tail
        l.AddAfter("戊", 1);
        assertEquals(l.GetN(2), "戊");

        // add before node in middle
        l.AddBefore("丙", 2);
        assertEquals(l.GetN(2), "丙");

        // add after node in middle
        l.AddBefore("丁", 3);
        assertEquals(l.GetN(3), "丁");

        // 天干逆序输出
        for (String s: l) {
            System.out.println(s);
        }
    }
}
