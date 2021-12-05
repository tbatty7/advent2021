package com.battybuilds.advent2021;

import com.battybuilds.advent2021.day04.BingoBoard;
import com.battybuilds.advent2021.day04.BingoBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day04 {
    public int caller(String numbersToDrawInput, List<String> boardsInput) {
        List<Integer> numbersToDraw = convertToListOfIntegers(numbersToDrawInput, ",");
        convertToBingoBoards(boardsInput);
        return numbersToDraw.get(2);
    }

    List<BingoBoard> convertToBingoBoards(List<String> boardsInput) {
        BingoBoard bingoBoard = convertToBingoBoard(boardsInput);
        return Arrays.asList(bingoBoard);
    }

    BingoBoard convertToBingoBoard(List<String> boardsInput) {
        List<List<Integer>> rowsOfIntegers = convertToRowsOfIntegers(boardsInput);
        List<List<BingoBox>> rowsOfBingoBoxes = convertToBingoBoxes(rowsOfIntegers);
        BingoBoard bingoBoard = new BingoBoard(rowsOfBingoBoxes);
        return bingoBoard;
    }

    List<List<BingoBox>> convertToBingoBoxes(List<List<Integer>> rowsOfIntegers) {
        return rowsOfIntegers.stream().map(row -> {
            return row.stream().map(integer -> {return new BingoBox(integer);}).collect(Collectors.toList());
        }).collect(Collectors.toList());
    }

    List<List<Integer>> convertToRowsOfIntegers(List<String> boardsInput) {
        List<List<Integer>> rows = new ArrayList<>();
        for (String rowInput : boardsInput) {
            List<Integer> row = convertToListOfIntegers(rowInput, " ");
            rows.add(row);
        }
        return rows;
    }

    private List<Integer> convertToListOfIntegers(String numbersToDrawInput, String delimiter) {
        return Stream.of(numbersToDrawInput.split(delimiter))
                .map(String::trim)
                .filter(number -> !number.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
