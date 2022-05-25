package org.bwangel.ch1_3;

/**
 * 算数表达式中的 Token 类型
 * <p>
 * + - * / 数字 sqrt 正号 负号
 * <p>
 * 数字目前只支持整数
 */
enum TokenType {
    PLUS, MINUS, MULTIPLY, DIV, DIGIT, SQRT, POSITIVE_SIGN, NEGATIVE_SIGN, LBRACKET, RBRACKET,
}

class Token {
    public TokenType type = null;
    public String value = null;

    Token(TokenType type) {
        this.type = type;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("<Token ");
        res.append(this.type);
        if (this.value != null) {
            res.append("(");
            res.append(this.value);
            res.append(")");
        }
        res.append(">");

        return res.toString();
    }

    Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    public static Token PLUS() {
        return new Token(TokenType.PLUS);
    }

    public static Token MINUS() {
        return new Token(TokenType.MINUS);
    }

    public static Token MULTIPLY() {
        return new Token(TokenType.MULTIPLY);
    }

    public static Token DIV() {
        return new Token(TokenType.DIV);
    }

    public static Token DIGIT(String number) {
        return new Token(TokenType.DIGIT, number);
    }

    public static Token SQRT() {
        return new Token(TokenType.SQRT);
    }

    public static Token POSITIVE_SIGN() {
        return new Token(TokenType.POSITIVE_SIGN);
    }

    public static Token NEGATIVE_SIGN() {
        return new Token(TokenType.NEGATIVE_SIGN);
    }

    public static Token LBRACKET() {
        return new Token(TokenType.LBRACKET);
    }

    public static Token RBRACKET() {
        return new Token(TokenType.RBRACKET);
    }
}
