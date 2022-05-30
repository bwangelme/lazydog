package org.bwangel.chapter1.ch1_3;

import org.bwangel.ds.Stack;

import java.util.HashMap;

/**
 * 此程序是习题 1.3.4 的解答
 * <p>
 * 输入一串字符给 match 函数，判断其中的左右括号是否相符合
 */
public class Parentheses {
    public static boolean match(String str) {
        Stack<Character> Brackets = new Stack<>();
        char[] charArray = str.toCharArray();

        for (char c : charArray) {
            switch (c) {
                case ')', '}', ']', '>' -> {
                    Character left = Brackets.Pop();
                    if (!isBracketsMatch(left, c)) {
                        return false;
                    }
                }
                default -> Brackets.Push(c);
            }
        }

        return true;
    }

    public static boolean isBracketsMatch(Character left, Character right) {
        HashMap<Character, Character> bracketsMap = new HashMap<>() {{
            put('[', ']');
            put('(', ')');
            put('{', '}');
            put('<', '>');
        }};

        return bracketsMap.get(left) == right;
    }
}
