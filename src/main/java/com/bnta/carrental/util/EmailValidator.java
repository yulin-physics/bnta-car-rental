package com.bnta.carrental.util;

public class EmailValidator {
    public Boolean check(String input) {
        String pattern = "(\\w+)@([a-z]+\\.[a-z]+)";
        if (input.matches(pattern)) {
            return true;
        } else {
            throw new IllegalArgumentException("invalid email");
        }
    }
}