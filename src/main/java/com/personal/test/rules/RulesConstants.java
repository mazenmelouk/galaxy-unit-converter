package com.personal.test.rules;

import java.util.HashMap;
import java.util.Map;

public class RulesConstants {
    public static final Map<String, Integer> VALID_SUBTRACTION_PAIRS = new HashMap<String, Integer>() {
        {
            put("IV", 4);
            put("IX", 9);
            put("XL", 40);
            put("XC", 90);
            put("CD", 400);
            put("CM", 900);
        }
    };

    private RulesConstants() {
    }

}
