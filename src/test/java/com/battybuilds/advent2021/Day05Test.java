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
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Day05Test {
    private Day05 ventDetector;

    // Problems to Solve
    //       1. How to have it map points intersecting without knowing the size of the map ahead of time
    //       2. Have a mapper class that
    // Small Slices
    //  X    0. convert input to list of list of list of integers
    //  X    1. convert input to line objects with coordinates
    //  X    2. check if either the x or y match
    //  X    3. show all numbers between the different coordinates x or y
    //  X    4. draw straight horizontal line going forward
    //  X    5. draw straight horizontal line going backward
    //  X    6. draw straight vertical line going forward
    //  X    7. draw straight vertical line going backward
    //  X     8. create GridBox object
    //  X     9. save all the GridBox objects in a list
    //  X     10. make GridBox object identify if it has a path cross it
    //  X     11. increment a field on GridBox if another one tries to be created with the same coords
    //  X    12. Count GridBoxes with count of more than one


    @BeforeEach
    void setUp() {
        ventDetector = new Day05();
    }

    @Test
    void returnsDangerPointsForTwoVentLinesIntersecting() {
        List<String> coordinates = Arrays.asList("0,9 -> 5,9", "6,9 -> 5,9");
        Integer dangerpoints = ventDetector.reportVentDangers(coordinates);
        Assertions.assertThat(dangerpoints).isEqualTo(1);
    }

    @Test
    void returnsDangerPointsForFiveVentLinesIntersecting() {
        List<String> coordinates = coordinatesInput();
        Integer dangerpoints = ventDetector.reportVentDangers(coordinates);
        Assertions.assertThat(dangerpoints).isEqualTo(5);
    }

    @Test
    void returnsDangerPointsForBigFile() throws URISyntaxException, IOException {
        List<String> coordinates = pullInput();
        Integer dangerpoints = ventDetector.reportVentDangers(coordinates);
        Assertions.assertThat(dangerpoints).isEqualTo(5576);
    }

    private List<String> pullInput() throws URISyntaxException, IOException {
        Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource("input05.txt")).toURI());
        Stream<String> lines = Files.lines(path);
        List<String> sonarReadings = lines.collect(Collectors.toList());
        lines.close();
        return sonarReadings;
    }

    private List<String> coordinatesInput() {
        return Arrays.asList(
                "0,9 -> 5,9",
                "8,0 -> 0,8",
                "9,4 -> 3,4",
                "2,2 -> 2,1",
                "7,0 -> 7,4",
                "6,4 -> 2,0",
                "0,9 -> 2,9",
                "3,4 -> 1,4",
                "0,0 -> 8,8",
                "5,5 -> 8,2");
    }
}