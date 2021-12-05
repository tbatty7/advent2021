package com.battybuilds.advent2021.day04;

import java.util.List;

public class BingoBoard {
    private List<List<BingoBox>> boardRows;

    public BingoBoard(List<List<BingoBox>> boardsInput) {
        boardRows = boardsInput;
    }

    public List<List<BingoBox>> getRows() {
        return boardRows;
    }

    public boolean checkForNumber(int numberCalled) {
        boolean isBingo = false;
        return isBingo;
    }
}
