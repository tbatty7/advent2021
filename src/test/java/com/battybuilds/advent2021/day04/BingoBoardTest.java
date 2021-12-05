package com.battybuilds.advent2021.day04;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BingoBoardTest {

    @Test
    void callNumberForBoard() {
        List<String> rowsInput = Arrays.asList("22 13 17 11  0", " 8  2 23  4 24", "21  9 14 16  7", " 6 10  3 18  5", " 1 12 20 15 19");
        BingoBoard bingoBoard = new Day04().convertToBingoBoard(rowsInput);
        assertThat(bingoBoard.getRows().get(0).get(0).isMarked()).isFalse();
        bingoBoard.markNumberCalled(22);
        assertThat(bingoBoard.getRows().get(0).get(0).isMarked()).isTrue();
    }

}