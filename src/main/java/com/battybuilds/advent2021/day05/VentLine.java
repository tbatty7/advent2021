package com.battybuilds.advent2021.day05;

import java.util.List;
import java.util.Objects;

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

    public boolean isHorizontal() {
        return Objects.equals(startingCoordinates.get(1), endingCoordinates.get(1));
    }

    public boolean isVertical() {
        return Objects.equals(startingCoordinates.get(0), endingCoordinates.get(0));
    }
}
