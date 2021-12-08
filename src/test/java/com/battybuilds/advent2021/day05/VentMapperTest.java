package com.battybuilds.advent2021.day05;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class VentMapperTest {
    @Test
    void canMapCoordinates() {
        List<VentLine> ventLines = Collections.singletonList(new VentLine(Arrays.asList(0, 9), Arrays.asList(5, 9)));
        List<GridBox> ventMap = VentMapper.mapGridBoxes(ventLines);
        GridBox expectedGridBox = new GridBox(Arrays.asList(0, 9));
        assertThat(ventMap.get(0).getCoords()).isEqualTo(expectedGridBox.getCoords());
        assertThat(ventMap.size()).isEqualTo(6);
    }
}