package com.battybuilds.advent2021;

import com.battybuilds.advent2021.day05.VentLine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day05 {
    public List<List<List<Integer>>> convert(List<String> coordinates) {
        return convertToSetsOfCoordinates(coordinates);
    }

    public static ArrayList<List<Integer>> convertStringToListOfStrings(String numbersToDrawInput, String delimiter) {
        List<String> lines = Stream.of(numbersToDrawInput.split(delimiter))
                .collect(Collectors.toList());
        ArrayList<List<Integer>> linesOfCoordinates = new ArrayList<>();
        for (String line : lines) {
            List<Integer> newLine = Stream.of(line.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            linesOfCoordinates.add(newLine);
        }
        return linesOfCoordinates;
    }

    static List<List<List<Integer>>> convertToSetsOfCoordinates(List<String> boardsInput) {
        List<List<List<Integer>>> lines = new ArrayList<>();
        for (String rowInput : boardsInput) {
            List<List<Integer>> line = convertStringToListOfStrings(rowInput, " -> ");
            lines.add(line);
        }
        return lines;
    }

    public List<VentLine> convertToLines(List<List<List<Integer>>> convertedCoordinateStrings) {
        ArrayList<VentLine> ventLines = new ArrayList<>();
        for (List<List<Integer>> coordinates : convertedCoordinateStrings) {
            VentLine ventLine = new VentLine(coordinates.get(0), coordinates.get(1));
            ventLines.add(ventLine);
        }
        return ventLines;
    }
}
