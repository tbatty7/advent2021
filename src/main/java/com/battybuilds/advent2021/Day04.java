package com.battybuilds.advent2021;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day04 {
    public int caller(String numbersToDrawInput, List<String> boardsInput) {
        List<Integer> numbersToDraw = convertToList(numbersToDrawInput, ",");
        convertToObjects(boardsInput);
        return numbersToDraw.get(2);
    }

    List<List<Integer>> convertToObjects(List<String> boardsInput) {
        List<List<Integer>> rows = new ArrayList<>();
        for (String rowInput : boardsInput) {
            List<Integer> row = convertToList(rowInput, " ");
            rows.add(row);
        }
        BingoBoard bingoBoard = new BingoBoard(rows);
        return rows;
    }

    private List<Integer> convertToList(String numbersToDrawInput, String delimiter) {
        return Stream.of(numbersToDrawInput.split(delimiter))
                .map(String::trim)
                .filter(number -> !number.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
