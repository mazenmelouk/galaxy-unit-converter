package com.personal.test;

import java.util.Map;

import static com.personal.test.rules.RulesConstants.VALID_SUBTRACTION_PAIRS;

final class RomanExpressionEvaluator {

    static long evaluate(final char[] romanExpression) {
        String expression = new String(romanExpression).toUpperCase();
        long sum = 0;
        for (Map.Entry<String, Integer> entry : VALID_SUBTRACTION_PAIRS.entrySet()) {
            String pair = entry.getKey();
            if (expression.contains(pair)) {
                int oldLen = expression.length();
                expression = expression.replace(pair, "");
                sum += (oldLen - expression.length()) / 2 * entry.getValue();
            }
        }
        for (char c : expression.toCharArray()) {
            sum += CharToRomanLiteralConverter.convertRomanToDecimal(c);
        }
        return sum;
    }

}
