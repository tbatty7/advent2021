package com.battybuilds.advent2021;

import java.util.List;

public class Day02 {

    public Integer calculatePosition(List<String> directions) {
        int distance = 0;
        int depth = 0;
        for (String instruction : directions) {
            if (instruction.contains("forward")) {
                Integer number = extractNumber(instruction);
                distance += number;
            } else if (instruction.contains("down")) {
                Integer number = extractNumber(instruction);
                depth += number;
            } else {
                Integer number = extractNumber(instruction);
                depth -= number;
            }
        }
        return distance * depth;
    }

    private Integer extractNumber(String instruction) {
        String number = instruction.substring(instruction.indexOf(" ")).trim();
        return new Integer(number);
    }
}
