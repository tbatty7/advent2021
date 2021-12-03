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
        int depthIncreases = sonar.depthIncreaseCounter(sonarReadings);
        assertThat(depthIncreases).isEqualTo(1);
    }

    @Test
    void canCalculateIncreaseOf2() {
        List<Integer> sonarReadings = Arrays.asList(1, 2, 3);
        int depthIncreases = sonar.depthIncreaseCounter(sonarReadings);
        assertThat(depthIncreases).isEqualTo(2);
    }

    @Test
    void canCountOnlyIncreasesIfThereAreDecreases() {
        List<Integer> sonarReadings = Arrays.asList(2, 1, 2);
        int depthIncreases = sonar.depthIncreaseCounter(sonarReadings);
        assertThat(depthIncreases).isEqualTo(1);
    }
}