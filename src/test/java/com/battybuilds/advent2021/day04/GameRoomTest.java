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
        List<String> boardsInput = buildThreeBoardRowsInput();
        BingoBoard winningBoard = bingoRoom.setupAndPlayBingoAndReturnWinner(numbersToDrawInput, boardsInput);
        assertThat(winningBoard.getBoardNumber()).isEqualTo(2);
    }

    @Test
    void winningBingoBoardKnowsLastNumberCalled() {
        String numbersToDrawInput = "22,13,17,11,0";
        List<String> boardsInput = buildThreeBoardRowsInput();
        BingoBoard winningBoard = bingoRoom.setupAndPlayBingoAndReturnWinner(numbersToDrawInput, boardsInput);
        assertThat(winningBoard.getWinningNumber()).isEqualTo(0);
    }

    @Test
    void shouldKnowIfItWonFirst() {
        String numbersToDrawInput = "22,13,17,11,0";
        List<String> boardsInput = buildThreeBoardRowsInput();
        BingoBoard winningBoard = bingoRoom.setupAndPlayBingoAndReturnWinner(numbersToDrawInput, boardsInput);
        assertThat(winningBoard.getBoardNumber()).isEqualTo(2);
        assertThat(winningBoard.getWinningOrder()).isEqualTo(1);
    }

    @Test
    void shouldKnowLastBoardToWin() {
        String numbersToDrawInput = "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1";
        List<String> boardsInput = buildThreeBoardRowsInput();
        BingoBoard losingBoard = bingoRoom.setupAndPlayBingoAndReturnLoser(numbersToDrawInput, boardsInput);
        assertThat(losingBoard.getBoardNumber()).as("should be the first board").isEqualTo(1);
        assertThat(losingBoard.getWinningOrder()).as("should be the second one to win").isEqualTo(3);
    }

    private List<String> buildThreeBoardRowsInput() {
        return Arrays.asList(
                " 3 15  0  2 22", " 9 18 13 17  5", "19  8  7 25 23", "20 11 10 24  4", "14 21 16 12  6",
                "", "22 13 17 11  0", " 8  2 23  4 24", "21  9 14 16  7", " 6 10  3 18  5", " 1 12 20 15 19",
                "", "14 21 17 24  4", "10 16 15  9 19", "18  8 23 26 20", "22 11 13  6  5", " 2  0 12  3  7");
    }

    private List<String> buildSingleBoardRowsInput() {
        return Arrays.asList("22 13 17 11  0", " 8  2 23  4 24", "21  9 14 16  7", " 6 10  3 18  5", " 1 12 20 15 19");
    }
}