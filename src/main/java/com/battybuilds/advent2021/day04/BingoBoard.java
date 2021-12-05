package com.battybuilds.advent2021.day04;

import java.util.List;

public class BingoBoard {
    private final List<List<BingoBox>> rows;
    private final int boardNumber;

    public BingoBoard(List<List<BingoBox>> boardsInput, int boardNumber) {
        rows = boardsInput;
        this.boardNumber = boardNumber;
    }

    public List<List<BingoBox>> getRows() {
        return rows;
    }

    public void markNumberCalled(int numberCalled) {
        for (List<BingoBox> row : rows) {
            for (BingoBox box : row) {
                box.mark(numberCalled);
            }
        }
    }

    public boolean isBingo() {
        for (List<BingoBox> row : rows) {
            int rowResult = 0;
            for (BingoBox box : row) {
                if (box.isMarked())
                    rowResult++;
            }
            if (rowResult == 5)
                return true;
        }
        return false;
    }

    public int getBoardNumber() {
        return boardNumber;
    }
}
