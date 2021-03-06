package com.battybuilds.advent2021.day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BingoBoardTest {

    private BingoBoard bingoBoard;

    @BeforeEach
    void setUp() {
        List<String> rowsInput = Arrays.asList("22 13 17 11  0", " 8  2 23  4 24", "21  9 14 16  7", " 6 10  3 18  5", " 1 12 20 15 19");
        bingoBoard = new BoardBuilder().buildBingoBoard(rowsInput, 1);
    }

    @Test
    void callNumberForBoard() {
        assertThat(bingoBoard.getRows().get(0).get(0).isMarked()).isFalse();
        bingoBoard.markNumberCalled(22);
        assertThat(bingoBoard.getRows().get(0).get(0).isMarked()).isTrue();
        assertThat(bingoBoard.isBingo()).isFalse();
    }

    @Test
    void boardGetsHorizontalBingo() {
        bingoBoard.markNumberCalled(22);
        bingoBoard.markNumberCalled(13);
        bingoBoard.markNumberCalled(17);
        bingoBoard.markNumberCalled(11);
        bingoBoard.markNumberCalled(0);
        assertThat(bingoBoard.getRows().get(0).get(0).isMarked()).isTrue();
        assertThat(bingoBoard.getRows().get(0).get(1).isMarked()).isTrue();
        assertThat(bingoBoard.getRows().get(0).get(2).isMarked()).isTrue();
        assertThat(bingoBoard.getRows().get(0).get(3).isMarked()).isTrue();
        assertThat(bingoBoard.getRows().get(0).get(4).isMarked()).isTrue();
        assertThat(bingoBoard.isBingo()).isTrue();
    }

    @Test
    void boardGetsVerticalBingo() {
        bingoBoard.markNumberCalled(22);
        bingoBoard.markNumberCalled(8);
        bingoBoard.markNumberCalled(21);
        bingoBoard.markNumberCalled(6);
        bingoBoard.markNumberCalled(1);
        assertThat(bingoBoard.getRows().get(0).get(0).isMarked()).isTrue();
        assertThat(bingoBoard.getRows().get(1).get(0).isMarked()).isTrue();
        assertThat(bingoBoard.getRows().get(2).get(0).isMarked()).isTrue();
        assertThat(bingoBoard.getRows().get(3).get(0).isMarked()).isTrue();
        assertThat(bingoBoard.getRows().get(4).get(0).isMarked()).isTrue();
        assertThat(bingoBoard.isBingo()).isTrue();
    }

    @Test
    void boardCanSumUpUnmarkedBoxes() {
        bingoBoard.markNumberCalled(22);
        bingoBoard.markNumberCalled(13);
        bingoBoard.markNumberCalled(17);
        bingoBoard.markNumberCalled(11);
        bingoBoard.markNumberCalled(0);
        int result = bingoBoard.sumUpUnmarkedNumbers();
        assertThat(result).isEqualTo(237);
    }
}