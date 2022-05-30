package org.bwangel.ds;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestBag {
    @Test
    public void test_bag() {
        Bag<String> bag = new Bag<>();

        bag.Add("圆");
        bag.Add("日");
        bag.Add("落");
        bag.Add("河");
        bag.Add("长");

        for(String s : bag) {
            System.out.println(s);
            if(s.equals("圆")) {
                return;
            }
        }

        fail("圆 should in bag");
    }
}
