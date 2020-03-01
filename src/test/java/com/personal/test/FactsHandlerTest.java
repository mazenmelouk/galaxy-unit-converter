package com.personal.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactsHandlerTest {

    @Test
    void shouldEvaluateCorrectly() {
        FactsHandler handler = new FactsHandler();
        handler.handle(new Fact(new String[]{"glob"}, "i"));
        handler.handle(new Fact(new String[]{"prok"}, "v"));
        handler.handle(new Fact(new String[]{"pish"}, "x"));
        handler.handle(new Fact(new String[]{"tegj"}, "l"));
        handler.handle(new Fact(new String[]{"glob", "glob", "silver"}, "34"));
        handler.handle(new Fact(new String[]{"glob", "prok", "gold"}, "57800"));
        handler.handle(new Fact(new String[]{"pish", "pish", "iron"}, "3910"));

        assertEquals(handler.answer(new String[]{"pish", "tegj", "glob", "glob"}), "pish tegj glob glob is 42");
        assertEquals(handler.answer(new String[]{"glob", "prok", "silver"}), "glob prok Silver is 68");
        assertEquals(handler.answer(new String[]{"glob", "prok", "gold"}), "glob prok Gold is 57800");
        assertEquals(handler.answer(new String[]{"glob", "prok", "iron"}), "glob prok Iron is 782");

        handler.answer(new String[]{"glob", "prok", "silver"});
        handler.answer(new String[]{"glob", "prok", "gold"});
        handler.answer(new String[]{"glob", "prok", "iron"});
    }
}