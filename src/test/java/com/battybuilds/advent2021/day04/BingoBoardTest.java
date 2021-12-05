package com.battybuilds.advent2021.day04;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BingoBoardTest {

    @Test
    void callNumberForBoard() {
//        BingoBoard bingoBoard = new BingoBoard(buildBingoBoardOneRows());
//        bingoBoard.checkForNumber(22);
//        assertThat(bingoBoard.getRows().get(0).get(0).isMarked()).isTrue();
    }

    private List<List<Integer>> buildBingoBoardOneRows() {
        List<Integer> row1 = Arrays.asList(22, 13, 17, 11, 0);
        List<Integer> row2 = Arrays.asList(8, 2, 23, 4, 24);
        List<Integer> row3 = Arrays.asList(21, 9, 14, 16, 7);
        List<Integer> row4 = Arrays.asList(6, 10, 3, 18, 5);
        List<Integer> row5 = Arrays.asList(1, 12, 20, 15, 19);
        List<List<Integer>> board1 = Arrays.asList(row1, row2, row3, row4, row5);
        return board1;
    }
}