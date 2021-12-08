package com.battybuilds.advent2021;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day05Test {
    private Day05 ventMapper;

    // Problems to Solve
    // ?
    // Small Slices
    //  X    0. convert input to list of list of list of integers
    //  X    1. convert input to line objects with coordinates
    //  X    2. check if either the x or y match
    //  X    3. show all numbers between the different coordinates x or y
    //      4. draw straight horizontal line going forward
    //      5. draw straight horizontal line going backward
    //      6. draw straight vertical line going forward
    //      7. draw straight vertical line going backward
    //      8. create 9x9 map object and represent each GridBox with an object that can identify if it has a path cross it


    @BeforeEach
    void setUp() {
        ventMapper = new Day05();
    }

    @Test
    void canConvertInputToCoordinates() {
        List<String> coordinates = coordinatesInput();
        List<List<List<Integer>>> convertedCoordinateStrings = ventMapper.convert(coordinates);
        assertThat(convertedCoordinateStrings.get(0)).isEqualTo(Arrays.asList(Arrays.asList(0, 9), Arrays.asList(5, 9)));
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