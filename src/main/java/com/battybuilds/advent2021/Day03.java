package com.battybuilds.advent2021;

import java.util.List;
import java.util.stream.Collectors;

public class Day03 {

    public int powerConsumptionCalculator(List<String> report) {
        String gammaBinary = calculateGammaBinary(report);
        String epsilonBinary = calculateEpsilonBinary(gammaBinary);
        int gamma = Integer.parseInt(gammaBinary, 2);
        int epsilon = Integer.parseInt(epsilonBinary, 2);
        return epsilon * gamma;
    }

    private String calculateEpsilonBinary(String gammaBinary) {
        String epsilonBinary = "";
        for (int index = 0; index < 5; index++) {
            if (gammaBinary.charAt(index) == '1') {
                epsilonBinary += "0";
            } else {
                epsilonBinary += "1";
            }
        }
        return epsilonBinary;
    }

    String calculateGammaBinary(List<String> report) {
        String gammaBinary = "";
        for (int i = 0; i < 5; i++) {
            int index = i;
            List<Character> bits = extractBitsFromPosition(report, index);
            gammaBinary += calculateGammaBit(bits);
        }
        return gammaBinary;
    }

    private List<Character> extractBitsFromPosition(List<String> report, int index) {
        return report.stream()
                .map(n -> n.charAt(index)).collect(Collectors.toList());
    }

    private String calculateGammaBit(List<Character> firstChars) {
        int ones = 0;
        int zeroes = 0;
        for (char bit : firstChars) {
            if (bit == '1') {
                ones++;
            } else {
                zeroes++;
            }
        }
        return determineBit(ones, zeroes);
    }

    private String determineBit(int ones, int zeroes) {
        return ones > zeroes ? "1" : "0";
    }

}
