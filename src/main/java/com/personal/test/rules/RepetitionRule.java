package com.personal.test.rules;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Character.toUpperCase;

final class RepetitionRule implements Rule {
    private static final short MAX_REPETITION = 3;
    private static final Set<Character> REPEATABLE = new HashSet<Character>() {{
        add('I');
        add('X');
        add('C');
        add('M');
    }};
    private static final Set<Character> NON_REPEATABLE = new HashSet<Character>() {{
        add('D');
        add('L');
        add('V');
    }};

    @Override
    public boolean isValid(final char[] toValidate) {
        for (int i = 0; i < toValidate.length - 1; i++) {
            int j = i + 1;
            char current = toUpperCase(toValidate[i]);
            if (REPEATABLE.contains(current)) {
                while (j < toValidate.length && current == toUpperCase(toValidate[j])) {
                    j++;
                    if (j - i > MAX_REPETITION) {
                        return false;
                    }
                }

            } else if (NON_REPEATABLE.contains(current)) {
                if (current == toUpperCase(toValidate[j])) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
