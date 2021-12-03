package com.battybuilds.advent2021;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day01Test {

    private Day01 sonar;

    @BeforeEach
    void setUp() {
        sonar = new Day01();
    }

    @Test
    void canCalculateIncreaseOf1() {
        List<Integer> sonarReadings = Arrays.asList(1, 2);
        int depthIncrease = sonar.depthIncreaseCounter(sonarReadings);
        assertThat(depthIncrease).isEqualTo(1);
    }

    @Test
    void canCalculateIncreaseOf2() {
        List<Integer> sonarReadings = Arrays.asList(1, 2, 3);
        int depthIncrease = sonar.depthIncreaseCounter(sonarReadings);
        assertThat(depthIncrease).isEqualTo(2);
    }


}