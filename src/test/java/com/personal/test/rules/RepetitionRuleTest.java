package com.personal.test.rules;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RepetitionRuleTest {
    private static final RepetitionRule RULE = new RepetitionRule();

    @ParameterizedTest
    @MethodSource("testArguments")
    void shouldValidateCorrectly(String test, boolean result) {
        assertEquals(RULE.isValid(test.toCharArray()), result);
    }

    private static Stream<Arguments> testArguments() {
        return Stream.of(
                Arguments.of("XXXIX", true),
                Arguments.of("xxx", true),
                Arguments.of("IIiC", true),
                Arguments.of("CCCXX", true),
                Arguments.of("XXXIIICCCMMMXXXCCC", true),
                Arguments.of("", true),
                Arguments.of("VVV", false),
                Arguments.of("DDD", false),
                Arguments.of("DLLL", false),
                Arguments.of("DD", false)
        );
    }
}