package com.battybuilds.advent2021.day05;

import java.util.List;

public class VentLine {
    private final List<Integer> startingCoordinates;

    private final List<Integer> endingCoordinates;

    public VentLine(List<Integer> startingCoordinates, List<Integer> endingCoordinates) {

        this.startingCoordinates = startingCoordinates;
        this.endingCoordinates = endingCoordinates;
    }

    public List<Integer> getEndingCoordinates() {
        return endingCoordinates;
    }

    public List<Integer> getStartingCoordinates() {
        return startingCoordinates;
    }
}
