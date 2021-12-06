package com.battybuilds.advent2021.day04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CoolUtil {
    public static List<Integer> convertStringToListOfIntegers(String numbersToDrawInput, String delimiter) {
        return Stream.of(numbersToDrawInput.split(delimiter))
                .map(String::trim)
                .filter(number -> !number.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    static List<List<Integer>> convertToRowsOfIntegers(List<String> boardsInput) {
        List<List<Integer>> rows = new ArrayList<>();
        for (String rowInput : boardsInput) {
            List<Integer> row = convertStringToListOfIntegers(rowInput, " ");
            rows.add(row);
        }
        return rows;
    }

    public static List<List<BingoBox>> convertToBingoBoxes(List<String> rowsInput) {
        List<List<Integer>> rowsOfIntegers = convertToRowsOfIntegers(rowsInput);
        return rowsOfIntegers.stream()
                .map(row -> row.stream()
                        .map(BingoBox::new)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
