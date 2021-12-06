package com.battybuilds.advent2021.day04;

import java.util.List;

public class Day04 {
    public int startBingo(String numbersToDrawInput, List<String> boardsInput) {
        BingoBoard winningBoard = new GameRoom().setupAndPlayBingo(numbersToDrawInput, boardsInput);
        if (winningBoard != null)
            return winningBoard.getBoardNumber();
        else
            return 0;
    }
}
