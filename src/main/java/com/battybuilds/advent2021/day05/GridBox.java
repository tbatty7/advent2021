package com.battybuilds.advent2021.day05;

import java.util.List;

public class GridBox {
    private final List<Integer> coordinates;

    private int countOfIntersections = 0;

    public GridBox(List<Integer> coordinates) {
        this.coordinates = coordinates;
    }

    public int getCount() {
        return countOfIntersections;
    }

    public List<Integer> getCoords() {
        return coordinates;
    }

    public void incrementVentCounter() {
        countOfIntersections++;
    }
}
