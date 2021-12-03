package com.battybuilds.advent2021;

import java.util.List;

public class Day01 {

    public int depthIncreaseCounter(List<Integer> input) {
        int count = 0;
        int previous = 0;
        for (int i : input) {
            if (i > previous)
                count++;
            previous = i;
        }
        return count - 1;
    }
}
