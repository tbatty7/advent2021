package com.battybuilds.advent2021.day04;

import java.util.List;

public class Day04 {
    public int startBingo(String numbersToDrawInput, List<String> boardsInput, boolean wantWinningBoard) {
        BingoBoard desiredBoard;
        if (wantWinningBoard)
            desiredBoard = new GameRoom().setupAndPlayBingoAndReturnWinner(numbersToDrawInput, boardsInput);
        else
            desiredBoard = new GameRoom().setupAndPlayBingoAndReturnLoser(numbersToDrawInput, boardsInput);
        if (desiredBoard != null)
            return desiredBoard.getWinningNumber() * desiredBoard.sumUpUnmarkedNumbers();
        else
            return 0;
    }
}
