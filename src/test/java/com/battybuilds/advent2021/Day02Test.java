package com.battybuilds.advent2021;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day02Test {

    private Day02 navigation;

    @BeforeEach
    void setUp() {
        navigation = new Day02();
    }

    @Test
    void canCalculatePostionOfForward5_Down5() {
        List<String> directions = Arrays.asList("forward 5", "down 5");
        int position = navigation.calculatePosition(directions);
        Assertions.assertThat(position).isEqualTo(25);
    }

    @Test
    void canCalculatePostionWithUpAndDownInstructions() {
        List<String> directions = Arrays.asList("forward 5", "down 5", "up 3");
        int position = navigation.calculatePosition(directions);
        Assertions.assertThat(position).isEqualTo(10);
    }
}