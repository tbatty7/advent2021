package com.battybuilds.advent2021;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day04 {
    public int caller(String numbersToDrawInput, List<String> boardsInput) {
        List<Integer> numbersToDraw = convertToList(numbersToDrawInput, ",");
        convertToObjects(boardsInput);
        return numbersToDraw.get(2);
    }

    List<Integer> convertToObjects(List<String> boardsInput) {
        String rowInput = boardsInput.get(0);
        List<Integer> row = convertToList(rowInput, " ");
        new BingoBoard(null);
        return row;
    }

    private List<Integer> convertToList(String numbersToDrawInput, String delimiter) {
        return Stream.of(numbersToDrawInput.split(delimiter))
                .map(String::trim)
                .filter(number -> !number.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
