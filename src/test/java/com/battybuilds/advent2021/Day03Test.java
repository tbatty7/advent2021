package com.battybuilds.advent2021;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


class Day03Test {

    @Test
    void calculatePowerConsumptionForOneBinary() {
        Day03 diagnosticTool = new Day03();
        List<String> report = Arrays.asList("00100");
        int powerConsumption = diagnosticTool.powerConsumptionCalculator(report);
        Assertions.assertThat(powerConsumption).isEqualTo(108);
    }
}