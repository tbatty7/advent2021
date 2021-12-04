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
        assertThat(position).isEqualTo(25);
    }

    @Test
    void canCalculatePostionWithUpAndDownInstructions() {
        List<String> directions = Arrays.asList("forward 5", "down 5", "up 3");
        int position = navigation.calculatePosition(directions);
        assertThat(position).isEqualTo(10);
    }

    @Test
    void canCalculatePositionFromBigList() throws URISyntaxException, IOException {
        List<String> directions = pullInput("input02.txt");
        int position = navigation.calculatePosition(directions);
        assertThat(position).isEqualTo(1690020);
    }

    @Test
    void canCalculateCorrectPostionOfForward5_Down5() {
        List<String> directions = Arrays.asList("forward 5", "down 5");
        Integer position = navigation.calculateAccuratePosition(directions);
        assertThat(position).isEqualTo(0);
    }

    @Test
    void canCalculateCorrectPostionOfForward5_Down5_Forward8() {
        List<String> directions = Arrays.asList("forward 5", "down 5", "forward 8");
        Integer position = navigation.calculateAccuratePosition(directions);
        assertThat(position).isEqualTo(520);
    }

    @Test
    void canCalculateCorrectPostionOfForward5_Down5_Forward8_Up3() {
        List<String> directions = Arrays.asList("forward 5", "down 5", "forward 8", "up 3");
        Integer position = navigation.calculateAccuratePosition(directions);
        assertThat(position).isEqualTo(520);
    }

    @Test
    void canCalculateCorrectPostionOfForward5_Down5_Forward8_Up3_down8_forward2() {
        List<String> directions = Arrays.asList("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2");
        Integer position = navigation.calculateAccuratePosition(directions);
        assertThat(position).isEqualTo(900);
    }

    private List<String> pullInput(String file) throws URISyntaxException, IOException {
        Path path = Paths.get(getClass().getClassLoader().getResource(file).toURI());
        Stream<String> lines = Files.lines(path);
        List<String> sonarReadings = lines.collect(Collectors.toList());
        lines.close();
        return sonarReadings;
    }
}