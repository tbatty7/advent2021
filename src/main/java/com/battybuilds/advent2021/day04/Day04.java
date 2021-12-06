package com.battybuilds.advent2021.day04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.battybuilds.advent2021.day04.CoolUtil.convertStringToListOfIntegers;
import static com.battybuilds.advent2021.day04.CoolUtil.convertToBingoBoxes;

public class Day04 {

    private List<BingoBoard> bingoBoards;

    public List<BingoBoard> getBingoBoards() {
        return bingoBoards;
    }

    public int startBingo(String numbersToDrawInput, List<String> boardsInput) {
        List<Integer> numbersToDraw = convertStringToListOfIntegers(numbersToDrawInput, ",");
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
        List<BingoBoard> boards = new ArrayList<>();
        int boardNumber = 1;
        for (int i = 0; i < boardsInput.size(); i += 6) {
            List<String> boardInput = boardsInput.subList(i, i + 5);
            BingoBoard bingoBoard = buildBingoBoard(boardInput, boardNumber);
            boards.add(bingoBoard);
            boardNumber++;
        }
        return boards;
    }

    public BingoBoard buildBingoBoard(List<String> boardInput, int boardNumber) {
        List<List<BingoBox>> rowsOfBingoBoxes = convertToBingoBoxes(boardInput);
        return new BingoBoard(rowsOfBingoBoxes, boardNumber);
    }
}
