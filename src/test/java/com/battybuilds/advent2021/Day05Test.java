package com.battybuilds.advent2021;

import com.battybuilds.advent2021.day05.GridBox;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


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


    @BeforeEach
    void setUp() {
        ventDetector = new Day05();
    }

    @Test
    void canMapCoordinates() {
        List<String> coordinates = Collections.singletonList("0,9 -> 5,9");
        List<GridBox> ventMap = ventDetector.reportVentDangers(coordinates);
        GridBox expectedGridBox = new GridBox(Arrays.asList(0, 9));
        Assertions.assertThat(ventMap.get(0).getCoords()).isEqualTo(expectedGridBox.getCoords());
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