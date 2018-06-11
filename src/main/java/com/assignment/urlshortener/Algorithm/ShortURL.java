package com.assignment.urlshortener.Algorithm;

import java.util.Random;

public final class ShortURL {

    private static final String ALPHABET = "23456789bcdfghjkmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ-_";
    private static final int BASE = ALPHABET.length();

    public static String encode() {
        int num = new Random().nextInt() & Integer.MAX_VALUE;
        StringBuilder str = new StringBuilder();
        while (num > 0) {
            str.insert(0, ALPHABET.charAt(num % BASE));
            num = num / BASE;
        }
        return str.toString();
    }

    private ShortURL() {}

}