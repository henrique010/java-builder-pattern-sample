package com.demo.utils;

public class CharacterUtil {
    public static boolean isLetter(char character) {
        return 
            (character >= 'a' && character <= 'z') || 
            (character >= 'A' && character <= 'Z');
    }
}
