package com.battybuilds.advent2021.day04;

import java.util.List;
import java.util.stream.Collectors;

import static com.battybuilds.advent2021.day04.CoolUtil.convertStringToListOfIntegers;

public class GameRoom {
    private List<BingoBoard> bingoBoards;

    public List<BingoBoard> getBingoBoards() {
        return bingoBoards;
    }

    BingoBoard setupAndPlayBingo(String numbersToDrawInput, List<String> boardsInput) {
        List<Integer> numbersToDraw = convertStringToListOfIntegers(numbersToDrawInput, ",");
        this.bingoBoards = new BoardBuilder().convertToBingoBoards(boardsInput);
        BingoBoard winningBoard = playBingo(numbersToDraw);
        return winningBoard;
    }

    BingoBoard playBingo(List<Integer> numbersToDraw) {
        for (Integer number : numbersToDraw) {
            bingoBoards.forEach(bingoBoard -> bingoBoard.markNumberCalled(number));
            List<BingoBoard> winningBoardList = checkForWinner();
            if (someoneCalledBingo(winningBoardList)) {
                BingoBoard winningBingoBoard = winningBoardList.get(0);
                return winningBingoBoard;
            }
        }
        return null;
    }

    private List<BingoBoard> checkForWinner() {
        return bingoBoards.stream()
                .filter(BingoBoard::isBingo)
                .collect(Collectors.toList());
    }

    private boolean someoneCalledBingo(List<BingoBoard> winningBoardList) {
        return winningBoardList.size() == 1;
    }
}
