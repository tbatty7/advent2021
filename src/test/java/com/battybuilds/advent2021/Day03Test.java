package com.battybuilds.advent2021;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


class Day03Test {

    private Day03 diagnosticTool;

    @BeforeEach
    void setUp() {
        diagnosticTool = new Day03();
    }

    @Test
    void calculatePowerConsumptionForOneBinary() {
        List<String> report = Arrays.asList("00100");
        int powerConsumption = diagnosticTool.powerConsumptionCalculator(report);
        Assertions.assertThat(powerConsumption).isEqualTo(108);
    }

    @Test
    void calculateGammaBinaryForThreeBinaryNumbers() {
        List<String> report = Arrays.asList("11011", "00100", "11011");
        String gammaBinary = diagnosticTool.calculateGammaBinary(report);
        Assertions.assertThat(gammaBinary).isEqualTo("11011");
    }

    @Test
    void calculatePowerConsumptionForThreeBinaryNumbers() {
        List<String> report = Arrays.asList("11011", "00100", "11011");
        int powerConsumption = diagnosticTool.powerConsumptionCalculator(report);
        Assertions.assertThat(powerConsumption).isEqualTo(108);
    }

    @Test
    void calculatePowerConsumptionForTwelveBinaryNumbers() {
        List<String> report = Arrays.asList("00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010");

        int powerConsumption = diagnosticTool.powerConsumptionCalculator(report);
        Assertions.assertThat(powerConsumption).isEqualTo(198);
    }

}