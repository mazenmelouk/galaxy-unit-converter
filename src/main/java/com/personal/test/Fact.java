package com.personal.test;

import java.util.Arrays;
import java.util.Objects;

final class Fact {
    private final String[] tokens;
    private final String result;

    Fact(final String[] tokens, final String result) {
        this.tokens = tokens;
        this.result = result;
    }

    public String[] getTokens() {
        return tokens;
    }

    public String getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fact fact = (Fact) o;
        return Arrays.equals(tokens, fact.tokens) &&
                Objects.equals(result, fact.result);
    }

    @Override
    public int hashCode() {
        int result1 = Objects.hash(result);
        result1 = 31 * result1 + Arrays.hashCode(tokens);
        return result1;
    }
}
