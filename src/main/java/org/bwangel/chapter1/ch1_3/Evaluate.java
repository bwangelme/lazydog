package org.bwangel.chapter1.ch1_3;

import edu.princeton.cs.algs4.Stack;

import java.util.ArrayList;

public class Evaluate {
    /**
     * 解析算数表达式的 token 流，支持的字符是
     * <p>
     * + - * / ( ) sqrt 数字
     *
     * @param expression 算数表达式
     * @return token流
     */
    public ArrayList<Token> parseTokens(String expression) {
        ArrayList<Token> res = new ArrayList<>();
        int i = 0;
        char preCh = 0;

        while (i < expression.length()) {
            char ch = expression.charAt(i);
            switch (ch) {
                case '+':
                    if (preCh == '(') {
                        res.add(Token.POSITIVE_SIGN());
                    } else {
                        res.add(Token.PLUS());
                    }
                    break;
                case '-':
                    if (preCh == '(') {
                        res.add(Token.NEGATIVE_SIGN());
                    } else {
                        res.add(Token.MINUS());
                    }
                    break;
                case '*':
                    res.add(Token.MULTIPLY());
                    break;
                case '/':
                    res.add(Token.DIV());
                    break;
                case '(':
                    res.add(Token.LBRACKET());
                    break;
                case ')':
                    res.add(Token.RBRACKET());
                    break;
                case 's':
                    String op = expression.substring(i, i + 4);
                    if (!op.equals("sqrt")) {
                        throw new RuntimeException("Invalid operator" + op);
                    }
                    res.add(Token.SQRT());
                    i = i + 3;
                    break;
                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9':
                    StringBuilder val = new StringBuilder();
                    val.append(ch);
                    while (true) {
                        i = i + 1;
                        Character c = expression.charAt(i);
                        if (Character.isDigit(c)) {
                            val.append(c);
                        } else {
                            i = i - 1;
                            break;
                        }
                    }

                    res.add(Token.DIGIT(val.toString()));
                    break;
                case ' ', '\t':
                    break;
                default:
                    throw new RuntimeException("Invalid input");
            }

            preCh = ch;
            i++;
        }
        return res;
    }

    /**
     * 计算算数表达式的值
     *
     * 这种算法不支持优先级比较，每次计算都需要用括号括起来，例如 1+2 需要写成 (1+2)
     *
     * @param expression 算术表达式
     * @return 结果
     */
    public Double Calculate(String expression) {
        ArrayList<Token> tokens = this.parseTokens(expression);
        Stack<Token> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        for (Token t : tokens) {
            switch (t.type) {
                case LBRACKET:
                    break;
                case DIGIT:
                    vals.push(Double.parseDouble(t.value));
                    break;
                case PLUS, MINUS, MULTIPLY, DIV, SQRT,NEGATIVE_SIGN,POSITIVE_SIGN:
                    ops.push(t);
                    break;
                case RBRACKET:
                    Token op = ops.pop();
                    Double v = vals.pop();
                    if (op.type == TokenType.PLUS) v = vals.pop() + v;
                    if (op.type == TokenType.MINUS) v = vals.pop() - v;
                    if (op.type == TokenType.MULTIPLY) v = vals.pop() * v;
                    if (op.type == TokenType.DIV) v = vals.pop() / v;
                    if (op.type == TokenType.SQRT) v = Math.sqrt(v);
                    if (op.type == TokenType.POSITIVE_SIGN) v = +(v);
                    if (op.type == TokenType.NEGATIVE_SIGN) v = -(v);

                    vals.push(v);
                    break;
                default:
                    throw new RuntimeException("Invalid Token" + t);
            }
        }

        return vals.pop();
    }

}


