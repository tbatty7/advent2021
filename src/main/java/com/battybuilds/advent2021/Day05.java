package com.battybuilds.advent2021;

import java.util.List;

import static com.battybuilds.advent2021.day05.VentUtil.convertToSetsOfCoordinates;

public class Day05 {
    public List<List<List<Integer>>> convert(List<String> coordinates) {
        return convertToSetsOfCoordinates(coordinates);
    }


}
