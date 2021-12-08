package com.battybuilds.advent2021.day05;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class VentLineTest {
    @Test
    void showTrueIfLineIsHorizonal() {
        VentLine ventLine = new VentLine(Arrays.asList(0, 8), Arrays.asList(5, 8));
        boolean isHorizontal = ventLine.isHorizontal();
        assertThat(isHorizontal).as("should be horizontal").isTrue();
    }

    @Test
    void showFalseIfLineIsNotHorizonal() {
        VentLine ventLine = new VentLine(Arrays.asList(0, 0), Arrays.asList(5, 8));
        boolean isHorizontal = ventLine.isHorizontal();
        assertThat(isHorizontal).as("should not be horizontal").isFalse();
    }

    @Test
    void checkIfLineIsVertical() {
        VentLine ventLine = new VentLine(Arrays.asList(0, 8), Arrays.asList(0, 6));
        boolean isHorizontal = ventLine.isVertical();
        assertThat(isHorizontal).as("should be vertical").isTrue();
    }

    @Test
    void showFalseIfLineIsNotVertical() {
        VentLine ventLine = new VentLine(Arrays.asList(1, 1), Arrays.asList(0, 6));
        boolean isHorizontal = ventLine.isVertical();
        assertThat(isHorizontal).as("should not be vertical").isFalse();
    }

    @Test
    void canDrawHorizontalLineGoingForward() {
        VentLine ventLine = new VentLine(Arrays.asList(0, 8), Arrays.asList(3, 8));
        List<List<Integer>> line = ventLine.drawLine();
        assertThat(line).isEqualTo(Arrays.asList(Arrays.asList(0, 8), Arrays.asList(1, 8), Arrays.asList(2, 8), Arrays.asList(3, 8)));
    }

    @Test
    void canDrawHorizontalLineGoingBackward() {
        VentLine ventLine = new VentLine(Arrays.asList(3, 8), Arrays.asList(1, 8));
        List<List<Integer>> line = ventLine.drawLine();
        assertThat(line).isEqualTo(Arrays.asList(Arrays.asList(3, 8), Arrays.asList(2, 8), Arrays.asList(1, 8)));
    }
}