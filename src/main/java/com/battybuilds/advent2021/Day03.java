package com.battybuilds.advent2021;

import java.util.List;

public class Day03 {

    public int powerConsumptionCalculator(List<String> report) {
        String binaryNumber = report.get(0);
        int gamma = Integer.parseInt(binaryNumber, 2);
        String epsilonBinary = "";
        for (int index = 0; index < 5; index++) {
            if (binaryNumber.charAt(index) == '1') {
                epsilonBinary+="0";
            } else {
                epsilonBinary+="1";
            }
        }
        int epsilon = Integer.parseInt(epsilonBinary, 2);
        return epsilon * gamma;
    }
}
