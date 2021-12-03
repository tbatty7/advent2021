package com.battybuilds.advent2021;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Day01Test {
    @Test
    void canCalculateIncreaseOf1() {
        Day01 sonar = new Day01();
        int depthIncrease = sonar.depthIncreaseCounter(Arrays.asList(1, 2));
        Assertions.assertThat(depthIncrease).isEqualTo(1);
    }
}