package com.battybuilds.advent2021.day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    //  X    e. If the 5 numbers in a column are marked, it wins
    //  X    f. Return the winning board
    //  X    g. Identify the last number called when a board wins
    //  X    h. Sum all unmarked numbers
    //  X    i. Multiply winning boards unmarked numbers by the last number called

    // Second Exercise - find which board will win last and what it's score will be
    // Problems to solve
    // 1. Allow the game to continue if someone wins.
    // 2. Still be able to tell who won first
    // 3. Be able to tell who won last
    // 4. After a board wins, stop counting it.
    // 5. Have each board know the order it won in
    // Feature slices
    //      1. Maintain functionality and not stop when the first one wins
    //      2. Have each number record the order it won in
    //      3.

    @BeforeEach
    void setUp() {
        bingoRoom = new Day04();
    }

    @Test
    void secondBingoBoardWins() {
        String numbersToDrawInput = "22,13,17,11,0";
        List<String> boardsInput = buildTwoBoardRowsInput();
        int winningBoard = bingoRoom.startBingo(numbersToDrawInput, boardsInput);
        assertThat(winningBoard).isEqualTo(0);
    }

    @Test
    void returnsResultOfWinningNumberMultipliedBySumOfUnmarkedNumbers() {
        String numbersToDrawInput = "22,13,17,0,11";
        List<String> boardsInput = buildTwoBoardRowsInput();
        int resultOfWinner = bingoRoom.startBingo(numbersToDrawInput, boardsInput);
        assertThat(resultOfWinner).isEqualTo(237 * 11);
    }

    @Test
    void calculateAnswerFromBigList() throws URISyntaxException, IOException {
        List<String> input = pullInput("input04.txt");
        String numbersToDrawInput = input.get(0);
        input.remove(0);
        input.remove(0);
        int resultOfWinner = bingoRoom.startBingo(numbersToDrawInput, input);
        assertThat(resultOfWinner).isEqualTo(21607);

    }

    private List<String> pullInput(String file) throws URISyntaxException, IOException {
        Path path = Paths.get(getClass().getClassLoader().getResource(file).toURI());
        Stream<String> lines = Files.lines(path);
        List<String> sonarReadings = lines.collect(Collectors.toList());
        lines.close();
        return sonarReadings;
    }

    private List<String> buildTwoBoardRowsInput() {
        return Arrays.asList(
                "77 95 19 21 76", "93 92 62 35  3", " 4 29  7 41 45", "80 50 83 61 64", "39 32 91 56 48",
                "", "22 13 17 11  0", " 8  2 23  4 24", "21  9 14 16  7", " 6 10  3 18  5", " 1 12 20 15 19");
    }

}