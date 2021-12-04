package com.battybuilds.advent2021;

import java.util.List;

public class Day03 {

    public int powerConsumptionCalculator(List<String> report) {
        String epsilon = report.get(0);
        return Integer.parseInt(epsilon, 2);
    }
}
