package com.personal.test.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RulesVerifierTest {
    @ParameterizedTest
    @MethodSource("testArguments")
    void shouldThrowExceptionOnInvalidRules(String test) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> RulesVerifier.verifyRules(test.toCharArray()));
    }

    private static Stream<Arguments> testArguments() {
        return Stream.of(
                Arguments.of("XXAI"),
                Arguments.of("XXaI"),
                Arguments.of(""),
                Arguments.of("VXICDML"),
                Arguments.of("IIX", false),
                Arguments.of("VMVMVM", false)
        );
    }
}