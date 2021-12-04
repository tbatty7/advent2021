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
        for (int index = 0; index < gammaBinary.length(); index++) {
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
        String firstBinary = report.get(0);
        for (int i = 0; i < firstBinary.length(); i++) {
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
        if (isMoreOnes(firstChars)) return "1";
        return "0";
    }

    private boolean isMoreOnes(List<Character> firstChars) {
        int ones = 0;
        int zeroes = 0;
        for (char bit : firstChars) {
            if (bit == '1') {
                ones++;
            } else {
                zeroes++;
            }
        }
        boolean moreOnes = ones > zeroes;
        return moreOnes;
    }

    public int calculateLifeSupport(List<String> report) {
        List<Character> bits = extractBitsFromPosition(report, 0);
        return 0;
    }
}
