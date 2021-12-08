package com.battybuilds.advent2021.day05;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.battybuilds.advent2021.day05.VentUtil.convertToSetsOfCoordinates;
import static org.assertj.core.api.Assertions.assertThat;

class VentUtilTest {

    @Test
    void canConvertInputToCoordinates() {
        List<String> coordinates = coordinatesInput();
        List<List<List<Integer>>> convertedCoordinateStrings = convertToSetsOfCoordinates(coordinates);
        assertThat(convertedCoordinateStrings.get(0)).isEqualTo(Arrays.asList(Arrays.asList(0, 9), Arrays.asList(5, 9)));
    }

    @Test
    void canConvertInputToLineObjectsWithCoordinates() {
        List<String> coordinates = coordinatesInput();
        List<List<List<Integer>>> convertedCoordinates = convertToSetsOfCoordinates(coordinates);
        List<VentLine> ventLines = new VentUtil().convertToLines(convertedCoordinates);
        assertThat(ventLines.get(0).getStartingCoordinates()).isEqualTo(Arrays.asList(0, 9));
        assertThat(ventLines.get(0).getEndingCoordinates()).isEqualTo(Arrays.asList(5, 9));
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