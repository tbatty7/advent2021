package com.battybuilds.advent2021.day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameRoomTest {

    private GameRoom bingoRoom;

    @BeforeEach
    void setUp() {
        bingoRoom = new GameRoom();
    }

    @Test
    void startBingoForOneNumberAndOneBoardAndNoWinner() {
        List<String> boardsInput = buildSingleBoardRowsInput();
        String numbersToDrawInput = "13";
        BingoBoard winningBoard = bingoRoom.setupAndPlayBingoAndReturnWinner(numbersToDrawInput, boardsInput);
        BingoBoard bingoBoardOne = bingoRoom.getBingoBoards().get(0);
        assertThat(bingoBoardOne.getRows().get(0).get(0).isMarked()).isFalse();
        assertThat(bingoBoardOne.getRows().get(0).get(1).isMarked()).isTrue();
        assertThat(winningBoard).isEqualTo(null);
    }

    @Test
    void boardGetsBingoFromTopRow() {
        List<String> boardsInput = buildSingleBoardRowsInput();
        String numbersToDrawInput = "22,13,17,11,0";
        BingoBoard winningBoard = bingoRoom.setupAndPlayBingoAndReturnWinner(numbersToDrawInput, boardsInput);
        BingoBoard bingoBoardOne = bingoRoom.getBingoBoards().get(0);
        List<BingoBox> topRow = bingoBoardOne.getRows().get(0);
        assertThat(topRow.get(0).isMarked()).isTrue();
        assertThat(topRow.get(1).isMarked()).isTrue();
        assertThat(topRow.get(2).isMarked()).isTrue();
        assertThat(topRow.get(3).isMarked()).isTrue();
        assertThat(topRow.get(4).isMarked()).isTrue();
        assertThat(winningBoard.getBoardNumber()).isEqualTo(1);
    }

    @Test
    void secondBingoBoardWins() {
        String numbersToDrawInput = "22,13,17,11,0";
        List<String> boardsInput = buildTwoBoardRowsInput();
        BingoBoard winningBoard = bingoRoom.setupAndPlayBingoAndReturnWinner(numbersToDrawInput, boardsInput);
        assertThat(winningBoard.getBoardNumber()).isEqualTo(2);
    }

    @Test
    void winningBingoBoardKnowsLastNumberCalled() {
        String numbersToDrawInput = "22,13,17,11,0";
        List<String> boardsInput = buildTwoBoardRowsInput();
        BingoBoard winningBoard = bingoRoom.setupAndPlayBingoAndReturnWinner(numbersToDrawInput, boardsInput);
        assertThat(winningBoard.getWinningNumber()).isEqualTo(0);
    }

    @Test
    void shouldKnowIfItWonFirst() {
        String numbersToDrawInput = "22,13,17,11,0";
        List<String> boardsInput = buildTwoBoardRowsInput();
        BingoBoard winningBoard = bingoRoom.setupAndPlayBingoAndReturnWinner(numbersToDrawInput, boardsInput);
        assertThat(winningBoard.getBoardNumber()).isEqualTo(2);
        assertThat(winningBoard.getWinningOrder()).isEqualTo(1);
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