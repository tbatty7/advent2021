package com.battybuilds.advent2021;

import java.util.List;

public class Day03 {

    public String powerConsumptionCalculator(List<String> report) {
        String binaryNumber = report.get(0);
        int gamma = Integer.parseInt(binaryNumber, 2);
        String epsilonBinary = "";
        if (binaryNumber.charAt(0) == '1') {
            epsilonBinary+="0";
        } else {
            epsilonBinary+="1";
        }
        return epsilonBinary;
    }
}
