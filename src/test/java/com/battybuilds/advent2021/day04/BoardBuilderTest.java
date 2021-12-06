package com.battybuilds.advent2021.day04;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BoardBuilderTest {


    @Test
    void convertToListOfOneBingoBoard() {
        List<String> boardsInput = buildSingleBoardRowsInput();
        List<BingoBoard> bingoBoards = new BoardBuilder().convertToBingoBoards(boardsInput);
        assertThat(bingoBoards).isNotNull();
        assertThat(bingoBoards.get(0).getRows().size()).isEqualTo(5);
    }

    @Test
    void convertSingleBingoBoardToRows() {
        List<String> boardsInput = buildSingleBoardRowsInput();
        List<BingoBoard> bingoBoards = new BoardBuilder().convertToBingoBoards(boardsInput);
        assertThat(bingoBoards).isNotNull();
        assertThat(bingoBoards.get(0).getRows().size()).isEqualTo(5);
    }

    @Test
    void handlesMultipleBoardsInput() {
        List<String> boardsInput = buildTwoBoardRowsInput();
        List<BingoBoard> bingoBoards = new BoardBuilder().convertToBingoBoards(boardsInput);
        assertThat(bingoBoards.size()).isEqualTo(2);
        assertThat(bingoBoards.get(0).getBoardNumber()).as("wrong number of boards in list").isEqualTo(1);
        assertThat(bingoBoards.get(1).getBoardNumber()).as("second BingoBoard number is incrrect").isEqualTo(2);
        assertThat(bingoBoards.get(0).getRows().size()).as("first board has right number of rows").isEqualTo(5);
        assertThat(bingoBoards.get(1).getRows().size()).as("second board has 5 rows").isEqualTo(5);
        assertThat(bingoBoards.get(1).getRows().get(0).get(0).getBoxNumber()).isEqualTo(22);
        assertThat(bingoBoards.get(1).getRows().get(4).get(4).getBoxNumber()).isEqualTo(19);
    }

    private List<String> buildTwoBoardRowsInput() {
        return Arrays.asList(
                "77 95 19 21 76", "93 92 62 35  3", " 4 29  7 41 45", "80 50 83 61 64", "39 32 91 56 48",
                "", "22 13 17 11  0", " 8  2 23  4 24", "21  9 14 16  7", " 6 10  3 18  5", " 1 12 20 15 19");
    }

    private List<String> buildSingleBoardRowsInput() {
        return Arrays.asList("22 13 17 11  0", " 8  2 23  4 24", "21  9 14 16  7", " 6 10  3 18  5", " 1 12 20 15 19");
    }
}