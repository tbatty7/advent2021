package com.battybuilds.advent2021;

import java.util.Arrays;
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

    private boolean isMoreOnes(List<Character> bits) {
        List<Integer> onesAndZeroes = splitOnesAndZeroes(bits);
        Integer ones = onesAndZeroes.get(0);
        Integer zeroes = onesAndZeroes.get(1);
        return ones > zeroes;
    }

    public int calculateLifeSupport(List<String> report) {
        int lengthOfBinary = report.get(0).length();
        List<String> oxygenList = extractOxygen(report, lengthOfBinary);
        List<String> co2List = extractCo2(report, lengthOfBinary);
        int oxygenRating = Integer.parseInt(oxygenList.get(0), 2);
        int co2Rating = Integer.parseInt(co2List.get(0), 2);
        return co2Rating * oxygenRating;
    }

    List<String> extractCo2(List<String> report, int lengthOfBinary) {
        List<String> co2List = report;
        for (int i = 0; i < lengthOfBinary; i++) {
            if (co2List.size() == 1)
                break;
            co2List = filterCo2Rating(co2List, i);
        }
        return co2List;
    }

    List<String> filterCo2Rating(List<String> report, int index) {
        List<Character> bits = extractBitsFromPosition(report, index);
        if (isMoreOnes(bits) || isEvenSplit(bits)) {
            return report.stream().filter(binary -> binary.charAt(index) == '0').collect(Collectors.toList());
        } else {
            return report.stream().filter(binary -> binary.charAt(index) == '1').collect(Collectors.toList());
        }
    }

    List<String> extractOxygen(List<String> report, int lengthOfBinary) {
        List<String> oxygenList = report;
        for (int i = 0; i < lengthOfBinary; i++) {
            if (oxygenList.size() == 1)
                break;
            oxygenList = filterOxygenRating(oxygenList, i);
        }
        return oxygenList;
    }

    List<String> filterOxygenRating(List<String> report, int index) {
        List<Character> bits = extractBitsFromPosition(report, index);
        if (isMoreOnes(bits) || isEvenSplit(bits)) {
            return report.stream().filter(binary -> binary.charAt(index) == '1').collect(Collectors.toList());
        } else {
            return report.stream().filter(binary -> binary.charAt(index) == '0').collect(Collectors.toList());
        }
    }

    private boolean isEvenSplit(List<Character> bits) {
        List<Integer> onesAndZeroes = splitOnesAndZeroes(bits);
        Integer ones = onesAndZeroes.get(0);
        Integer zeroes = onesAndZeroes.get(1);
        return ones == zeroes;
    }

    private List<Integer> splitOnesAndZeroes(List<Character> bits) {
        int ones = 0;
        int zeroes = 0;
        for (char bit : bits) {
            if (bit == '1') {
                ones++;
            } else {
                zeroes++;
            }
        }
        return Arrays.asList(ones, zeroes);
    }
}
