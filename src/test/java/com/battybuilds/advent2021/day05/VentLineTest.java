package com.battybuilds.advent2021.day05;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class VentLineTest {
    @Test
    void showTrueIfLineIsHorizonal() {
        VentLine ventLine = new VentLine(Arrays.asList(0, 8), Arrays.asList(5, 8));
        boolean isHorizontal = ventLine.isHorizontal();
        Assertions.assertThat(isHorizontal).as("should be horizontal").isTrue();
    }

    @Test
    void showFalseIfLineIsNotHorizonal() {
        VentLine ventLine = new VentLine(Arrays.asList(0, 0), Arrays.asList(5, 8));
        boolean isHorizontal = ventLine.isHorizontal();
        Assertions.assertThat(isHorizontal).as("should not be horizontal").isFalse();
    }

    @Test
    void checkIfLineIsVertical() {
        VentLine ventLine = new VentLine(Arrays.asList(0, 8), Arrays.asList(0, 6));
        boolean isHorizontal = ventLine.isVertical();
        Assertions.assertThat(isHorizontal).as("should be vertical").isTrue();
    }

    @Test
    void showFalseIfLineIsNotVertical() {
        VentLine ventLine = new VentLine(Arrays.asList(1, 1), Arrays.asList(0, 6));
        boolean isHorizontal = ventLine.isVertical();
        Assertions.assertThat(isHorizontal).as("should not be vertical").isFalse();
    }
}