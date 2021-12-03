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

    public int depthGroupIncreaseCounter(List<Integer> sonarReadings) {
        int count = 0;
        for (int i = 0; i+3 < sonarReadings.size(); i++) {
            int readingsGroup1 = add3Readings(sonarReadings, i);
            int readingsGroup2 = add3Readings(sonarReadings, i + 1);
            if (readingsGroup1 < readingsGroup2)
                count++;
        }
        return count;
    }

    private int add3Readings(List<Integer> sonarReadings, int i) {
        Integer firstReading = sonarReadings.get(i);
        Integer secondReading = sonarReadings.get(i+1);
        Integer thirdReading = sonarReadings.get(i+2);
        return firstReading + secondReading + thirdReading;
    }
}
