package com.battybuilds.advent2021;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Test
    void canCalculateBigList() throws URISyntaxException, IOException {
        List<Integer> sonarReadings = pullInput("input01-1.txt");
        int depthIncreases = sonar.depthIncreaseCounter(sonarReadings);
        assertThat(depthIncreases).isEqualTo(1715);
    }

    private List<Integer> pullInput(String file) throws URISyntaxException, IOException {
        Path path = Paths.get(getClass().getClassLoader().getResource(file).toURI());
        Stream<String> lines = Files.lines(path);
        List<Integer> sonarReadings = lines.map(Integer::parseInt).collect(Collectors.toList());
        lines.close();
        return sonarReadings;
    }
}