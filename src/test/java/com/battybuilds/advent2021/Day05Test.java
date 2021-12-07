package com.battybuilds.advent2021;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Day05Test {

    // Problems to Solve
    // ?
    // Small Slices
    //      1. convert input to objects of coordinates
    //      2. check if either the x or y match
    //      3. show all numbers between the different coordinates x or y
    //      4. track path of a set of coordinates
    //      5. create 9x9 map object and represent each box with an object that can identify if it has a path cross it


    @Test
    void canConvertInputToCoordinates() {
        List<String> coordinates = Arrays.asList(
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
        Day05 ventMapper = new Day05();
        List<ArrayList<List<Integer>>> convertedCoordinateStrings = ventMapper.convert(coordinates);
        Assertions.assertThat(convertedCoordinateStrings.get(0)).isEqualTo(Arrays.asList(Arrays.asList(0, 9), Arrays.asList(5, 9)));
    }
}