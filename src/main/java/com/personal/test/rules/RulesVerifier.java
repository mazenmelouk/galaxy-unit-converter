package com.personal.test.rules;

import java.util.LinkedList;
import java.util.List;

public final class RulesVerifier {
    private static final List<Rule> RULES = new LinkedList<Rule>() {{
        add(new RomanLiteralsRule());
        add(new RepetitionRule());
        add(new InvalidSubtractionsRule());
        add(new OrderRule());
    }};

    private RulesVerifier() {
    }

    public static void verifyRules(final char[] expression) {
        RULES.forEach(rule -> {
            if (!rule.isValid(expression)) {
                throw new IllegalArgumentException("Rule " + rule.getClass().getName() + " failed for expression "
                        + new String(expression));
            }
        });
    }
}
