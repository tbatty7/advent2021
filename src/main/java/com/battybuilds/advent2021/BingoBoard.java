package com.battybuilds.advent2021;

import java.util.List;

public class BingoBoard {
    private List<List<Integer>> boardRows;

    public BingoBoard(List<List<Integer>> boardsInput) {
        boardRows = boardsInput;
    }

    public List<List<Integer>> getRows() {
        return boardRows;
    }
}
