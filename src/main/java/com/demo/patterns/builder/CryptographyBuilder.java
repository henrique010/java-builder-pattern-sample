package com.demo.patterns.builder;

import com.demo.utils.CharacterUtil;

public class CryptographyBuilder {
    private String finalValue;

    public CryptographyBuilder(String plainText) {
        if(plainText == null || plainText.isBlank() || plainText.length() < 4) {
            throw new IllegalArgumentException("Invalid plainText");
        }
        this.finalValue = plainText;
    }

    public CryptographyBuilder shiftToRight() {
        StringBuilder newValue = new StringBuilder();

        for (char character : this.finalValue.toCharArray()) {
            if(CharacterUtil.isLetter(character)) {
                character += 3;
            }
            newValue.append(character);
        }

        this.finalValue = newValue.toString();
        return this;
    }

    public CryptographyBuilder shiftToLeft() {
        StringBuilder stringBuilder = new StringBuilder();
        int half = finalValue.length() / 2;

        String noModify = this.finalValue.substring(0, half);
        String shouldModify = this.finalValue.substring(half);

        for (char character : shouldModify.toCharArray()) {
            character -= 1;
            stringBuilder.append(character);
        }

        this.finalValue = noModify.concat(stringBuilder.toString());
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
