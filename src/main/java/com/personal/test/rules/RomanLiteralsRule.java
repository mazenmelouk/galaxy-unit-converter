package com.personal.test.rules;


import static com.personal.test.CharToRomanLiteralConverter.isValidRomanLiteral;

class RomanLiteralsRule implements Rule {
    @Override
    public boolean isValid(final char[] toValidate) {
        for (char c : toValidate) {
            if (!isValidRomanLiteral(c)) {
                return false;
            }
        }
        return toValidate.length != 0;
    }
}
