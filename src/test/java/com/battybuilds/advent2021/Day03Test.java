package com.battybuilds.advent2021;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


class Day03Test {

    @Test
    void name() {
        Day03 diagnosticTool = new Day03();
        int powerConsumption = diagnosticTool.powerConsumptionCalculator(Arrays.asList("01001"));
        Assertions.assertThat(powerConsumption).isEqualTo(9);
    }
}