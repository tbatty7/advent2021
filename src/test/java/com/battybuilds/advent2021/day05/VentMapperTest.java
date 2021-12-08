package com.battybuilds.advent2021.day05;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class VentMapperTest {
    @Test
    void canMapCoordinateLine() {
        List<Integer> startingCoordinates = Arrays.asList(0, 9);
        List<VentLine> ventLines = Collections.singletonList(new VentLine(startingCoordinates, Arrays.asList(5, 9)));
        List<GridBox> ventMap = VentMapper.mapGridBoxes(ventLines);
        assertThat(ventMap.get(0).getCoords()).isEqualTo(startingCoordinates);
        assertThat(ventMap.size()).isEqualTo(6);
    }

    @Test
    void tracksGridBoxesCrossedByOneVentLine() {
        List<VentLine> ventLines = Collections.singletonList(new VentLine(Arrays.asList(0, 9), Arrays.asList(3, 9)));
        List<GridBox> ventMap = VentMapper.mapGridBoxes(ventLines);
        assertThat(ventMap.get(0).getCount()).isEqualTo(1);
        assertThat(ventMap.get(1).getCount()).isEqualTo(1);
        assertThat(ventMap.get(2).getCount()).isEqualTo(1);
        assertThat(ventMap.get(3).getCount()).isEqualTo(1);
    }

    @Test
    void tracksGridBoxesCrossedByTwoVentLines() {
        List<Integer> endingCoordinates = Arrays.asList(3, 9);
        VentLine ventline1 = new VentLine(Arrays.asList(0, 9), endingCoordinates);
        VentLine ventline2 = new VentLine(Arrays.asList(5, 9), endingCoordinates);
        List<VentLine> ventLines = Arrays.asList(ventline1, ventline2);
        List<GridBox> ventMap = VentMapper.mapGridBoxes(ventLines);
        assertThat(ventMap.get(3).getCount()).isEqualTo(2);
        assertThat(ventMap.get(3).getCoords()).isEqualTo(endingCoordinates);
    }
}