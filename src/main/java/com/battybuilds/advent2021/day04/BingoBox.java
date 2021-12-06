package com.battybuilds.advent2021.day04;

public class BingoBox {
    private final Integer boxNumber;

    private boolean isMarked = false;

    public BingoBox(Integer boxNumber) {
        this.boxNumber = boxNumber;
    }

    public void mark(int numberCalled) {
        if (numberCalled == boxNumber) {
            isMarked = true;
        }
    }

    public boolean isMarked() {
        return isMarked;
    }

    public Integer getBoxNumber() {
        return boxNumber;
    }
}
