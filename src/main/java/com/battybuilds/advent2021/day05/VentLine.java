package com.battybuilds.advent2021.day05;

import java.util.ArrayList;
import java.util.Arrays;
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

    public List<List<Integer>> drawLine() {
        List<List<Integer>> pointsInLine = new ArrayList<>();
        if (isHorizontal() && isGoingRight()) {
            addPointToForwardLine(pointsInLine);
        } else if (isHorizontal()) {
            addPointToBackwardLine(pointsInLine);
        } else {
            addPointToForwardVerticalLine(pointsInLine);
        }
        return pointsInLine;
    }

    private void addPointToForwardVerticalLine(List<List<Integer>> pointsInLine) {
        for (int xCoordinate = startingCoordinates.get(1); xCoordinate <= endingCoordinates.get(1); xCoordinate++) {
            Integer yCoordinate = this.endingCoordinates.get(0);
            pointsInLine.add(Arrays.asList(yCoordinate, xCoordinate));
        }
    }

    private void addPointToBackwardLine(List<List<Integer>> pointsInLine) {
        for (int yCoordinate = startingCoordinates.get(0); yCoordinate >= endingCoordinates.get(0); yCoordinate--) {
            Integer xCoordinate = this.endingCoordinates.get(1);
            pointsInLine.add(Arrays.asList(yCoordinate, xCoordinate));
        }
    }

    private void addPointToForwardLine(List<List<Integer>> pointsInLine) {
        for (int yCoordinate = startingCoordinates.get(0); yCoordinate <= endingCoordinates.get(0); yCoordinate++) {
            Integer xCoordinate = this.endingCoordinates.get(1);
            pointsInLine.add(Arrays.asList(yCoordinate, xCoordinate));
        }
    }

    private boolean isGoingRight() {
        return startingCoordinates.get(0) < endingCoordinates.get(0);
    }
}
