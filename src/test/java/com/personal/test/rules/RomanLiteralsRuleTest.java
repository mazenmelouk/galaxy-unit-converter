package com.personal.test.rules;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanLiteralsRuleTest {
    private static final RomanLiteralsRule RULE = new RomanLiteralsRule();

    @ParameterizedTest
    @MethodSource("testArguments")
    void shouldValidateCorrectly(String test, boolean result) {
        assertEquals(RULE.isValid(test.toCharArray()), result);
    }

    private static Stream<Arguments> testArguments() {
        return Stream.of(
                Arguments.of("XXAI", false),
                Arguments.of("xxiv", true),
                Arguments.of("XiXiVv", true),
                Arguments.of("XXaI", false),
                Arguments.of("", false),
                Arguments.of("VXICDML", true)
        );
    }
}