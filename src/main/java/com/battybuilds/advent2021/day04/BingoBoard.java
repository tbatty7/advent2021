package com.battybuilds.advent2021.day04;

import java.util.List;

public class BingoBoard {
    private final List<List<BingoBox>> rows;

    public BingoBoard(List<List<BingoBox>> boardsInput) {
        rows = boardsInput;
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
}
