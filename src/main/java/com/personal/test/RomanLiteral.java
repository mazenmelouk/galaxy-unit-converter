package com.personal.test;

enum RomanLiteral {
    I(1), V(5),
    X(10), L(50),
    C(100), D(500),
    M(1000);
    private final int value;

    RomanLiteral(int value) {
        this.value = value;
    }

    int getValue() {
        return this.value;
    }
}
