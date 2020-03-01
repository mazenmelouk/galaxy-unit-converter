package com.personal.test.rules;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InvalidSubtractionsRuleTest {
    private static final InvalidSubtractionsRule RULE = new InvalidSubtractionsRule();

    @ParameterizedTest
    @MethodSource("testArguments")
    void shouldValidateCorrectly(String test, boolean result) {
        assertEquals(RULE.isValid(test.toCharArray()), result);
    }

    private static Stream<Arguments> testArguments() {
        return Stream.of(
                Arguments.of("DM", false),
                Arguments.of("LM", false),
                Arguments.of("LC", false),
                Arguments.of("LD", false),
                Arguments.of("VX", false),
                Arguments.of("VL", false),
                Arguments.of("VD", false),
                Arguments.of("VM", false),
                Arguments.of("VVX", false),
                Arguments.of("CMCD", true),
                Arguments.of("CXM", false),
                Arguments.of("", true),
                Arguments.of("ICX", false),
                Arguments.of("IVXL", true),
                Arguments.of("VXICDML", false)
        );
    }
}