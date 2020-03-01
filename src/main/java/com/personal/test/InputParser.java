package com.personal.test;

final class InputParser {
    private static final String CREDITS = "credits";
    private static final String IS = " is ";
    private static final String HOW = "how";

    private InputParser() {
    }

    static String[] parseQuery(final String input) {
        String[] tokens = input.toLowerCase().replace(CREDITS, "")
                .replace("?", "")
                .split(IS);
        if (tokens.length == 2 && tokens[0].contains(HOW)) {
            return tokens[1].trim().split(" ");
        }
        throw new IllegalArgumentException("Invalid Query : " + input);
    }

    static Fact parseFact(final String input) {
        String[] tokensAndResult = input.toLowerCase().replace(CREDITS, "").split(IS);
        if (tokensAndResult.length == 2 && !tokensAndResult[0].contains(HOW)) {
            return new Fact(tokensAndResult[0].trim().split(" "), tokensAndResult[1].trim());
        }
        throw new IllegalArgumentException("Input " + input + " is invalid");
    }
}
