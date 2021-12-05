package com.battybuilds.advent2021.day04;

public class BingoBox {
    private final Integer boxNumber;
    private boolean isMarked;

    public BingoBox(Integer boxNumber) {
        this.boxNumber = boxNumber;
    }

    public boolean isMarked() {
        return isMarked;
    }

    public void mark(int numberCalled) {
        if (numberCalled == boxNumber) {
            isMarked = true;
        }
    }
}
