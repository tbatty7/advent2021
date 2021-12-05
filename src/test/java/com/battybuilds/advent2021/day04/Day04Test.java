package com.battybuilds.advent2021.day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day04Test {
    private Day04 bingoRoom;

    // Problems to solve
    // 1.  How to represent the bingo boards so you can identify which one won.
    //      a. Number them?
    //      b. Make them objects
    //      c.
    // 2.  How to represent a number being called on a specific board
    // 3.  What is the smallest problem I can start with writing a test about?
    //  X    a. Represent a caller calling a number, passing a list for caller to call
    //  X    a. Represent a board
    //  X    b. Mark a number on a board when the caller calls it(Number may not appear on all boards)
    //      b. Represent a board winning
    //      c. If the 5 numbers in a row are marked, it wins
    //      d. If the 5 numbers in a column are marked, it wins
    //      e. Handle multiple boards
    //      f. Return the winning board
    //      g. Identify the last number called when a board wins
    //      h. Sum all unmarked numbers
    //      i. Multiply winning boards unmarked numbers by the last number called

    @BeforeEach
    void setUp() {
        bingoRoom = new Day04();
    }

    @Test
    void startBingoForOneNumber() {
        List<String> boardsInput = Arrays.asList("22 13 17 11  0", " 8  2 23  4 24", "21  9 14 16  7", " 6 10  3 18  5", " 1 12 20 15 19");
        String numbersToDrawInput = "13";
        int winnerScore = bingoRoom.startBingo(numbersToDrawInput, boardsInput);
        BingoBoard bingoBoardOne = bingoRoom.getBingoBoards().get(0);
        assertThat(bingoBoardOne.getRows().get(0).get(1).isMarked()).isTrue();
        assertThat(bingoBoardOne.getRows().get(0).get(0).isMarked()).isFalse();
        assertThat(winnerScore).isEqualTo(0);
    }

    @Test
    void convertToListOfOneBingoBoard() {
        List<String> boardsInput = Arrays.asList("22 13 17 11  0", " 8  2 23  4 24", "21  9 14 16  7", " 6 10  3 18  5", " 1 12 20 15 19");
        List<BingoBoard> bingoBoards = bingoRoom.convertToBingoBoards(boardsInput);
        assertThat(bingoBoards).isNotNull();
        assertThat(bingoBoards.get(0).getRows().size()).isEqualTo(5);
    }

    @Test
    void convertSingleBingoBoardToRows() {
        List<String> boardsInput = Arrays.asList("22 13 17 11  0", " 8  2 23  4 24", "21  9 14 16  7", " 6 10  3 18  5", " 1 12 20 15 19");
        List<BingoBoard> bingoBoards = bingoRoom.convertToBingoBoards(boardsInput);
        assertThat(bingoBoards).isNotNull();
        assertThat(bingoBoards.get(0).getRows().size()).isEqualTo(5);
    }

    @Test
    void convertRowsOfIntegersToRowsOfBingoBoxes() {
        List<List<Integer>> rowsOfIntegers = buildBingoBoardOneRows();
        List<List<BingoBox>> rowsOfBingoBoxes = bingoRoom.convertToBingoBoxes(rowsOfIntegers);
        assertThat(rowsOfBingoBoxes.get(0).get(0)).usingRecursiveComparison().isEqualTo(new BingoBox(22));
    }

    @Test
    void boardGetsBingo() {

    }

    private List<List<Integer>> buildBingoBoardOneRows() {
        List<Integer> row1 = Arrays.asList(22, 13, 17, 11, 0);
        List<Integer> row2 = Arrays.asList(8, 2, 23, 4, 24);
        List<Integer> row3 = Arrays.asList(21, 9, 14, 16, 7);
        List<Integer> row4 = Arrays.asList(6, 10, 3, 18, 5);
        List<Integer> row5 = Arrays.asList(1, 12, 20, 15, 19);
        return Arrays.asList(row1, row2, row3, row4, row5);
    }
}