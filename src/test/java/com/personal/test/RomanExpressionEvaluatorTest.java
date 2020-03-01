package com.personal.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanExpressionEvaluatorTest {

    @ParameterizedTest
    @MethodSource("testArguments")
    void shouldEvaluateCorrectly(String test, long result) {
        assertEquals(RomanExpressionEvaluator.evaluate(test.toCharArray()), result);
    }

    private static Stream<Arguments> testArguments() {
        return Stream.of(
                Arguments.of("LXXXVIII", 88),
                Arguments.of("MDLXXXII", 1582),
                Arguments.of("MCMXLIV", 1944),
                Arguments.of("MCMIII", 1903),
                Arguments.of("MCCXXXIV", 1234)
        );
    }
}