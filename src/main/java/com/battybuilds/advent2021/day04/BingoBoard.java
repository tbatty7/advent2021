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
        return isHorizontalBingo() || isVerticalBingo();
    }

    private boolean isVerticalBingo() {
        for (int column = 0; column < 5; column++) {
            int columnResult = checkMarksInColumn(column);
            if (columnResult == 5)
                return true;
        }
        return false;
    }

    private int checkMarksInColumn(int column) {
        int columnResult = 0;
        for (int row = 0; row < 5; row++) {
            BingoBox bingoBox = rows.get(row).get(column);
            if (bingoBox.isMarked())
                columnResult++;
        }
        return columnResult;
    }

    private boolean isHorizontalBingo() {
        for (List<BingoBox> row : rows) {
            int rowResult = checkMarksInRow(row);
            if (rowResult == 5)
                return true;
        }
        return false;
    }

    private int checkMarksInRow(List<BingoBox> row) {
        int rowResult = 0;
        for (BingoBox box : row) {
            if (box.isMarked())
                rowResult++;
        }
        return rowResult;
    }

    public int getBoardNumber() {
        return boardNumber;
    }
}
