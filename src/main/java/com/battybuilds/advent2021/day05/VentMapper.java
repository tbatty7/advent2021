package com.battybuilds.advent2021.day05;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VentMapper {
    public static List<GridBox> mapToGridBoxes(List<VentLine> ventLines) {
        List<GridBox> gridBoxes = new ArrayList<>();
        for (VentLine ventLine : ventLines) {
            for (List<Integer> pointCoordinates : ventLine.drawLine()) {
                List<GridBox> previouslyCrossedBoxes = findGridBoxesCrossedBefore(gridBoxes, pointCoordinates);
                if (gridBoxHadAnotherVentCrossIt(previouslyCrossedBoxes)) {
                    previouslyCrossedBoxes.get(0).incrementVentCounter();
                } else {
                    gridBoxes.add(new GridBox(pointCoordinates));
                }
            }
        }
        return gridBoxes;
    }

    private static boolean gridBoxHadAnotherVentCrossIt(List<GridBox> previouslyCrossedBoxes) {
        return previouslyCrossedBoxes.size() > 0;
    }

    private static List<GridBox> findGridBoxesCrossedBefore(List<GridBox> gridBoxes, List<Integer> pointCoordinates) {
        return gridBoxes.stream()
                .filter(box -> box.getCoords().equals(pointCoordinates))
                .collect(Collectors.toList());
    }
}
