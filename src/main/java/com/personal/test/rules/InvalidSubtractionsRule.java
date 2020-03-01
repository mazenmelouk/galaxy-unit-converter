package com.personal.test.rules;

import java.util.HashSet;
import java.util.Set;

final class InvalidSubtractionsRule implements Rule {
    private static final Set<String> INVALID_PAIRS = new HashSet<String>() {{
        add("VX");
        add("VL");
        add("VC");
        add("VD");
        add("VM");
        add("IL");
        add("IC");
        add("ID");
        add("IM");
        add("LC");
        add("LD");
        add("LM");
        add("XD");
        add("XM");
        add("DM");
    }};

    @Override
    public boolean isValid(final char[] toValidate) {
        String test = new String(toValidate).toUpperCase();
        for (String s : RulesConstants.VALID_SUBTRACTION_PAIRS.keySet()) {
            test = test.replace(s, "");
        }
        return INVALID_PAIRS.stream().noneMatch(test::contains);
    }
}
