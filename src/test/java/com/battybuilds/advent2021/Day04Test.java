package com.battybuilds.advent2021;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Day04Test {

    // Problems to solve
    // 1.  How to represent the bingo boards so you can identify which one won.
    //      a. Number them?
    //      b. Make them objects
    //      c.
    // 2.  How to represent a number being called on a specific board
    // 3.  What is the smallest problem I can start with writing a test about?
    //      a. Represent a caller calling a number, passing a list for caller to call
    //      b. Mark a number on a board when the caller calls it(Number may not appear on all boards)
    //      b. Represent a board winning
    //      c. If the 5 numbers in a row are marked, it wins
    //      d. If the 5 numbers in a column are marked, it wins
    //      e. Handle multiple boards
    //      f. Return the winning board
    //      g. Identify the last number called when a board wins
    //      h. Sum all unmarked numbers
    //      i. Multiply winning boards unmarked numbers by the last number called

    @Test
    void name() {
        Day04 bingoRoom = new Day04();
        int calledNumber = bingoRoom.caller(Arrays.asList(3));
        Assertions.assertThat(calledNumber).isEqualTo(3);
    }
}