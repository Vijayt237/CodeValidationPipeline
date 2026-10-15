package com.example;

public class App {
    public static String validateMessage(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input must not be empty");
        }
        return "Validated: " + input.trim();
    }

    public static void main(String[] args) {
        System.out.println(validateMessage("CodeValidationPipeline"));
    }
}
