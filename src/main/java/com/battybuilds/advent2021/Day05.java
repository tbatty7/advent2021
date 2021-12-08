package com.battybuilds.advent2021;

import com.battybuilds.advent2021.day05.GridBox;
import com.battybuilds.advent2021.day05.VentLine;
import com.battybuilds.advent2021.day05.VentUtil;

import java.util.List;

import static com.battybuilds.advent2021.day05.VentMapper.mapGridBoxes;
import static com.battybuilds.advent2021.day05.VentUtil.convertToSetsOfCoordinates;

public class Day05 {
    public List<GridBox> reportVentDangers(List<String> coordinates) {
        List<List<List<Integer>>> convertedCoords = convertToSetsOfCoordinates(coordinates);
        List<VentLine> ventLines = new VentUtil().convertToLines(convertedCoords);
        return mapGridBoxes(ventLines);
    }
}
