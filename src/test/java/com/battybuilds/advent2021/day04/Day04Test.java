package com.battybuilds.advent2021.day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.battybuilds.advent2021.day04.CoolUtil.convertToBingoBoxes;
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
    //  X    b. Represent a board winning by having boards numbered and returning the number when a board wins
    //  X    c. If the 5 numbers in a row are marked, it wins
    //  X    d. Handle multiple boards
    //      e. If the 5 numbers in a column are marked, it wins
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
        List<String> boardsInput = buildSingleBoardRowsInput();
        String numbersToDrawInput = "13";
        int winnerScore = bingoRoom.startBingo(numbersToDrawInput, boardsInput);
        BingoBoard bingoBoardOne = bingoRoom.getBingoBoards().get(0);
        assertThat(bingoBoardOne.getRows().get(0).get(0).isMarked()).isFalse();
        assertThat(bingoBoardOne.getRows().get(0).get(1).isMarked()).isTrue();
        assertThat(winnerScore).isEqualTo(0);
    }

    @Test
    void convertToListOfOneBingoBoard() {
        List<String> boardsInput = buildSingleBoardRowsInput();
        List<BingoBoard> bingoBoards = bingoRoom.convertToBingoBoards(boardsInput);
        assertThat(bingoBoards).isNotNull();
        assertThat(bingoBoards.get(0).getRows().size()).isEqualTo(5);
    }

    @Test
    void convertSingleBingoBoardToRows() {
        List<String> boardsInput = buildSingleBoardRowsInput();
        List<BingoBoard> bingoBoards = bingoRoom.convertToBingoBoards(boardsInput);
        assertThat(bingoBoards).isNotNull();
        assertThat(bingoBoards.get(0).getRows().size()).isEqualTo(5);
    }

    @Test
    void convertRowsOfIntegersToRowsOfBingoBoxes() {
        List<String> rowsInput = buildSingleBoardRowsInput();
        List<List<BingoBox>> rowsOfBingoBoxes = convertToBingoBoxes(rowsInput);
        assertThat(rowsOfBingoBoxes.get(0).get(0)).usingRecursiveComparison().isEqualTo(new BingoBox(22));
    }

    @Test
    void boardGetsBingoFromTopRow() {
        List<String> boardsInput = buildSingleBoardRowsInput();
        String numbersToDrawInput = "22,13,17,11,0";
        int winningBoardNumber = bingoRoom.startBingo(numbersToDrawInput, boardsInput);
        BingoBoard bingoBoardOne = bingoRoom.getBingoBoards().get(0);
        List<BingoBox> topRow = bingoBoardOne.getRows().get(0);
        assertThat(topRow.get(0).isMarked()).isTrue();
        assertThat(topRow.get(1).isMarked()).isTrue();
        assertThat(topRow.get(2).isMarked()).isTrue();
        assertThat(topRow.get(3).isMarked()).isTrue();
        assertThat(topRow.get(4).isMarked()).isTrue();
        assertThat(winningBoardNumber).isEqualTo(1);
    }

    @Test
    void handlesMultipleBoardsInput() {
        List<String> boardsInput = buildTwoBoardRowsInput();
        List<BingoBoard> bingoBoards = bingoRoom.convertToBingoBoards(boardsInput);
        assertThat(bingoBoards.size()).isEqualTo(2);
        assertThat(bingoBoards.get(0).getBoardNumber()).as("wrong number of boards in list").isEqualTo(1);
        assertThat(bingoBoards.get(1).getBoardNumber()).as("second BingoBoard number is incrrect").isEqualTo(2);
        assertThat(bingoBoards.get(0).getRows().size()).as("first board has right number of rows").isEqualTo(5);
        assertThat(bingoBoards.get(1).getRows().size()).as("second board has 5 rows").isEqualTo(5);
        assertThat(bingoBoards.get(1).getRows().get(0).get(0).getBoxNumber()).isEqualTo(22);
        assertThat(bingoBoards.get(1).getRows().get(4).get(4).getBoxNumber()).isEqualTo(19);

    }

    @Test
    void secondBingoBoardWinsWithHorizontalBingo() {
        String numbersToDrawInput = "22,13,17,11,0";
        List<String> boardsInput = buildTwoBoardRowsInput();
        int winningBoardNumber = bingoRoom.startBingo(numbersToDrawInput, boardsInput);
        assertThat(winningBoardNumber).isEqualTo(2);
    }

    private List<String> buildTwoBoardRowsInput() {
        return Arrays.asList(
                "77 95 19 21 76", "93 92 62 35  3", " 4 29  7 41 45", "80 50 83 61 64", "39 32 91 56 48",
                "", "22 13 17 11  0", " 8  2 23  4 24", "21  9 14 16  7", " 6 10  3 18  5", " 1 12 20 15 19");
    }

    private List<String> buildSingleBoardRowsInput() {
        return Arrays.asList("22 13 17 11  0", " 8  2 23  4 24", "21  9 14 16  7", " 6 10  3 18  5", " 1 12 20 15 19");
    }

    private List<List<Integer>> buildRowsForBingoBoard() {
        List<Integer> row1 = Arrays.asList(22, 13, 17, 11, 0);
        List<Integer> row2 = Arrays.asList(8, 2, 23, 4, 24);
        List<Integer> row3 = Arrays.asList(21, 9, 14, 16, 7);
        List<Integer> row4 = Arrays.asList(6, 10, 3, 18, 5);
        List<Integer> row5 = Arrays.asList(1, 12, 20, 15, 19);
        return Arrays.asList(row1, row2, row3, row4, row5);
    }
}