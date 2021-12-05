package com.battybuilds.advent2021.day04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day04 {

    private List<BingoBoard> bingoBoards;

    public List<BingoBoard> getBingoBoards() {
        return bingoBoards;
    }

    public int startBingo(String numbersToDrawInput, List<String> boardsInput) {
        List<Integer> numbersToDraw = convertToListOfIntegers(numbersToDrawInput, ",");
        bingoBoards = convertToBingoBoards(boardsInput);
        BingoBoard winningBoard = playBingo(numbersToDraw);
        if (winningBoard != null)
            return winningBoard.getBoardNumber();
        else
            return 0;
    }

    BingoBoard playBingo(List<Integer> numbersToDraw) {
        for (Integer number : numbersToDraw) {
            bingoBoards.forEach(bingoBoard -> bingoBoard.markNumberCalled(number));
            List<BingoBoard> winningBoardList = checkForWinner();
            if (someoneCalledBingo(winningBoardList)) {
                return winningBoardList.get(0);
            }
        }
        return null;
    }

    private boolean someoneCalledBingo(List<BingoBoard> winningBoardList) {
        return winningBoardList.size() == 1;
    }

    private List<BingoBoard> checkForWinner() {
        return bingoBoards.stream()
                .filter(BingoBoard::isBingo)
                .collect(Collectors.toList());
    }

    List<BingoBoard> convertToBingoBoards(List<String> boardsInput) {
        BingoBoard bingoBoard = convertToBingoBoard(boardsInput, 1);
        return Collections.singletonList(bingoBoard);
    }

    BingoBoard convertToBingoBoard(List<String> boardsInput, int boardNumber) {
        List<List<Integer>> rowsOfIntegers = convertToRowsOfIntegers(boardsInput);
        List<List<BingoBox>> rowsOfBingoBoxes = convertToBingoBoxes(rowsOfIntegers);
        return new BingoBoard(rowsOfBingoBoxes, boardNumber);
    }

    List<List<BingoBox>> convertToBingoBoxes(List<List<Integer>> rowsOfIntegers) {
        return rowsOfIntegers.stream()
                .map(row -> row.stream()
                        .map(BingoBox::new)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
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
