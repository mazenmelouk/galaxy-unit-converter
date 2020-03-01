package com.personal.test.rules;

import static com.personal.test.CharToRomanLiteralConverter.convertRomanToDecimal;
import static com.personal.test.rules.RulesConstants.VALID_SUBTRACTION_PAIRS;

final class OrderRule implements Rule {

    @Override
    public boolean isValid(final char[] toValidate) {
        String test = new String(toValidate).toUpperCase();
        for (String pair : VALID_SUBTRACTION_PAIRS.keySet()) {
            test = test.replace(pair, pair.substring(1));
        }
        char[] replacedChars = test.toCharArray();
        for (int i = 0; i < replacedChars.length - 1; i++) {
            if (convertRomanToDecimal(replacedChars[i]) <
                    convertRomanToDecimal(replacedChars[i + 1])) {
                return false;
            }
        }
        return true;
    }
}
