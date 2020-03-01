package com.personal.test;

import java.util.Scanner;
import java.util.logging.Logger;

import static java.util.logging.Level.FINE;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FactsHandler handler = new FactsHandler();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) continue;
            try {
                if (isQuery(line)) {
                    System.out.println(handler.answer(InputParser.parseQuery(line)));
                } else {
                    handler.handle(InputParser.parseFact(line));
                }
            } catch (RuntimeException ex) {
                logger.log(FINE, "Failed to handle " + line, ex);
                System.out.println("I have no idea what you are talking about");
            }
        }
    }

    private static boolean isQuery(String s) {
        return s.endsWith("?") || s.toLowerCase().startsWith("how");
    }
}
