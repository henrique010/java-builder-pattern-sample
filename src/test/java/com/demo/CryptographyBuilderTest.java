package com.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import com.demo.patterns.builder.CryptographyBuilder;

public class CryptographyBuilderTest {
    @ParameterizedTest
    @CsvSource({
        "Texto #3, 3# rvzgV",
        "abcABC1, 1FECedc",
        "vxpdylY .ph, ks. \\n{frzx",
        "vv.xwfxo.fd, gi.r{hyz-xx"
    })
    void shouldGenerateCorrectlyEncryptedValues(String input, String output) {
        CryptographyBuilder builder = new CryptographyBuilder(input);
        String result = builder
            .shiftToRight()
            .invertValue()
            .shiftToLeft()
            .build();

        assertThat(result).isEqualTo(output);
    }

    @ParameterizedTest
    @MethodSource("generateInvalidDataString")
    void shouldThrowIllegalArgumentException(String input) {
        assertThatThrownBy(() -> new CryptographyBuilder(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Invalid plainText");
    }

    static Stream<String> generateInvalidDataString() {
        return Stream.of("Tex", "", " ", null);
    }
}
