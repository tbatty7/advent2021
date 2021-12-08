package com.battybuilds.advent2021.day05;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VentMapper {
    public static List<GridBox> mapGridBoxes(List<VentLine> ventLines) {
        List<GridBox> gridBoxes = new ArrayList<>();
        for (VentLine ventLine : ventLines) {
            List<List<Integer>> points = ventLine.drawLine();
            for (List<Integer> pointCoordinates : points) {
                List<GridBox> previouslyCrossedBoxes = gridBoxes.stream().filter(box -> box.getCoords().equals(pointCoordinates)).collect(Collectors.toList());
                if (previouslyCrossedBoxes.size() > 0) {
                    previouslyCrossedBoxes.get(0).incrementVentCounter();
                } else {
                    GridBox gridBox = new GridBox(pointCoordinates);
                    gridBoxes.add(gridBox);
                }
            }
        }
        return gridBoxes;
    }
}
