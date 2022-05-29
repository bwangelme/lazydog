package org.bwangel.chapter1.ch1_3;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

public class TestEvaluate {
    @Test
    public void test_parseToken() {
        Evaluate e = new Evaluate();
        ArrayList<Token> tokens = e.parseTokens("1 - (-3)");
        assertEquals(6, tokens.size());
        assertEquals(tokens.get(3).type, TokenType.NEGATIVE_SIGN);

        tokens = e.parseTokens("1 + (2 + 3)*(4 * (-5))");
        assertEquals(tokens.get(12).type, TokenType.NEGATIVE_SIGN);
        assertEquals(16, tokens.size());
    }

    @Test
    public void test_ParseSqrtToken() {
        Evaluate e = new Evaluate();
        ArrayList<Token> tokens;

        tokens = e.parseTokens("1 + sqrt(9 + 7)*(4 * (-5))");
        assertEquals(tokens.get(13).type, TokenType.NEGATIVE_SIGN);
        assertEquals(17, tokens.size());
    }

    @Test
    public void test_calculate() {
        Evaluate e = new Evaluate();

        Double res = e.Calculate("(1 + (sqrt((9 + 7))*(4 * (-5))))");
        assertEquals(res, Double.valueOf("-79"));
    }
}
