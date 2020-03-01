package com.personal.test;

import com.personal.test.rules.RulesVerifier;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.lang.String.join;
import static java.util.stream.Collectors.joining;

final class FactsHandler {
    private static final DecimalFormat FORMAT = new DecimalFormat("0.#");
    private final Map<String, Character> galacticToRoman = new HashMap<>();
    private final Map<String, Double> metalValue = new HashMap<>();

    void handle(final Fact fact) {
        String[] tokens = fact.getTokens();
        String result = fact.getResult();
        if (tokens.length == 1 && result.length() == 1) {
            galacticToRoman.put(tokens[0], result.charAt(0));
        } else {
            int metalIndex = tokens.length - 1;
            long leftHandSide = evaluateRomansSubArray(tokens, tokens.length - 1);
            long rightHandSide = Long.parseLong(result);
            metalValue.put(tokens[metalIndex], rightHandSide * 1.0 / leftHandSide);
        }
    }

    String answer(final String[] input) {
        String[] tokens = input.clone();
        String lastToken = tokens[tokens.length - 1];
        double thisMetalValue = 1;
        int index = tokens.length;
        if (metalValue.containsKey(lastToken)) {
            index = tokens.length - 1;
            thisMetalValue = metalValue.get(lastToken);
            tokens[index] = tokens[index].substring(0, 1).toUpperCase() + tokens[index].substring(1);
        }
        long leftHandSide = evaluateRomansSubArray(tokens, index);
        return join(" ", tokens) + " is " + FORMAT.format(leftHandSide * thisMetalValue);
    }

    private long evaluateRomansSubArray(final String[] tokens, final int until) {
        char[] romanExpression = Arrays.stream(tokens).limit(until)
                .map(galacticToRoman::get)
                .map(Object::toString)
                .collect(joining()).toCharArray();
        RulesVerifier.verifyRules(romanExpression);
        return RomanExpressionEvaluator.evaluate(romanExpression);
    }
}
