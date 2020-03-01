package com.personal.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputParserTest {
    @ParameterizedTest
    @MethodSource("correctQueryArguments")
    void shouldParseCorrectQueries(String test, String[] tokens) {
        assertArrayEquals(InputParser.parseQuery(test), tokens);
    }

    @ParameterizedTest
    @MethodSource("incorrectQueryArguments")
    void shouldFailOnIncorrectQueries(String test) {
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseQuery(test));
    }

    @ParameterizedTest
    @MethodSource("correctFactArguments")
    void shouldParseCorrectFacts(String test, Fact fact) {
        assertEquals(InputParser.parseFact(test), fact);
    }

    @ParameterizedTest
    @MethodSource("incorrectFactArguments")
    void shouldFailOnIncorrectFacts(String test) {
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseFact(test));
    }

    private static Stream<Arguments> correctQueryArguments() {
        return Stream.of(
                Arguments.of("Credits how much is pish tegj glob glob ?", new String[]{"pish", "tegj", "glob", "glob"}),
                Arguments.of("how many Credits is glob prok Silver?", new String[]{"glob", "prok", "silver"}),
                Arguments.of("how many Credits is glob prok Gold ?", new String[]{"glob", "prok", "gold"}),
                Arguments.of("how many Credits is glob prok Iron ?", new String[]{"glob", "prok", "iron"})
        );
    }

    private static Stream<Arguments> incorrectQueryArguments() {
        return Stream.of(
                Arguments.of("how much wood could a woodchuck chuck if a woodchuck could chuck wood?"),
                Arguments.of("how many Credits is glob prok is Gold"),
                Arguments.of("glob glob Silver is 34 Credits")
        );
    }

    private static Stream<Arguments> correctFactArguments() {
        return Stream.of(
                Arguments.of("glob is I", new Fact(new String[]{"glob"}, "i")),
                Arguments.of("prok is V", new Fact(new String[]{"prok"}, "v")),
                Arguments.of("pish is X", new Fact(new String[]{"pish"}, "x")),
                Arguments.of("tegj is L", new Fact(new String[]{"tegj"}, "l")),
                Arguments.of("glob glob Silver is 34 Credits", new Fact(new String[]{"glob", "glob", "silver"}, "34")),
                Arguments.of("glob prok Gold is 57800", new Fact(new String[]{"glob", "prok", "gold"}, "57800")),
                Arguments.of("Credits pish pish Iron is 3910", new Fact(new String[]{"pish", "pish", "iron"}, "3910"))
        );
    }

    private static Stream<Arguments> incorrectFactArguments() {
        return Stream.of(
                Arguments.of("glob prok is Gold is 57800"),
                Arguments.of("how many Credits is glob prok is Gold")
        );
    }
}