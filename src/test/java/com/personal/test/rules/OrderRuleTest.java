package com.personal.test.rules;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderRuleTest {
    private static final OrderRule RULE = new OrderRule();

    @ParameterizedTest
    @MethodSource("testArguments")
    void shouldValidateCorrectly(String test, boolean result) {
        assertEquals(RULE.isValid(test.toCharArray()), result);
    }

    private static Stream<Arguments> testArguments() {
        return Stream.of(
                Arguments.of("MCMXLIV", true),
                Arguments.of("MCMIII", true),
                Arguments.of("LXXXVIII", true),
                Arguments.of("", true),
                Arguments.of("IIX", false),
                Arguments.of("IXIX", true),
                Arguments.of("VMVMVM", false),
                Arguments.of("IXIXIXIXIII", true)
        );
    }
}