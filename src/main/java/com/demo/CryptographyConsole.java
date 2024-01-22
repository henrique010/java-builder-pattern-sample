package com.demo;

import com.demo.patterns.builder.CryptographyBuilder;

public class CryptographyConsole {
    public static void main(String args[]) {
        CryptographyBuilder builder = new CryptographyBuilder("vxpdylY .ph");
        String result = builder
            .shiftToRight()
            .invertValue()
            .shiftToLeft()
            .build();

        System.out.println("Result: "+result);
    }
}
