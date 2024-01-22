package com.demo.patterns.builder;

import com.demo.utils.CharacterUtil;

public class CryptographyBuilder {
    private String finalValue;

    public CryptographyBuilder(String plainText) {
        if(plainText == null || plainText.isBlank() || plainText.isEmpty() || plainText.length() < 4) {
            throw new IllegalArgumentException("Invalid plainText");
        }
        this.finalValue = plainText;
    }

    public CryptographyBuilder shiftToRight() {
        StringBuilder newValue = new StringBuilder();
        for (int i = 0; i < this.finalValue.length(); i++) {
            char c = this.finalValue.charAt(i);

            if(CharacterUtil.isLetter(c) == true) {
                c += 3;
            }
            
            newValue.append(c);
        }

        this.finalValue = newValue.toString();
        return this;
    }

    public CryptographyBuilder shiftToLeft() {
        StringBuilder stringBuilder = new StringBuilder();
        int half = finalValue.length() / 2;

        for (int i = 0; i < this.finalValue.length(); i++) {
            char c = finalValue.charAt(i);

            if(i >= half) {
                c -= 1;
            }
            
            stringBuilder.append(c);
        }

        this.finalValue = stringBuilder.toString();
        return this;
    }

    public CryptographyBuilder invertValue() {
        StringBuilder stringBuilder = new StringBuilder(this.finalValue);
        this.finalValue = stringBuilder.reverse().toString();
        return this;
    }


    public String build() {
        return this.finalValue;
    }
}
