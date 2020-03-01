package com.personal.test;

import java.util.HashMap;
import java.util.Map;

import static com.personal.test.RomanLiteral.C;
import static com.personal.test.RomanLiteral.D;
import static com.personal.test.RomanLiteral.I;
import static com.personal.test.RomanLiteral.L;
import static com.personal.test.RomanLiteral.M;
import static com.personal.test.RomanLiteral.V;
import static com.personal.test.RomanLiteral.X;
import static java.lang.Character.toUpperCase;

public final class CharToRomanLiteralConverter {
    private static final Map<Character, RomanLiteral> CONVERSION = new HashMap<Character, RomanLiteral>() {
        {
            put('I', I);
            put('V', V);
            put('X', X);
            put('L', L);
            put('C', C);
            put('D', D);
            put('M', M);
        }
    };

    private CharToRomanLiteralConverter() {
    }

    public static int convertRomanToDecimal(final Character character) {
        return CONVERSION.get(toUpperCase(character)).getValue();
    }

    public static boolean isValidRomanLiteral(final Character character) {
        return CONVERSION.containsKey(toUpperCase(character));
    }
}