package com.battybuilds.advent2021;

import org.assertj.core.api.Assertions;
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
        assertThat(powerConsumption).isEqualTo(108);
    }

    @Test
    void calculateGammaBinaryForThreeBinaryNumbers() {
        List<String> report = Arrays.asList("11011", "00100", "11011");
        String gammaBinary = diagnosticTool.calculateGammaBinary(report);
        assertThat(gammaBinary).isEqualTo("11011");
    }

    @Test
    void calculatePowerConsumptionForThreeBinaryNumbers() {
        List<String> report = Arrays.asList("11011", "00100", "11011");
        int powerConsumption = diagnosticTool.powerConsumptionCalculator(report);
        assertThat(powerConsumption).isEqualTo(108);
    }

    @Test
    void calculatePowerConsumptionForTwelveBinaryNumbers() {
        List<String> report = Arrays.asList("00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010");

        int powerConsumption = diagnosticTool.powerConsumptionCalculator(report);
        assertThat(powerConsumption).isEqualTo(198);
    }

    @Test
    void calculatePowerConsumptionForBigList() throws URISyntaxException, IOException {
        List<String> report = pullInput("input03.txt");
        int powerConsumption = diagnosticTool.powerConsumptionCalculator(report);
        assertThat(powerConsumption).isEqualTo(198);
    }

    @Test
    void calculateGammaForBigBinaries() {
        List<String> report = Arrays.asList("111111010011", "111111010011", "000000101100");
        String gammaBinary = diagnosticTool.calculateGammaBinary(report);
        assertThat(gammaBinary).isEqualTo("111111010011");
    }

    @Test
    void calculatePowerConsumptionForBigBinaries() {
        List<String> report = Arrays.asList("111111010011", "111111010011", "000000101100");
        int powerConsumption = diagnosticTool.powerConsumptionCalculator(report);
        assertThat(powerConsumption).isEqualTo(4051*44);
    }

    private List<String> pullInput(String file) throws URISyntaxException, IOException {
        Path path = Paths.get(getClass().getClassLoader().getResource(file).toURI());
        Stream<String> lines = Files.lines(path);
        List<String> sonarReadings = lines.collect(Collectors.toList());
        lines.close();
        return sonarReadings;
    }

}