package com.battybuilds.advent2021.day05;

import java.util.ArrayList;
import java.util.List;

public class VentMapper {
    public static List<GridBox> mapGridBoxes(List<VentLine> ventLines) {
        List<GridBox> gridBoxes = new ArrayList<>();
        for (VentLine ventLine : ventLines) {
            List<List<Integer>> points = ventLine.drawLine();
            for (List<Integer> pointCoordinates : points) {
                GridBox gridBox = new GridBox(pointCoordinates);
                gridBox.incrementVentCounter();
                gridBoxes.add(gridBox);
            }
        }
        return gridBoxes;
    }
}
